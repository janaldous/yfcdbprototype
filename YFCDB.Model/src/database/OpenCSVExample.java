/**
 * 
 */
package database;

/**
 * @author Jat Torres
 * @version 2.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Member;

public class OpenCSVExample
{
	public static ArrayList<Member> records = new ArrayList<Member>();
	public static void read()
	{
		//Input file which needs to be parsed
		String fileToParse = "members_db.csv";
		BufferedReader fileReader = null;
		
		//Delimiter used in CSV file
		final String DELIMITER = ",";
		try 
		{
			String line = "";
			//Create the file reader
			fileReader = new BufferedReader(new FileReader(fileToParse));
			
			//Read the file line by line
			while ((line = fileReader.readLine()) != null) 
			{
				//Get all tokens available in line
				String[] tokens = line.split(DELIMITER);
				addMemberToList(tokens);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally 
		{
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void addMemberToList(String[] csvArray) {
		for(String token : csvArray)
		{
			//Print all tokens
			System.out.println(token);
		}
		Member m = new Member(csvArray);
	}
	
	public static void main(String args[]) {
		read();
	}
 }