package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entities.Team;
import za.ac.tut.ejb.bl.TeamFacadeLocal;


public class DeleteTeamServlet extends HttpServlet {
    
    @EJB
    private TeamFacadeLocal teamFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get team ID to delete
        String teamIdStr = request.getParameter("teamId");
        
        try {
            Long teamId = Long.parseLong(teamIdStr);
            Team team = teamFacade.find(teamId);
            
            if (team != null) {
                // Handle confirmation page
                request.setAttribute("team", team);
                request.getRequestDispatcher("/team/confirm-delete-team.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Team not found!");
                request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid team ID format!");
            request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get team ID to delete
        String teamIdStr = request.getParameter("teamId");
        String confirmed = request.getParameter("confirmed");
        
        // Only proceed if deletion was confirmed
        if ("yes".equals(confirmed)) {
            try {
                Long teamId = Long.parseLong(teamIdStr);
                Team team = teamFacade.find(teamId);
                
                if (team != null) {
                    // Delete the team
                    teamFacade.remove(team);
                    
                    request.setAttribute("message", "Team deleted successfully!");
                    request.getRequestDispatcher("/team/team-success.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Team not found!");
                    request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("error", "Error deleting team: " + e.getMessage());
                request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
            }
        } else {
            // If not confirmed, redirect back to team list
            response.sendRedirect(request.getContextPath() + "/ListTeamsServlet");
        }
    }
}