/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author siyam
 */

@Entity
@Table(name = "TEAM")
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "TEAM_NAME", unique = true, nullable = false)
    private String teamName;
    
    
    @Column(name = "HOME_GROUND")
    private String homeGround;
    
    @Column(name = "HOME_JERSEY_COLOR")
    private String homeJerseyColor;
    
    @Column(name = "AWAY_JERSEY_COLOR")
    private String awayJerseyColor;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;
    
    public Team() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public String getHomeGround() {
        return homeGround;
    }

    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }

    public String getHomeJerseyColor() {
        return homeJerseyColor;
    }

    public void setHomeJerseyColor(String homeJerseyColor) {
        this.homeJerseyColor = homeJerseyColor;
    }

    public String getAwayJerseyColor() {
        return awayJerseyColor;
    }

    public void setAwayJerseyColor(String awayJerseyColor) {
        this.awayJerseyColor = awayJerseyColor;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
   

    public Long getId() {
        return id;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.Team[ id=" + id + " ]";
    }
    
}
