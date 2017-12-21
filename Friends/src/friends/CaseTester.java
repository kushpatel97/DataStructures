package friends;

import java.io.*;
import java.util.*;

public class CaseTester {
    public static void main(String[] args) {
        Graph friends = createGraph("graph1.txt");
        //printMembers(friends);
        if (friends == null) return;
        
        //System.out.println("Shortest Chain: ");
        //System.out.println(Friends.shortestChain(friends, "sam", "aparna"));
        System.out.println(Friends.cliques(friends, "rutgers"));

//
//        System.out.println("\n\n\nconnectors: ");
//        Friends.connectors(friends);


    }



    public static Graph createGraph(String file) {
        Scanner sc;
        try {
            sc = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("FILE ( " + file + ") NOT FOUND");
            return null;
        }
        Graph friends;
        if (sc != null) {
            friends = new Graph(sc);
        }
        else {
            return null;
        }
        return friends;
    }

    public static void printMembers(Graph friends) {
        Person[] members = friends.members;
        for (int i = 0; i < members.length; i++) {
            Person person = members[i];
            System.out.println(i + " " + person.name);
            for (Friend front = person.first; front != null; front = front.next) {
                System.out.println("  | -- " + members[front.fnum].name);
            }
            System.out.println();
        }
    }
}



