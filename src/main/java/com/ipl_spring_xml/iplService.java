package com.ipl_spring_xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class iplService {
	private ipl team;
	Map<String , ipl> database = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	public ipl getTeam() {
		return team;
	}
	public void setTeam(ipl team) {
		this.team = team;
	}
	public Map<String, ipl> getDatabase() {
		return database;
	}
	public void setDatabase(Map<String, ipl> database) {
		this.database = database;
	}
	public void display() {
		System.out.println("--- Team Details ---");
		for(ipl ip : database.values()) {
			System.out.println(ip.getTeam_name() + "  :  "+ip.getPlayers());
		}
	}
	public void addDetails(ipl details) {
		database.put(team.getTeam_name(), details);
	}
	public ipl getIpl(String team_name) {
		return database.get(team_name);
	}
	public void playersDetailsByTeam(String team_name) {
		System.out.print("Enter Team's Name : ");
		String team_naam = sc.next();
		ipl existed_team = getIpl(team_naam);
		if(existed_team!=null) {
			System.out.println(existed_team.getTeam_name() + "   : " +existed_team.getPlayers());
		}
	}
	public void runMenu() {
		boolean end = false;
		while(!end) {
			System.out.println("----------------");
			System.out.println("1 : Add Team");
			System.out.println("2 : Add Player");
			System.out.println("3 : Update Player");
			System.out.println("4 : Display Team's Details");
			System.out.println("5 : Display All");
			System.out.println("6 : Exit");
			System.out.print("Enter Ur choice : ");
			int choice = sc.nextInt();
			System.out.println("------------------");
			switch(choice) {
			case 1 :
				addTeam();
				break;
			case 2 :
				addPlayer();
				break;
			case 3 :
				updatePlayer();
				break;
			case 4 :
				displayTeam();
				break;
			case 5 :
				display();
				break;
			case 6 :
				end = true;
				break;
			default:
				System.out.println("Choose a valid option !!");
			}
		}
	}
	public void addTeam() {
		team = new ipl(); 
		System.out.print("Enter Team's Name : ");
		String naam = sc.next();
		team.setTeam_name(naam);
		ArrayList<String> player = new ArrayList<>();
		team.setPlayers(player);
		addDetails(team);
		System.out.println("Team's Name is added Successfully !");
	}
	public void addPlayer() {
		//team = new ipl();
		ArrayList<String> player;
		System.out.print("Enter the player's team Name : ");
		String team_naam = sc.next();
		ipl existed_team = getIpl(team_naam);
		if(existed_team!=null) {
			player = team.getPlayers();
			System.out.print("Enter Player's Name : ");
			player.add(sc.next());
			boolean next = false;
			while(!next) {
				System.out.print("Do you want to continue [0 , 1]: ");
				int con = sc.nextInt();
				if(con==0) {
					next = true;
				}
				else {
					System.out.print("Enter Player's Name : ");
					player.add(sc.next());
				}
			}
			addDetails(team);
			System.out.println("Player Added Successfully!!");
		}
		else {
			System.out.println("Team with "+team_naam + " does not exists");
		}
	}
	public void displayTeam() {
		System.out.print("Enter Team's name : ");
		String team_naam = sc.next();
		ipl existed_team = getIpl(team_naam);
		if(existed_team!=null) {
			System.out.println(existed_team.getTeam_name() + "  :  "+existed_team.getPlayers());
		}
		else {
			System.out.println("Team with "+team_naam + " does not exists!!");
		}
	}
	public void updatePlayer() {
		System.out.print("Enter Team's Name : ");
		String team_naam = sc.next();
		ipl existed = getIpl(team_naam);
		if(existed!=null) {
			ArrayList<String> existed_player = existed.getPlayers();
			System.out.print("Enter Player's Name : ");
			String player_naam = sc.next();
			if(existed_player.contains(player_naam)) {
				System.out.print("Enter New Name : ");
				String new_name = sc.next();
				existed_player.set(existed_player.indexOf(player_naam), new_name);
				System.out.println("Player's Details Updated Successfully");
			}
			else {
				System.out.println("Player with "+player_naam + "  does not exists");
			}
		}
		else {
			System.out.println("Team with "+team_naam + " does not exists!!");
		}
	}
}
