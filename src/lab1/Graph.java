package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//src\test2.txt
public abstract class Graph {
    int numberVexs;
    int[][] adjMatrix;
    String path = "src/test1.txt";
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
    
    public void printMatrix(){
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public abstract boolean checkValid();
    
    public abstract void addEdge(int[][]matrix, int v1, int v2);
    
    public abstract void removeEdge(int[][]matrix,int v1, int v2);
    
    public abstract int deg(int v);
    
    public abstract int sumDeg();
    
    public int numVexs() {
        return numberVexs;
    }
    
    public int numberEdges() {
        int result = 0;
        for (int i = 0; i < numberVexs; i++) {
             result += deg(i);
        }
        return result/2;
    }
    
    public abstract boolean checkConnect();
    
    //Lab2
    
    public abstract void diTimCacDinhLienThong(int vexs);
}
