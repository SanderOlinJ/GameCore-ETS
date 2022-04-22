package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    private ArrayList<String> members = new ArrayList<>();
    private String nameOfTeam;
    private String nameAbbr;


    public Team(ArrayList<String> members, String nameOfTeam, String nameAbbr) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        if (members == null || members.isEmpty()){
            throw new IllegalArgumentException("Team members are required");
        }
        if (nameAbbr == null || nameAbbr.isEmpty()){
            throw new IllegalArgumentException("Team name abbreviation is required");
        } if (nameAbbr.length() > 6) {
            throw new IllegalArgumentException("Team name abbreviation has a max length of 6 characters!");
        }
        this.members = members;
        this.nameOfTeam = nameOfTeam;
        this.nameAbbr = nameAbbr;
    }

    public Team(String nameOfTeam, String nameAbbr) {
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        if (nameAbbr == null || nameAbbr.isEmpty()){
            throw new IllegalArgumentException("Team name abbreviation is required");
        } if (nameAbbr.length() > 6) {
            throw new IllegalArgumentException("Team name abbreviation has a max length of 6 characters!");
        }
        this.nameOfTeam = nameOfTeam;
        this.nameAbbr = nameAbbr;
    }

    public Team(String nameOfTeam){
        if (nameOfTeam == null || nameOfTeam.isEmpty()) {
            throw new IllegalArgumentException("Team name is required!");
        }
        this.nameOfTeam = nameOfTeam;
    }

    public String getNameAbbr() {
        return nameAbbr;
    }

    public void setNameAbbr(String nameAbbr) {
        if (nameAbbr.length() > 6) {
            throw new IllegalArgumentException("Team name abbreviation has a max length of 6 characters!");
        }
        this.nameAbbr = nameAbbr;
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

    public void setNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    @Override
    public String toString() {
        return "Team{" +
                "members=" + members +
                ", nameOfTeam='" + nameOfTeam + '\'' +
                ", nameAbbr='" + nameAbbr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(members, team.members) && Objects.equals(nameOfTeam, team.nameOfTeam) && Objects.equals(nameAbbr, team.nameAbbr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members, nameOfTeam, nameAbbr);
    }
}
