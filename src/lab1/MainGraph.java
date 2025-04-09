package lab1;

import java.io.IOException;

public class MainGraph {
    public static void main(String[] args) throws IOException {
        Graph unGraph = new UnGraph();
        
//        Graph directedGraph = new DirectedGraph();
//        if (unGraph.loadGraph(unGraph.path)){
//            unGraph.printMatrix();
//            System.out.println(unGraph.checkValid());
//
//            unGraph.addEdge( 0,1);
//            unGraph.printMatrix();
//
//            unGraph.addEdge( 1,10);
//            unGraph.printMatrix();
//
//            unGraph.removeEdge( 0,1);
//            unGraph.printMatrix();
//
//            unGraph.removeEdge( 3,2);
//            unGraph.printMatrix();
//
//            System.out.println("deg: " + unGraph.deg(1));
//            System.out.println("SumDeg " + unGraph.sumDeg());
//            System.out.println("Number Edges: " + unGraph.numberEdges());
//        }
//        if (unGraph.loadGraph("src/test4.txt")){
//            System.out.println("====Print Matrix===");
//            unGraph.printMatrix();
//            System.out.println(unGraph.checkConnect());
//            unGraph.resetAll();
//            unGraph.DFSGraphRecursive(0);
//            unGraph.printList();
//            unGraph.resetAll();
//            System.out.println("===Tinh Lien Thong===");
//            unGraph.xetTinhLienThong();
//
//            System.out.println("===Print BFS===");
//            unGraph.resetAll();
//            unGraph.BFS(0);
//            unGraph.printList();
//
//            System.out.println("===Print DFSStack with Recursive===");
//            unGraph.resetAll();
//            unGraph.DFSGraphRecursive(0);
//            unGraph.printList();
//
//            System.out.println("===Print DFSStack with Stack===");
//            unGraph.resetAll();
//            unGraph.DFSStack(0);
//
//            System.out.println("===findPath");
//            unGraph.resetAll();
//            unGraph.findPathTwoVexs(0,7);
//
//            System.out.println("===Check Luong Phan===");
//            unGraph.resetAll();
//            System.out.println(unGraph.checkBipartiteGraph(0));
//            unGraph.resetAll();
//            unGraph.removeEdge( 6,7);
//            System.out.println(unGraph.checkBipartiteGraph(0));
//
//
//        }
//        if (unGraph.loadGraph("src/test4.txt")){
//
//            System.out.println("==Check is Euler Graph==");
//            System.out.println(unGraph.isEulerGraph());
//            unGraph.resetAll();
////
//            System.out.println("==Check is Half Euler Graph==");
//            System.out.println(unGraph.isHalfEulerGraph());
//            unGraph.resetAll();
//
//            System.out.println("==Print Euler Cycle==");
//            unGraph.findEulerCycle(0);
//            unGraph.resetAll();
//
//            System.out.println("==Print Euler Path==");
//            unGraph.findHalfEulerGraph();
//            unGraph.resetAll();
//        }
//
//        if (unGraph.loadGraph("src/test7.txt")){
//            System.out.println("==All Euler==");
//            unGraph.alogEuler(5);
//            unGraph.resetAll();
////
//            System.out.println("===algoHamilton===");
//            unGraph.algoHamilton(1);
//        }
        if (unGraph.loadGraph("src/test9.txt")){
            unGraph.dfsMTS(0);
            unGraph.resetAll();
            unGraph.bfsMTS(0);
        }
    
    }
}
