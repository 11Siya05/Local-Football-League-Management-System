package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.ejb.bl.PlayerFacadeLocal;
import za.ac.tut.ejb.bl.TeamFacadeLocal;
import za.ac.tut.entities.Player;
import za.ac.tut.entities.Team;

@WebServlet(name = "UpdatePlayerServlet", urlPatterns = {"/UpdatePlayerServlet"})
public class UpdatePlayerServlet extends HttpServlet {
    
    @EJB
    private PlayerFacadeLocal playerFacade;
    
    @EJB
    private TeamFacadeLocal teamFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get player ID to edit
        String playerIdStr = request.getParameter("playerId");
        
        try {
            Long playerId = Long.parseLong(playerIdStr);
            Player player = playerFacade.find(playerId);
            
            if (player != null) {
                // Load player and teams for edit form
                request.setAttribute("player", player);
                request.setAttribute("teams", teamFacade.findAll());
                request.getRequestDispatcher("/player/edit-player.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Player not found!");
                request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid player ID format!");
            request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Extract player details from request
            String playerIdStr = request.getParameter("playerId");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String ageStr = request.getParameter("age");
            String address = request.getParameter("address");
            String contactNumber = request.getParameter("contactNumber");
            String playingPosition = request.getParameter("playingPosition");
            String nationality = request.getParameter("nationality");
            String teamIdStr = request.getParameter("teamId");
            
            // Validate and convert numeric values
            Long playerId = Long.parseLong(playerIdStr);
            int age = Integer.parseInt(ageStr);
            Long teamId = Long.parseLong(teamIdStr);
            
            // Get the player and selected team
            Player player = playerFacade.find(playerId);
            Team team = teamFacade.find(teamId);
            
            if (player == null) {
                request.setAttribute("error", "Player not found!");
                request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
                return;
            }
            
            if (team == null) {
                request.setAttribute("error", "Selected team not found!");
                request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
                return;
            }
            
            // Update player fields
            player.setFirstName(firstName);
            player.setLastName(lastName);
            player.setAge(age);
            player.setAddress(address);
            player.setContactNumber(contactNumber);
            player.setPlayingPosition(playingPosition);
            player.setNationality(nationality);
            player.setTeam(team);
            
            // Save changes
            playerFacade.edit(player);
            
            // Set success message and redirect
            request.setAttribute("message", "Player updated successfully!");
            request.getRequestDispatcher("/player/player-success.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid number format: " + e.getMessage());
            request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error updating player: " + e.getMessage());
            request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
        }
    }
}