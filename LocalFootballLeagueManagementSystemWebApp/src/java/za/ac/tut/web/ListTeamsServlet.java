package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.ejb.bl.TeamFacadeLocal;
import za.ac.tut.entities.Team;


@WebServlet(name = "ListTeamsServlet", urlPatterns = {"/ListTeamsServlet"})
public class ListTeamsServlet extends HttpServlet {
    
    @EJB
    private TeamFacadeLocal teamFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Retrieve all teams from database
            List<Team> teams = teamFacade.findAll();
            
            // Set teams in request and forward to JSP
            request.setAttribute("teams", teams);
            request.getRequestDispatcher("/team/list-teams.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle errors
            request.setAttribute("error", "Error retrieving teams: " + e.getMessage());
            request.getRequestDispatcher("/team/team-error.jsp").forward(request, response);
        }
    }
}