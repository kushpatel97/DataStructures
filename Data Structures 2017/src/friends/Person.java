package friends;

public class Person {
	String name;		// the person's name
	Friend firstFriend; // the first friend in the list of this
					    // person's friends
	Person nextPerson;  // the next person in the list of people
	
	public Person(String name, Person nextPerson) {
		this.name = name;
		this.nextPerson = nextPerson;
		}

	// A string representing the list of friends of this person.  
	// O(number of friends in the list)
	public String friendString(){
			
		if (firstFriend != null){
			String friend = " ";
			Friend current = null;
			if (firstFriend != null){
				current = firstFriend;
				while(current != null){
					friend = current.who.name + " " + friend;
					current = current.nextFriend;
				}
			}	
			return friend;
		}
		else{
			return " " ;
		}
	}
	
	// add friend as a friend of this person
	// O(1)
	public void addFriend(Person friend){
		firstFriend = new Friend(friend,firstFriend);
	}
	
	// remove Person friend as a friend of this person
	// if friend is not a friend of this person, does nothing
	// O(number of friends of this person)
	public void removeFriend(Person friend){
		Friend current = firstFriend;
		Friend previous = null;
		
		while(current != null){
			if(friend.name.equals(current.who.name)){
				firstFriend = firstFriend.nextFriend;
				current = null;
			}
			
			else{
				previous = current;
				current = current.nextFriend;
			}
		}
		
	}
}
