package com.ipl_spring_xml;

import java.util.ArrayList;

public class ipl {
	private String team_name;
	ArrayList<String> players;
	@Override
    public String toString() {
        return "ipl [id=" + team_name + ", name=" + players + "]";
    }
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public ArrayList<String> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<String> players) {
		this.players = players;
	}
}
