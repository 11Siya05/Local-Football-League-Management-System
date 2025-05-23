package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.ejb.bl.TeamFacadeLocal;
import za.ac.tut.entities.Team;



public class UpdateTeamServlet extends HttpServlet {
    
    @EJB
    private TeamFacadeLocal teamFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get team ID to edit
        String teamIdStr = request.getParameter("teamId");
        Long teamId = Long.parseLong(teamIdStr);
        
        Team team = teamFacade.find(teamId);
        
        if (team != null) {
            request.setAttribute("team", team);
            request.getRequestDispatcher("/team/edit-team.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Team not found!");
            request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Extract team details from request
        String teamIdStr = request.getParameter("teamId");
        Long teamId = Long.parseLong(teamIdStr);
        String teamName = request.getParameter("teamName");
        String homeGround = request.getParameter("homeGround");
        String homeJerseyColor = request.getParameter("homeJerseyColor");
        String awayJerseyColor = request.getParameter("awayJerseyColor");
        
        try {
            // Get existing team
            Team team = teamFacade.find(teamId);
            
            if (team != null) {
                // Update fields
                team.setTeamName(teamName);
                team.setHomeGround(homeGround);
                team.setHomeJerseyColor(homeJerseyColor);
                team.setAwayJerseyColor(awayJerseyColor);
                
                // Save changes
                teamFacade.edit(team);
                
                request.setAttribute("message", "Team updated successfully!");
                request.getRequestDispatcher("/team/team-success.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Team not found!");
                request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error updating team: " + e.getMessage());
            request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
        }
    }
}