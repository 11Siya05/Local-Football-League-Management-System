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

@WebServlet(name = "SearchPlayerServlet", urlPatterns = {"/SearchPlayerServlet"})
public class SearchPlayerServlet extends HttpServlet {

    @EJB
    private PlayerFacadeLocal playerFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Show search form
        request.getRequestDispatcher("/player/search-player.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get player ID to search
            String playerIdStr = request.getParameter("playerId");
            Long playerId = Long.parseLong(playerIdStr);

            // Find player by ID
            Player player = playerFacade.find(playerId);

            if (player != null) {
                // Found player, display details
                request.setAttribute("player", player);
                request.getRequestDispatcher("/player/player-details.jsp").forward(request, response);
            } else {
                // Player not found
                request.setAttribute("error", "Player with ID " + playerId + " not found!");
                request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid player ID format!");
            request.getRequestDispatcher("/player/player-error.jsp").forward(request, response);
        }
    }
}
