package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import resto.Employee;
import resto.Menu;
import resto.TableType;
import resto.TheResto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<TheResto> r = new ArrayList<TheResto>();
		ArrayList<Employee> e = new ArrayList<Employee>();
		
		String[] restoLocation = {"Bandung", "Jakarta", "Bali","Surabaya", "Samarinda","Padang"};
		for(int i = 0; i < 6; i++)
		{
			TheResto tr = new TheResto();
			tr.location = restoLocation[i];
			r.add(tr);
//			System.out.println(r.get(i).location);
		}
		
		String[] Menu = {"Nasi Goreng", "Bakmi Goreng", "Ayam Goreng"};
		String[] Price = {"20000", "30000","25000"};
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				Menu m = new Menu();
				m.id = j;
				m.menuName = Menu[j];
				m.price = Price[j];
				r.get(i).m.add(m);
			}
		}
		
		String[] Name = {"Budi", "Udin", "Yanto", "Ani", "Edan", "Supri"};
		
		for(int i = 0; i < 6; i++)
		{
			Employee ne = new Employee();
			ne.name = Name[i];
			ne.location = restoLocation[i];
			e.add(ne);
//			System.out.println(r.get(i).location);
		}
		Scanner input = new Scanner(System.in);
		String location = "";
		int at = 0;
		int option = 0;
		int tf = 0;
		
		
			System.out.print("Input Employee Name: ");
			String name = input.nextLine();
		
			for(int i = 0; i < e.size(); i++)
			{
					if(e.get(i).equals(name))
					{
						location = e.get(i).location;
						at = i;
						 
					}
			}
		
		
		
		while(option != 3)
		{
			System.out.println("1. Reserve");
			System.out.println("2. Show Menu");
			System.out.println("3. Exit");
			System.out.print(">> ");
			option = input.nextInt();
			input.nextLine();
			
			if(option == 1)
			{
				System.out.println("How many people? ");
				System.out.println(">> ");
				int people = input.nextInt();
				input.nextLine();
				TableType t = new TableType();
				t.tableType(people);
			}
			
			if(option == 2)
			{
				for(int i = 0; i < r.get(at).m.size(); i++)
				{
					System.out.print(r.get(at).m.get(i).menuName + " " + r.get(at).m.get(i).price);
					System.out.println();
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String connectionString = "jdbc:sqlserver://DESKTOP-06DBBO2;Database=Restaurant;IntegratedSecurity=false";
//		
//		try {
//			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection connect = DriverManager.getConnection(connectionString);
//			
//			System.out.println("Connected");
//			
//		}catch(SQLException e)
//		{
//			System.out.println("Error");
//			e.printStackTrace();
//		}
	}

}
