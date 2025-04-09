package lab1;

import java.io.IOException;

public class DirectedMainGraph {
    public static void main(String[] args) throws IOException {
        Graph direcGraph = new DirectedGraph();
        if (direcGraph.loadGraph("src/test1Directed.txt")){
            direcGraph.printMatrix();
            
            System.out.println(direcGraph.checkUnGraph());
            direcGraph.addEdge(0,3);
            direcGraph.removeEdge(0,3);
            direcGraph.printMatrix();
            System.out.println("==Print Deg of Vex==");
            System.out.println(direcGraph.deg(0));
            System.out.println("==Print Sum of Deg of Graph==");
            System.out.println(direcGraph.sumDeg());
            System.out.println("==BFS==");
            direcGraph.BFS(0);
            direcGraph.resetAll();
            direcGraph.BFS(2);
            System.out.println("==DFS==");
            direcGraph.resetAll();
            direcGraph.DFSGraphRecursive(0);
            direcGraph.printList();
            direcGraph.resetAll();
            direcGraph.DFSGraphRecursive(2);
            direcGraph.printList();
            
            direcGraph.resetAll();
            direcGraph.DFSStack(2);
            System.out.println("==Xet Lien Thong==");
            direcGraph.resetAll();
            direcGraph.xetTinhLienThong();
            System.out.println("==find Path Two Point");
            direcGraph.resetAll();
            direcGraph.findPathTwoVexs(1,2);
            
        }
    }
}
