package hackathon;

import java.io.BufferedWriter;
import models.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import models.User;

public class Connection{
	
	public void insertUser(String NIM, String Name, String ID) throws FileNotFoundException {
		String csvFilePath = "D:\\Codingan dan program\\JAVA\\Tugas GSLC\\user.csv";
		User newUser = new User(NIM, Name, ID);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            // Writing data to CSV file
            String header = NIM + "," + Name + "," + ID +"\n";
            writer.write(header);

            // You can write more rows as needed
            System.out.println(header);
            System.out.println("Data written to CSV file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
