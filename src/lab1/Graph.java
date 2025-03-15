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
    
    public abstract boolean checkValid();
    
    public abstract void addEdge(int[][] matrix, int v1, int v2);
    
    public abstract void removeEdge(int[][] matrix, int v1, int v2);
    
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
    
    public void resetAll() {
        for (int i = 0; i < numberVexs; i++) {
            track[i] = false;
        }
    }
    
    //Lab2
    public List<Integer> BFS(int v) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0; // Đếm số nút đã duyệt
        queue.offer(v);
        count++; // Đánh dấu v là đã thăm bằng cách tăng count
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[node][i] == 1) { // Nếu có đường đi
                    queue.offer(i);
                    adjMatrix[node][i] = -1; // Đánh dấu đã thăm bằng giá trị đặc biệt
                    adjMatrix[i][node] = -1; // Đánh dấu hai chiều (chỉ cần nếu đồ thị vô hướng)
                    count++;
                }
            }
        }
        return result;
    }
    
    public void DFSGraphRecursive(int v) {
        track[v] = true;
        list.add(v);
        for (int i = 0; i < numberVexs; i++) {
            if (adjMatrix[v][i] != 0 && !track[i]) {
                DFSGraphRecursive(i);
            }
        }
    }
    
    public void xetTinhLienThong(){
        int count = 0;
        list = new ArrayList<>();
        for (int i = 0; i < numberVexs; i++) {
            if (!track[i]){
                DFSGraphRecursive(i);
                count++;
                System.out.println("TPLT thu " + count +" gom cac dinh:");
                printList();
            }
            list.clear();
        }
        
    }
    
}
