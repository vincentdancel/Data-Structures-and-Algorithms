package graph3list_dancel;

import java.util.*;
public class Graph3List_Dancel {
    
    static class Node {
        String data;
        
        Node (String data) { 
           this.data=data; 
        }
    }
    
    static class Graph {
        ArrayList<LinkedList<Node>> adjList; 
        
        Graph(){
		adjList = new ArrayList<>(); 
	}
	
	public void addNode(Node node) { 
	
		LinkedList<Node> tempList = new LinkedList<>(); 
		
		tempList.add(node); 
		
		adjList.add(tempList); 
	}
        
	public void addEdge(int source, int destination) { 
               
		LinkedList<Node> tempList = adjList.get(source); 
		
                Node destiNode = adjList.get(destination).get(0); 
                
		tempList.add(destiNode); 
	}
        
	public void printAdjList () {
            for (int i = 0; i < adjList.size(); i++) {
                
		LinkedList<Node> tempList=adjList.get(i);  
                    for (int j = 0; j < tempList.size(); j++) { 
                    
			System.out.print(tempList.get(j).data); 
			
			if (j<tempList.size()-1) { 
                            System.out.print(" --> "); 
                        }
                    }
                    System.out.println();
            }	
        }
    }
    
    
    public static void main(String[] args) {
        Graph graph = new Graph(); 
	
   	graph.addNode(new Node("NY")); 
        graph.addNode(new Node("LA")); 
        graph.addNode(new Node("CHI")); 
        graph.addNode(new Node("DAL"));
        graph.addNode(new Node("MIA")); 
                

	   graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
        graph.addEdge(4, 1); 
        graph.addEdge(1, 3);

        System.out.println("Direct Flights: ");
        graph.printAdjList();	
    }
}