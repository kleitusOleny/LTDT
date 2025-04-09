package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//src\test2.txt
public abstract class Graph {
    protected int numberVexs;
    protected int[][] adjMatrix;
    protected String path = "src/test1.txt";
    protected boolean[] track;
    protected List<Integer> list = new ArrayList<>();
    protected Stack<Integer> tour = new Stack<>();
    protected int[] x;
    protected boolean print;
    
    public Graph() {
    }
    
    public Graph(int numberVexs, int[][] adjMatrix) {
        this.numberVexs = numberVexs;
        this.adjMatrix = adjMatrix;
    }
    
    public boolean loadGraph(String pathFile) throws IOException {
        File input = new File(pathFile);
        if (!input.exists()) {
            System.out.println("Not correct! File not found");
            return false;
        } else {
            
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            //read first line in file -> number of Vex
            String firstLine = reader.readLine();
            this.numberVexs = Integer.parseInt(firstLine);
            track = new boolean[numberVexs];
            this.adjMatrix = new int[numberVexs][numberVexs];
            
            String line = "";
            int indexLines = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                for (int i = 0; i < numberVexs; i++) {
                    this.adjMatrix[indexLines][i] = Integer.parseInt(values[i]);
                }
                indexLines++;
            }
            reader.close();
            return true;
        }
    }
    
    public void printMatrix() {
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void printList() {
        for (Integer integer : list) {
            System.out.print(integer + 1 + " ");
        }
        System.out.println();
    }
    
    public abstract boolean checkUnGraph();
    
    public abstract boolean checkValid();
    
    public abstract void addEdge(int v1, int v2);
    
    public abstract void removeEdge( int v1, int v2);
    
    public abstract int deg(int v);
    
    public abstract int sumDeg();
    
    public int numVexs() {
        return numberVexs;
    }
    
    public abstract int numberEdges();
    
    public boolean checkConnect() {
        int countVex = 0;
        this.track[0] = true;
        countVex++;
        for (int i = 0; i < numberVexs; i++) {
            if (track[i]) {
                for (int j = 0; j < numberVexs; j++) {
                    if (adjMatrix[i][j] != 0 && !track[j]) {
                        track[j] = true;
                        countVex++;
                        if (countVex == numberVexs) return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void resetAll() throws IOException {
        for (int i = 0; i < numberVexs; i++) {
            track[i] = false;
        }
        list.clear();
        tour.clear();
    }
    //Lab2
    public abstract void BFS(int v) ;
    
    public abstract void DFSGraphRecursive(int v);
    
    public abstract List<Integer> DFSStack(int v);
    
    public abstract void xetTinhLienThong();
    
    public abstract void findPathTwoVexs(int v, int u);
    
    public abstract boolean checkBipartiteGraph(int v);
    
    public abstract String checkEuler();
    
    public abstract boolean isEulerGraph();
    
    public abstract boolean isHalfEulerGraph();
    
    public abstract void findEulerCycle(int v);
    //support findEuler
    public abstract int findTour(int v);
    
    public void printStack(){
        while (!tour.isEmpty()){
            System.out.print(tour.pop() + 1);
        }
        System.out.println();
    }
    
    public abstract void findHalfEulerGraph();
    
    public abstract List<Integer> alogEuler(int v);
    
    public abstract List<Integer> findHamilton(int v);
    
    public abstract List<Integer> findPathHamilton(int v);
    
    public void algoHamilton(int v) throws IOException {
        if (!checkConnect()) {
            System.out.println("Do thi khong lien thong");
            return;
        } else {
            x = new int[numberVexs];
            resetAll();
            Arrays.fill(x, -1);
            x[0] = v;
            track[v] = true;
            expend(1);
        }
    }
    
    private void expend(int i) {
        for (int j = 0; j < numberVexs; j++) {
            if (adjMatrix[x[i - 1]][j] != 0 && !track[j]) {
                x[i] = j;
                if (i < numberVexs - 1) {//chua duyet xong
                    track[j] = true;
                    expend(i + 1);
                    track[j] = false;
                } else {
                    print = true;
                    if (adjMatrix[x[i]][x[0]] != 0) {//co chu trinh
                        printCycle(x);
                        printPath(x);
                        print = false;
                        return;
                    } else {
                        printPath(x);
                    }
                }
            }
        }
    }
    
    private void printCycle(int[] x) {
        System.out.println("Do thi co chu trinh Hamilton");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + 1 + " ");
        }
        System.out.println();
    }
    
    private void printPath(int[] x) {
        System.out.println("Do Thi co duong di Hamilton: ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + 1 + " ");
        }
        System.out.println();
    }
    
    public abstract boolean hasCycle(int u, int v, int[][]w);
    
    public abstract boolean hasCycle(int[][]w);
    
    public abstract void dfsMTS(int v);
    
    public abstract int[][] bfsMTS(int v);
}
