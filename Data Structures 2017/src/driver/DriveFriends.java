package driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import friends.PersonList;
import friends.Person;

public class DriveFriends {
	public static void main(String [] args)
		throws IOException {
	/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char cmd=' ';
		PersonList people = new PersonList();
		
		System.out.println("options:\ntype:  for:");
		System.out.println(" q     quit");
		System.out.println(" a     add friend");
		System.out.println(" d     delete friend");
		System.out.println(" p     print friend list");
		
		while (cmd != 'q'){
			
			Person who;
			System.out.print("option: ");
			String line = br.readLine();
			if (line.length() == 0){
				cmd = ' ';
			} else {
				cmd = line.charAt(0);
			}
			
			switch (cmd){
			case 'a': who = readPerson("person", people, br);
					  who.addFriend(readPerson("friend", people, br));
					  break;
			case 'd': who =  readPerson("person", people, br);
			  	      who.removeFriend(readPerson("friend", people, br));
			  	      break;
			case 'p': who = readPerson("person", people, br);
			          // add "|" so we can see extra spaces fore and aft
			 		  System.out.println("|"+who.friendString()+"|"); 
			 		  break;
			case 'q': System.out.println("Bye.");
					  break;
			default:  System.out.println("Bad option.");
			
			}
		}
		
		*/
		
		String[] names = {"Joe", "Sue", "Sam", "Sally","Bob", "Karla"};
		PersonList people = new PersonList();
		int i,j;
		for (i=0; i < 5; i++)
		{
			for (j=i+1; j < 5; j++)
			{
				findPerson(names[i], people).addFriend(findPerson(names[j], people));				
			}
			Person who = findPerson(names[i], people);
			System.out.println(names[i]+ ": |"+who.friendString()+"|"); 
		}
		
		System.out.println("\n2"); 
		for (i=0; i < 5; i++)
		{
			for (j=i+1; j < 5; j++)
			{
				findPerson(names[i], people).removeFriend(findPerson(names[j], people));
			}
			Person who = findPerson(names[i], people);
	        System.out.println(names[i]+ ": |"+who.friendString()+"|"); 
		}
		System.out.println("\n3"); 
		for (i=0; i < 6; i++)
		{
			for (j=i+1; j < 6; j++)
			{
				findPerson(names[i], people).addFriend(findPerson(names[j], people));				
			}
			Person who = findPerson(names[i], people);
			System.out.println(names[i]+ ": |"+who.friendString()+"|"); 
		}
		System.out.println("\n4"); 
		for (i=0; i < 6; i++)
		{
			for (j=i+2; j < 6; j++)
			{
				findPerson(names[i], people).removeFriend(findPerson(names[j], people));
			}
			Person who = findPerson(names[i], people);
	        System.out.println(names[i]+ ": |"+who.friendString()+"|"); 
		}
		
		System.out.println("\n5"); 
		for (i=0; i < 6; i++)
		{
			for (j=i+2; j < 6; j++)
			{
				findPerson(names[i], people).addFriend(findPerson(names[j], people));				
			}
			Person who = findPerson(names[i], people);
			System.out.println(names[i]+ ": |"+who.friendString()+"|"); 
		}
        
		System.out.println("\n6"); 
		for (i=0; i < 6; i++)
		{
			for (j=i+3; j < 6; j++)
			{
				findPerson(names[i], people).removeFriend(findPerson(names[j], people));
			}
			Person who = findPerson(names[i], people);
	        System.out.println(names[i]+ ": |"+who.friendString()+"|"); 
		}
		
		System.out.println("\n7"); 
		for (i=0; i < 6; i++)
		{
			for (j=i+1; j < 6; j++)
			{
				findPerson(names[i], people).removeFriend(findPerson(names[j], people));
			}
			Person who = findPerson(names[i], people);
	        System.out.println(names[i]+ ": |"+who.friendString()+"|"); 
		}
	}
	
		static Person findPerson(String name, PersonList people)
			throws IOException {
			Person who = people.lookup(name);
			if (who == null){
				who = people.addPerson(name);
			}
			return who;
		}
		
		static Person readPerson(String kind, PersonList people, BufferedReader br)
			throws IOException {
			System.out.println("type "+ kind + "'s name: ");
			String name = br.readLine().trim();  // remove spaces around name
			Person who = people.lookup(name);
			if (who == null){
				who = people.addPerson(name);
			}
			return who;
		}
}