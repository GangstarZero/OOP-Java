package hackathon;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

import models.Team;
import models.User;

//Kelompok 4 :
	//	- Juwan Jatmiko _ 2602075402
	//	- Jason William _ 2602060533
	//	- Franklin Pinehas Liauw romamti_2602095650

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<User> user = new ArrayList<User>();
		ArrayList<Team> team = new ArrayList<Team>();
		BufferedReader reader = null;
		int option = 0;
		Scanner input = new Scanner(System.in);
		try {
			String line = ""; // Untuk akses User.csv dan teams.csv bisa diubah
			String file = "D:\\Codingan dan program\\JAVA\\Tugas GSLC\\user.csv";
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {    
				String[] row = line.split(",");
				String NIM = "";
				String Name = "";
				String ID = "";   
				NIM = row[0];
				Name = row[1];     
				ID = row[2];    
				User newUser = new User(NIM, Name, ID);
				user.add(newUser);
			}
		}
		catch (IOException e) {    
			e.printStackTrace();
		}
		try {
			String line = "";
			String file = "D:\\Codingan dan program\\JAVA\\Tugas GSLC\\teams.csv";
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {    
				String[] row = line.split(",");
				String ID = "";   
				String NamaTeam = "";
				ID = row[0];
				NamaTeam = row[1];       
				Team newTeam = new Team(ID, NamaTeam);
				team.add(newTeam);
			}
		}
		catch (IOException e) {    
			e.printStackTrace();
		}
		while(option != 4)
		{
//			for(int i = 0 ; i < team.size(); i++)
//			{
//				System.out.println(team.get(i).ID + "," + team.get(i).NamaTeam);
//			}
			System.out.println("1. Menu Utama");
			System.out.println("2. Insert Data");
			System.out.println("3. Show");
			System.out.println("4. Exit");
			System.out.print(">> ");
			option = input.nextInt();
			input.nextLine();
			
			if(option == 1 )
			{
				continue;
			}
			if(option == 2)
			{
				int insertOption = 0;
				System.out.println("Which Table to insert? 1. User, 2. Team");
				System.out.print(">> ");
				insertOption = input.nextInt();
				input.nextLine();
				if(insertOption == 1)
				{
					String Name = "";
					String NIM = "";
					String TeamName = "";
					System.out.print("Add name: ");
					Name = input.nextLine();
					System.out.print("Add NIM: ");
					NIM = input.nextLine();
					System.out.print("TeamName: ");
					TeamName = input.nextLine();
					int condition = 0;
					for(int i = 0; i < team.size(); i++)
					{
						if(TeamName.compareTo(team.get(i).NamaTeam) == 0)
						{
							condition = 1;
							int count = 0;
							System.out.println("hi");
							String TeamID = team.get(i).ID;
							for(int j = 0; j < user.size(); j++)
							{
								if(TeamID.compareTo(user.get(j).ID)== 0) {
									count++;
								}
							}
							if(count > 2)
							{
								System.out.println("hi");
								System.out.println("Error : Team Full");
								break;
							}
							else 
							{
								User newUser = new User(NIM, Name, TeamID);
								user.add(newUser);
								break;
							}
						}
					}
					
					if(condition == 0)
					{
						Integer NewID = team.size();
						String NewTeamID = String.valueOf(NewID);
						Team newTeam = new Team(NewTeamID, TeamName);
						team.add(newTeam);
						User newUser = new User(NIM, Name, NewTeamID);
						user.add(newUser);
						System.out.println("User Created!");
					}		
				}
			}
			if(option == 3)
			{
				System.out.println("What to show? 1. User 2. Team");
				int optionShow = 0;
				System.out.print(">> ");
				optionShow = input.nextInt();
				input.nextLine();
				
				if(optionShow == 1)
				{
					for(int i = 0 ; i < team.size(); i++)
					{
						System.out.println(user.get(i).NIM + "," + user.get(i).Name + "," + user.get(i).ID);
					}
				}
				if(optionShow == 2)
				{
					for(int i = 0 ; i < team.size(); i++)
					{
						System.out.println(team.get(i).ID + "," + team.get(i).NamaTeam);
					}
				}
			}
		}
		
		String csvFilePath = "D:\\Codingan dan program\\JAVA\\Tugas GSLC\\user.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            // Writing data to CSV file
        	for(int i = 0; i < user.size(); i++)
        	{
        		String header = user.get(i).NIM + "," + user.get(i).Name + "," + user.get(i).ID +"\n";
        		writer.write(header);
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String csvFilePath1 = "D:\\Codingan dan program\\JAVA\\Tugas GSLC\\teams.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath1))) {
            // Writing data to CSV file
        	for(int i = 0; i < team.size(); i++)
        	{
        		String header = team.get(i).ID + "," + team.get(i).NamaTeam + "\n";
        		writer.write(header);
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
//		Connection connect = new Connection();
//		String NIM = "2602060533";
//		String Name = "Jason WIilliam Santono";
//		int ID = 1;
//		
//		connect.insertUser(NIM, Name, ID);
		
	}

}
