package javaapplication52;

public class Main {



    private int[][] adjMatrix;
    private int numVertices;

    public Main (int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void setEdge(int v1, int v2) {
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1; // assuming the friendships are bidirectional
    }

    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //Adjacency Matrix Graph 3

        int numVertices = 5;
        String[] people = {"A", "B", "C", "D", "E"};
        String[][] friendships = {{"A", "B"}, {"A", "C"}, {"B", "A"}, {"B", "C"}, {"B", "D"}, {"C", "A"}, {"C", "B"}, {"C", "E"}, {"D", "B"}, {"E", "C"}};

        Main  socialNetwork = new Main (numVertices);

        // populate the adjacency matrix
        for (String[] friendship : friendships) {
            int v1 = -1;
            int v2 = -1;
            for (int i = 0; i < numVertices; i++) {
                if (people[i].equals(friendship[0])) {
                    v1 = i;
                }
                if (people[i].equals(friendship[1])) {
                    v2 = i;
                }
                if (v1 != -1 && v2 != -1) {
                    break;
                }
            }
            socialNetwork.setEdge(v1, v2);
        }

        // print the adjacency matrix
        socialNetwork.printMatrix();
    }
}
    


