package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class for describing a team of members taking part in the tournament
 */
public class Team {
    private ArrayList<String> members = new ArrayList<>();
    private String nameOfTeam;
    private String nameAbbr;

    /**
     * The first constructor. It takes a list of members, the team name and the team abbreviation.
     * It throws exceptions if any of the parameters are empty/null or if the length of
     * team name abbreviation is longer than 7.
     * @param members the team members
     * @param nameOfTeam the team name
     * @param nameAbbr the team abbreviation
     */
    public Team(ArrayList<String> members, String nameOfTeam, String nameAbbr) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        if (members == null || members.isEmpty()){
            throw new IllegalArgumentException("Team members are required");
        }
        if (nameAbbr == null || nameAbbr.isEmpty()){
            throw new IllegalArgumentException("Team name abbreviation is required");
        } if (nameAbbr.length() > 7) {
            throw new IllegalArgumentException("Team name abbreviation has a max length of 6 characters!");
        }
        this.members = members;
        this.nameOfTeam = nameOfTeam;
        this.nameAbbr = nameAbbr;
    }

    /**
     * The second constructor. It takes the team name and the team abbreviation.
     * It throws exceptions if any of the parameters are empty/null, and if the name abbreviation
     * is longer than 7 characters
     * @param nameOfTeam the team name
     * @param nameAbbr the team abbreviation
     */
    public Team(String nameOfTeam, String nameAbbr) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        if (nameAbbr == null || nameAbbr.isEmpty()){
            throw new IllegalArgumentException("Team name abbreviation is required");
        } if (nameAbbr.length() > 7) {
            throw new IllegalArgumentException("Team name abbreviation has a max length of 6 characters!");
        }
        this.nameOfTeam = nameOfTeam;
        this.nameAbbr = nameAbbr;
    }

    /**
     * The third constructor. It takes the team name.
     * It throws an exception if the parameter is empty/null.
     * @param nameOfTeam the team name
     */
    public Team(String nameOfTeam){
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        this.nameOfTeam = nameOfTeam;
    }

    /**
     * Returns the name abbreviation
     * @return name abbreviation
     */
    public String getNameAbbr() {
        return nameAbbr;
    }

    /**
     * Sets the name abbreviation. It throws an exception if the abbreviation is longer than
     * 7 characters
     * @param nameAbbr name abbreviation
     */
    public void setNameAbbr(String nameAbbr) {
        if (nameAbbr.length() > 7) {
            throw new IllegalArgumentException("Team name abbreviation has a max length of 6 characters!");
        }
        this.nameAbbr = nameAbbr;
    }

    /**
     * Returns the members in a list
     * @return members
     */
    public ArrayList<String> getMembers() {
        return members;
    }


    /**
     * Adds a member to the list of members
     * @param member
     */
    public void addMember(String member){
        this.members.add(member);
    }

    /**
     * Returns the name of the team
     * @return team name
     */
    public String getNameOfTeam() {
        return nameOfTeam;
    }

    /**
     * Sets the team members.
     * Throws exception if list of members is null/empty
     * @param members list of team members to be added to team
     */
    public void setMembers(ArrayList<String> members) {
        if (members == null || members.isEmpty()){
            throw new IllegalArgumentException("List of team members cannot be null or empty");
        }
        this.members = members;
    }

    /**
     * Sets the team name.
     * Throws exception if name of team is null/empty
     * @param nameOfTeam name of the team
     */
    public void setNameOfTeam(String nameOfTeam) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()){
            throw new IllegalArgumentException("Name of team cannot be null or empty");
        }
        this.nameOfTeam = nameOfTeam;
    }

    /**
     * Returns a string with information about the team
     * @return members, team name and team abbreviation as a string
     */
    @Override
    public String toString() {
        return "Team{" +
                "members=" + members +
                ", nameOfTeam='" + nameOfTeam + '\'' +
                ", nameAbbr='" + nameAbbr + '\'' +
                '}';
    }

    /**
     * Default equals method
     * @param o other team
     * @return true if equals, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(members, team.members) && Objects.equals(nameOfTeam, team.nameOfTeam)
                && Objects.equals(nameAbbr, team.nameAbbr);
    }

    /**
     * Default hashCode method
     * for comparing teams
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(members, nameOfTeam, nameAbbr);
    }
}
