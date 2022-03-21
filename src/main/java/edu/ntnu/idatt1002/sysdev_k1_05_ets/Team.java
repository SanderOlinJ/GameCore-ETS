package edu.ntnu.idatt1002.sysdev_k1_05_ets;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> members = new ArrayList<>();
    private String nameOfTeam;

    public Team(ArrayList<String> members, String nameOfTeam) {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Team members are required to register a team!");
        } if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        this.members = members;
        this.nameOfTeam = nameOfTeam;
    }

    public Team(String nameOfTeam) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        this.nameOfTeam = nameOfTeam;
    }


    public ArrayList<String> getMembers() {
        return members;
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

    public void setNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

}
