package za.ac.tut.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entities.Player;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-23T21:54:46")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, String> teamName;
    public static volatile SingularAttribute<Team, String> homeJerseyColor;
    public static volatile ListAttribute<Team, Player> players;
    public static volatile SingularAttribute<Team, String> awayJerseyColor;
    public static volatile SingularAttribute<Team, Long> id;
    public static volatile SingularAttribute<Team, String> homeGround;

}