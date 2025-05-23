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


@WebServlet(name = "AddTeamServlet", urlPatterns = {"/AddTeamServlet"})
public class AddTeamServlet extends HttpServlet {
    
    @EJB
    private TeamFacadeLocal teamFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Extract team details from request
        String teamName = request.getParameter("teamName");

        String homeGround = request.getParameter("homeGround");
        String homeJerseyColor = request.getParameter("homeJerseyColor");
        String awayJerseyColor = request.getParameter("awayJerseyColor");
        
        // Create and populate team entity
        Team team = new Team();
        team.setTeamName(teamName);
        team.setHomeGround(homeGround);
        team.setHomeJerseyColor(homeJerseyColor);
        team.setAwayJerseyColor(awayJerseyColor);
        
        try {
            // Save team to database using EJB
            teamFacade.create(team);
            
            // Set success message and redirect
            request.setAttribute("message", "Team added successfully!");
            request.getRequestDispatcher("team-success.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle errors
            request.setAttribute("error", "Error adding team: " + e.getMessage());
            request.getRequestDispatcher("team-error.jsp").forward(request, response);
        }
    }
}