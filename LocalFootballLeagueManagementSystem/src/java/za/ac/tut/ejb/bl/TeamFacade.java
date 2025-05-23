/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entities.Team;

/**
 *
 * @author siyam
 */
@Stateless
public class TeamFacade extends AbstractFacade<Team> implements TeamFacadeLocal {

    @PersistenceContext(unitName = "LocalFootballLeagueManagementSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamFacade() {
        super(Team.class);
    }
    @Override
    public Team findByName(String teamName) {
        try {
            Query query = em.createQuery("SELECT t FROM Team t WHERE t.teamName = :teamName");
            query.setParameter("teamName", teamName);
            return (Team) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
