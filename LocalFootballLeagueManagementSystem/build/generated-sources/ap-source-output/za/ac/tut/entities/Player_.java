package za.ac.tut.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entities.Team;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-23T21:54:46")
@StaticMetamodel(Player.class)
public class Player_ { 

    public static volatile SingularAttribute<Player, String> firstName;
    public static volatile SingularAttribute<Player, String> lastName;
    public static volatile SingularAttribute<Player, String> address;
    public static volatile SingularAttribute<Player, String> nationality;
    public static volatile SingularAttribute<Player, String> contactNumber;
    public static volatile SingularAttribute<Player, String> playingPosition;
    public static volatile SingularAttribute<Player, Long> id;
    public static volatile SingularAttribute<Player, Team> team;
    public static volatile SingularAttribute<Player, Integer> age;

}