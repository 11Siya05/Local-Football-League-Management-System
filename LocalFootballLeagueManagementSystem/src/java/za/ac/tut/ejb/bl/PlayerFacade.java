/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entities.Player;
import za.ac.tut.entities.Team;

/**
 *
 * @author siyam
 */
@Stateless
public class PlayerFacade extends AbstractFacade<Player> implements PlayerFacadeLocal {

    @PersistenceContext(unitName = "LocalFootballLeagueManagementSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlayerFacade() {
        super(Player.class);
    }
    
    @Override
    public List<Player> findByTeam(Team team) {
        Query query = em.createQuery("SELECT p FROM Player p WHERE p.team = :team");
        query.setParameter("team", team);
        return query.getResultList();
    }
    
    @Override
    public List<Player> findByNationality(String nationality) {
        Query query = em.createQuery("SELECT p FROM Player p WHERE p.nationality = :nationality");
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }
    
    @Override
    public List<Player> findByPosition(String position) {
        Query query = em.createQuery("SELECT p FROM Player p WHERE p.playingPosition = :position");
        query.setParameter("position", position);
        return query.getResultList();
    }
    
    @Override
    public List<Player> findByAge(int age) {
        Query query = em.createQuery("SELECT p FROM Player p WHERE p.age = :age");
        query.setParameter("age", age);
        return query.getResultList();
    }
}
