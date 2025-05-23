package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
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

@WebServlet(name = "ListPlayersServlet", urlPatterns = {"/ListPlayersServlet"})
public class ListPlayersServlet extends HttpServlet {
    
    @EJB
    private PlayerFacadeLocal playerFacade;
    
    @EJB
    private TeamFacadeLocal teamFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<Player> players;
            
            // Check for filter parameters
            String teamIdStr = request.getParameter("teamId");
            String nationality = request.getParameter("nationality");
            String position = request.getParameter("position");
            String ageStr = request.getParameter("age");
            
            // Apply filters if provided
            if (teamIdStr != null && !teamIdStr.isEmpty()) {
                Long teamId = Long.parseLong(teamIdStr);
                Team team = teamFacade.find(teamId);
                players = playerFacade.findByTeam(team);
                request.setAttribute("filterType", "team");
                request.setAttribute("filterValue", team.getTeamName());
            } else if (nationality != null && !nationality.isEmpty()) {
                players = playerFacade.findByNationality(nationality);
                request.setAttribute("filterType", "nationality");
                request.setAttribute("filterValue", nationality);
            } else if (position != null && !position.isEmpty()) {
                players = playerFacade.findByPosition(position);
                request.setAttribute("filterType", "position");
                request.setAttribute("filterValue", position);
            } else if (ageStr != null && !ageStr.isEmpty()) {
                int age = Integer.parseInt(ageStr);
                players = playerFacade.findByAge(age);
                request.setAttribute("filterType", "age");
                request.setAttribute("filterValue", ageStr);
            } else {
                // No filters - get all players
                players = playerFacade.findAll();
                request.setAttribute("filterType", "none");
            }
            
            // Set players in request and forward to JSP
            request.setAttribute("players", players);
            request.getRequestDispatcher("/player/list-players.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid number format: " + e.getMessage());
            request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error retrieving players: " + e.getMessage());
            request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
        }
    }
}