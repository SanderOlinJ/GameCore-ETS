package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> members = new ArrayList<>();
    private String nameOfTeam, teamNameAbbreviation;

    public Team(ArrayList<String> members, String nameOfTeam, String teamNameAbbreviation) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        } if (teamNameAbbreviation == null || teamNameAbbreviation.isEmpty()) {
            throw new IllegalArgumentException("Team name abbreviation is required!");
        } if (teamNameAbbreviation.length() > 6) {
            throw new IllegalArgumentException("Max length for abbreviation is 6 characters!");
        }
        this.members = members;
        this.nameOfTeam = nameOfTeam;
        this.teamNameAbbreviation = teamNameAbbreviation;
    }

    public Team(String nameOfTeam, String teamNameAbbreviation) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        } if (teamNameAbbreviation == null || teamNameAbbreviation.isEmpty()) {
            throw new IllegalArgumentException("Team name abbreviation is required!");
        } if (teamNameAbbreviation.length() > 6) {
            throw new IllegalArgumentException("Max length for abbreviation is 6 characters!");
        }
        this.nameOfTeam = nameOfTeam;
        this.teamNameAbbreviation = teamNameAbbreviation;
    }


    public ArrayList<String> getMembers() {
        return members;
    }

    public String getMembersAsText(){
        return members.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public void addMembers(ArrayList<String> members) {
        this.members.addAll(members);
    }

    public void addMember(String member){
        this.members.add(member);
    }

    public String getNameOfTeam() {
        return nameOfTeam;
    }

    public String getTeamNameAbbreviation() {
        return teamNameAbbreviation;
    }

    public void setNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    public void setTeamNameAbbreviation(String teamNameAbbreviation) {
        this.teamNameAbbreviation = teamNameAbbreviation;
    }

}
