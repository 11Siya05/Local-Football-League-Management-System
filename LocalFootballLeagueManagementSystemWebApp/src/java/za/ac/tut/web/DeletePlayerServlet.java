package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.ejb.bl.PlayerFacadeLocal;
import za.ac.tut.entities.Player;

@WebServlet(name = "DeletePlayerServlet", urlPatterns = {"/DeletePlayerServlet"})
public class DeletePlayerServlet extends HttpServlet {
    
    @EJB
    private PlayerFacadeLocal playerFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get player ID to delete
        String playerIdStr = request.getParameter("playerId");
        
        try {
            Long playerId = Long.parseLong(playerIdStr);
            Player player = playerFacade.find(playerId);
            
            if (player != null) {
                // Handle confirmation page
                request.setAttribute("player", player);
                request.getRequestDispatcher("/player/confirm-delete-player.jsp").forward(request, response);
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
        
        // Get player ID to delete
        String playerIdStr = request.getParameter("playerId");
        String confirmed = request.getParameter("confirmed");
        
        // Only proceed if deletion was confirmed
        if ("yes".equals(confirmed)) {
            try {
                Long playerId = Long.parseLong(playerIdStr);
                Player player = playerFacade.find(playerId);
                
                if (player != null) {
                    // Delete the player
                    playerFacade.remove(player);
                    
                    request.setAttribute("message", "Player deleted successfully!");
                    request.getRequestDispatcher("/player/player-success.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Player not found!");
                    request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("error", "Error deleting player: " + e.getMessage());
                request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
            }
        } else {
            // If not confirmed, redirect back to player list
            response.sendRedirect(request.getContextPath() + "/ListPlayersServlet");
        }
    }
}