package models;

import java.util.ArrayList;

public class Team {

    private String name;
    private String cause;
    private int maxMembers;

    private  static ArrayList<Team>  allTeams = new ArrayList<>();


    public Team(String name, int maxMembers, String cause) {
        this.name = name;
        this.maxMembers = maxMembers;
        this.cause = cause;
        allTeams.add(this);

    }

    public static ArrayList<Team> getAllTeams()  {
        return allTeams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}