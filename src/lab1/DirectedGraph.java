package lab1;

import java.io.IOException;
import java.util.*;

public class DirectedGraph extends Graph {
    public DirectedGraph() {}
    
    @Override
    public boolean checkValid() {
        for (int i = 0; i < numberVexs; i++) {
            if (adjMatrix[i][i] != 0) return false;
        }
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
            }
        }
        return true;
    }
    
    @Override
    public boolean checkUnGraph() {
        return false;
    }
    
    @Override
    public void addEdge(int v1, int v2) {
        if(v1 < 0 || v2 < 0 || v1 >= numberVexs || v2 >= numberVexs) {
            System.out.println("Something when wrong! Invalid vertex");
        }else {
            adjMatrix[v1][v2]  = 1;
        }
    }
    
    @Override
    public void removeEdge(int v1, int v2) {
        if(v1 < 0 || v2 < 0 || v1 >= numberVexs || v2 >= numberVexs) {
            System.out.println("Something when wrong! Invalid vertex");
        }else {
            adjMatrix[v1][v2] = adjMatrix[v2][v1] = 0;
        }
    }
    
    @Override
    public int deg(int v) {
        int res = 0;
        for (int i = 0; i < numberVexs; i++) {
                res += adjMatrix[v][i] + adjMatrix[i][v];
        }
        return res;
    }
    
    @Override
    public int sumDeg() {
        int res = 0;
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
                res += adjMatrix[i][j];
            }
        }
        return res;
    }
    
    @Override
    public int numberEdges() {
        int res = 0;
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
                if (adjMatrix[i][j] != 0){
                    res += adjMatrix[i][j];
                }
            }
        }
        return res;
    }
    
    @Override
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        
        track[v] = true;
        queue.offer(v);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);
            
            for (int i = 0; i < numberVexs; i++) {
                if (adjMatrix[node][i] != 0 && !track[i]) {
                    track[i] = true;
                    queue.offer(i);
                }
            }
        }
        printList();
    }
    
    @Override
    public void DFSGraphRecursive(int v) {
        track[v] = true;
        list.add(v);
        for (int i = 0; i < numberVexs; i++) {
            if (adjMatrix[v][i] != 0 && !track[i]) {
                DFSGraphRecursive(i);
            }
        }
    }
    
    @Override
    public List<Integer> DFSStack(int v) {
        list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(v);
        
        while (!stack.isEmpty()){
            int node = stack.pop();
            if (!track[node]) {
                list.add(node);
                track[node] = true;
            }
            for (int i = numberVexs - 1; i >= 0; i--) {
                if (adjMatrix[node][i] != 0 && !track[i]){
                    stack.push(i);
                }
            }
        }
        printList();
        return list;
    }
    
    @Override
    public void xetTinhLienThong() {
        int count = 0;
        list = new ArrayList<>();
        for (int i = 0; i < numberVexs; i++) {
            if (!track[i]) {
                DFSGraphRecursive(i);
                count++;
                System.out.println("TPLT thu " + count + " gom cac dinh:");
                printList();
            }
            list.clear();
        }
    }
    
    @Override
    public void findPathTwoVexs(int v, int t) {
        Queue<Integer> queue = new LinkedList<>();
        track[v] = true;
        queue.offer(v);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);
            
            if (node == t) break;
            for (int i = 0; i < numberVexs; i++) {
                if (adjMatrix[node][i] != 0 && !track[i]) {
                    track[i] = true;
                    queue.offer(i);
                }
            }
        }
        if (!track[t] ) return;
        List<Integer> pathRes = new ArrayList<>();
        for (int i = t; i != -1; i = list.get(i-1)) {
            
            pathRes.add(i);
        }
        Collections.reverse(pathRes);
        list = pathRes;
        printList();
    }
    
    @Override
    public boolean checkBipartiteGraph(int v) {
        return false;
    }
    
    @Override
    public boolean isEulerGraph() {
        return false;
    }
    
    @Override
    public boolean isHalfEulerGraph() {
        return false;
    }
    
    @Override
    public void findEulerCycle(int v) {
    
    }
    
    @Override
    public int findTour(int v) {
        
        return v;
    }
    
    @Override
    public String checkEuler() {
        return "";
    }
    
    @Override
    public void findHalfEulerGraph() {
    
    }
    
    @Override
    public List<Integer> alogEuler(int v) {
        return List.of();
    }
    
    @Override
    public List<Integer> findHamilton(int v) {
        return List.of();
    }
    
    @Override
    public List<Integer> findPathHamilton(int v) {
        return List.of();
    }
    
    @Override
    public boolean hasCycle(int u, int v, int[][] w) {
        return false;
    }
    
    @Override
    public boolean hasCycle(int[][] w) throws IOException {
        return false;
    }
    
    @Override
    public void dfsMTS(int v) {
    }
    
    @Override
    public int[][] bfsMTS(int v) {
        return new int[0][];
    }
}
