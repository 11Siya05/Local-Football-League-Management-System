/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author siyam
 */
@Entity
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    
    @Column(name = "AGE")
    private Integer age;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    
    @Column(name = "PLAYING_POSITION")
    private String playingPosition;
    
    @Column(name = "NATIONALITY")
    private String nationality;
    
    
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    
    public Player() {
    }

    public Player(Long id, String firstName, String lastName, Integer age, String address, String contactNumber, String playingPosition, String nationality, Team team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.contactNumber = contactNumber;
        this.playingPosition = playingPosition;
        this.nationality = nationality;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPlayingPosition() {
        return playingPosition;
    }

    public void setPlayingPosition(String playingPosition) {
        this.playingPosition = playingPosition;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.Player[ id=" + id + " ]";
    }
    
}
