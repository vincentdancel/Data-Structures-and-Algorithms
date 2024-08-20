package javaapplication8;

public class Main {

    // Add directed edge
    static void addDirectedEdge(String[][] am, int[][] edgeCount, char source, char destination) {
        am[source - 'A'][edgeCount[source - 'A'][0]++] = String.valueOf(destination); // Add edge from source to destination
    }

    static void printGraph(String[][] am, int[][] edgeCount) {
        for (int i = 0; i < am.length; i++) {
            System.out.println("\nVertex " + (char) ('A' + i) + ":");
            for (int j = 0; j < edgeCount[i][0]; j++) {
                System.out.print(" -> " + am[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create the graph
        int V = 6;
        int[][] edgeCount = new int[V][1]; // Keeps track of edges for each vertex
        String[][] am = new String[V][V - 1]; // Assuming maximum possible edges per vertex is V-1

        for (int i = 0; i < V; i++) {
            edgeCount[i][0] = 0; // Initialize edge count for each vertex
        }

        // Add directed edges
        addDirectedEdge(am, edgeCount, 'A', 'B');
        addDirectedEdge(am, edgeCount, 'A', 'D');
        addDirectedEdge(am, edgeCount, 'A', 'E');
        addDirectedEdge(am, edgeCount, 'B', 'C');
        addDirectedEdge(am, edgeCount, 'C', 'F');
        addDirectedEdge(am, edgeCount, 'D', 'E');
        addDirectedEdge(am, edgeCount, 'E', 'C');
        addDirectedEdge(am, edgeCount, 'E', 'F');

        printGraph(am, edgeCount);
    }
}
