package friends;

// represents a list of people as a linked list of Person objects
public class PersonList {
	Person firstPerson;		// First Person object in the list

	public PersonList( ) {
		this.firstPerson = null;
	}
	
	// finds Person object in this list with given name
	// if none exists, returns null.  Runs in O(number of persons in this list) 
	public Person lookup(String name){
	
	Person current = firstPerson;
		while(current != null){
			if(current.name.equals(name)){
				return current;
			}
			current = current.nextPerson;
		}
	return null;
}
	
	// creates a new Person object with name and adds it to the list of 
	// Person objects.  Runs in O(1)
	public Person addPerson(String name){

		Person newPerson = new Person(name,null);
		newPerson.nextPerson = firstPerson;
		firstPerson = newPerson;		
		return newPerson;
	}

}
