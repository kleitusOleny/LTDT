package lab1;

import java.io.IOException;

public class MainGraph {
    public static void main(String[] args) throws IOException {
        Graph unGraph = new UnGraph();
        Graph directedGraph = new DirectedGraph();
//        if (unGraph.loadGraph(unGraph.path)){
//            unGraph.printMatrix();
//            System.out.println(unGraph.checkValid());
//
//            unGraph.addEdge(unGraph.adjMatrix, 0,1);
//            unGraph.printMatrix();
//
//            unGraph.addEdge(unGraph.adjMatrix, 1,10);
//            unGraph.printMatrix();
//
//            unGraph.removeEdge(unGraph.adjMatrix, 0,1);
//            unGraph.printMatrix();
//
//            unGraph.removeEdge(unGraph.adjMatrix, 3,2);
//            unGraph.printMatrix();
//
//            System.out.println("deg: " + unGraph.deg(1));
//            System.out.println("SumDeg " + unGraph.sumDeg());
//            System.out.println("Number Edges: " + unGraph.numberEdges());
//        }
        
        if (unGraph.loadGraph(unGraph.path)){
            unGraph.printMatrix();
            System.out.println(unGraph.checkConnect());
            
        }
    }
}
