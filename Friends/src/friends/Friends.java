package friends;

import structures.Queue;
import structures.Stack;

import java.util.*;

public class Friends {

	/**
	 * Finds the shortest chain of people from p1 to p2.
	 * Chain is returned as a sequence of names starting with p1,
	 * and ending with p2. Each pair (n1,n2) of consecutive names in
	 * the returned chain is an edge in the graph.
	 * 
	 * @param g Graph for which shortest chain is to be found.
	 * @param p1 Person with whom the chain originates
	 * @param p2 Person at whom the chain terminates
	 * @return The shortest chain from p1 to p2. Null if there is no
	 *         path from p1 to p2
	 */
	public static ArrayList<String> shortestChain(Graph g, String p1, String p2) {
		ArrayList<String> shortestpath = new ArrayList<String>();
		Queue<Person> q = new Queue<Person>();
		Person[] members = g.members;
		int[] inGraph = new int[g.members.length];	//inTree determines if a Person is in a tree
		
		int index = 0;

		
//		System.out.println(g.members.length);
		for(int i=0; i < inGraph.length; i++) {
			inGraph[i] = -1;			// -1 means that the Person has not been visited
		}
		
		Person src = null;
		Person dest = null;
		for(int i=0; i < members.length; i++) {
			if(members[i].name.equals(p1)) {
				src = g.members[i];	//Create a src reference point
				inGraph[i] = 0;
			}
			if(members[i].name.equals(p2)) {
				dest = g.members[i];	//Create a dest reference point
				index = i;
			}
		}
		
		//BFS
		BFS(q, src, dest, inGraph, g);
		
		int distance = inGraph[index];
		//If no continuous path from src to dest then return null
		if(distance == -1) {
			return null;	
		}
		Person nextmem = members[index];
		int childindex = index;
		shortestpath.add(0, dest.name);
		
		for(int i = 0; i < distance; i++) { 
			for(Friend ptr = nextmem.first; ptr != null; ptr = ptr.next) {
				if(inGraph[ptr.fnum] == (inGraph[childindex]-1)) {
					Person temp = members[ptr.fnum];
					shortestpath.add(0, temp.name);
					nextmem = temp;
					childindex = ptr.fnum;
					break;
				}
			}
		}
		return shortestpath;
	}
	


	
	/**
	 * Finds all cliques of students in a given school.
	 * 
	 * Returns an array list of array lists - each constituent array list contains
	 * the names of all students in a clique.
	 * 
	 * @param g Graph for which cliques are to be found.
	 * @param school Name of school
	 * @return Array list of clique array lists. Null if there is no student in the
	 *         given school
	 */
	public static ArrayList<ArrayList<String>> cliques(Graph g, String school) {
		ArrayList<ArrayList<String>> cliques = new ArrayList<ArrayList<String>>();
		boolean[] inGraph = new boolean[g.members.length];	// Keeps track to see if 
		boolean flag = false;
		
		for(int i = 0; i < inGraph.length; i++) {
			inGraph[i] = false;
		}

		Person src = new Person();
		
		for(int i = 0; i < g.members.length; i++) {
			if(g.members[i].school != null) {
				if(g.members[i].school.equals(school) && !inGraph[i]) {
					flag = true;
					ArrayList<String> grouped = new ArrayList<String>();
					src = g.members[i];
					grouped.add(src.name);
					cliques.add(DFS(i, inGraph, src, g, school, grouped));
				}
			}
			else {
				continue;
			}
		}
		
		if(flag == false) {
			return null;
		}
		
		return cliques;
		
	}
	
	/**
	 * Finds and returns all connectors in the graph.
	 * 
	 * @param g Graph for which connectors needs to be found.
	 * @return Names of all connectors. Null if there are no connectors.
	 */
	public static ArrayList<String> connectors(Graph g) {
		ArrayList<String> connectors = new ArrayList<String>();
		Person[] members = g.members;
		int[][] visited = new int[members.length][4];
		boolean flag = false;
		
		while(findIndex(visited) != -1) {
			int index = findIndex(visited);
			visited = connectedDFS(visited, members, index, 1);
			
			int counter = 0;
			
			for(Friend ptr = g.members[index].first; ptr != null; ptr = ptr.next) {
				counter++;
				
			}
			if(counter < 2) {
				visited[index][3] = 0;
			}
			if(visited[index][3] != 0) {
				if((visited[index][2] / visited[index][3]) > 2) {
					visited[index][3] = 0;
				}
			}
		}
		for(int i = 0; i < visited.length; i++) {
			if(visited[i][3] > 0) {
				flag = true;
				connectors.add(g.members[i].name);
			}
		}
		if(flag == false) {
			return null;
		}
		return connectors;
		
	}
	
	private static int findIndex(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i][2] == 0) {
				return i;
			}
		}
		return -1;
	}
	
	private static int[][] connectedDFS(int[][] visited, Person[] members,int index, int dfs) {
		visited[index][0] = dfs;
		visited[index][1] = dfs;
		visited[index][2]++;
		 
		for(Friend ptr = members[index].first; ptr != null; ptr = ptr.next) {
			if(visited[ptr.fnum][2] > 0) {
				visited[index][1] = Math.min(visited[index][1], visited[ptr.fnum][0]);
				visited[ptr.fnum][2]++;
				continue;
			}
			visited = connectedDFS(visited, members, ptr.fnum, dfs+1);
			int dfsNum = visited[index][0];
			int back = visited[ptr.fnum][1];
			if(visited[index][0] > visited[ptr.fnum][1]) {
				visited[index][1] = Math.min(visited[index][1], visited[ptr.fnum][1]);
			}
			else {
				visited[index][3]++;
			}
		}
		
		
		return visited;
	}


	private static void BFS(Queue<Person> q, Person src, Person dest, int[] inGraph, Graph g) {
		q.enqueue(src);
		int count = 0;	// Used to determine the level of a Person in the Graph
		while(!q.isEmpty()) {
			ArrayList<Person> level = new ArrayList<Person>();
			
			while(!q.isEmpty()) {
				level.add(q.dequeue());
			}
			count++;
			
			for(Person person : level) {
				for(Friend ptr = person.first; ptr != null; ptr = ptr.next) {
					if(inGraph[ptr.fnum] != -1) {
						continue;
					}
					inGraph[ptr.fnum] = count;
					Person children = g.members[ptr.fnum];
					q.enqueue(children);
				}
			}
		}		
	}
	
	private static ArrayList<String> DFS(int index, boolean inGraph[], Person src, Graph g, String school, ArrayList<String> grouped){
		inGraph[index] = true;
		Person[] members = g.members;
		for(Friend ptr = src.first; ptr != null; ptr = ptr.next) {
			if(!inGraph[ptr.fnum]) {
				if(members[ptr.fnum].school != null) {
					if(members[ptr.fnum].school.equals(school)){
						grouped.add(members[ptr.fnum].name);
						DFS(ptr.fnum, inGraph, members[ptr.fnum], g, school, grouped);
					}
				}
			}
			else {
				continue;
			}
		}
		
		return grouped;
		
	}
}