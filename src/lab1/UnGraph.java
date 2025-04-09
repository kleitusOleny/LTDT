package lab1;

import java.io.IOException;
import java.util.*;

public class UnGraph extends Graph {
    public UnGraph() {
    }
    
    public UnGraph(int numberVexs, int[][] adjMatrix) {
        super(numberVexs, adjMatrix);
    }
    
    @Override
    public boolean checkValid() {
        for (int i = 0; i < numberVexs; i++) {
            if (adjMatrix[i][i] != 0) return false;
        }
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
                if (adjMatrix[i][j] != adjMatrix[j][i] || adjMatrix[i][j] > 1 || adjMatrix[j][i] > 1) return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean checkUnGraph() {
        return true;
    }
    
    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= numberVexs || v2 >= numberVexs) {
            System.out.println("Something when wrong! Invalid vertex");
        } else {
            adjMatrix[v1][v2] = adjMatrix[v2][v1] = 1;
        }
    }
    
    @Override
    public void removeEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= numberVexs || v2 >= numberVexs) {
            System.out.println("Something when wrong! Invalid vertex");
        } else {
            adjMatrix[v1][v2] = adjMatrix[v2][v1] = 0;
        }
    }
    
    @Override
    public int deg(int v) {
        int result = 0;
        for (int i = 0; i < numberVexs; i++) {
            result += adjMatrix[i][v];
        }
        return result;
    }
    
    @Override
    public int sumDeg() {
        int result = 0;
        for (int i = 0; i < numberVexs; i++) {
            result += deg(i);
        }
        return result;
    }
    
    @Override
    public int numberEdges() {
        int result = 0;
        for (int i = 0; i < numberVexs; i++) {
            result += deg(i);
        }
        return result / 2;
    }
    
    
    //Lab2
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
    
    public List<Integer> DFSStack(int v) {
        list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(v);
        
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!track[u]) {
                list.add(u);
                track[u] = true;
            }
            for (int i = numberVexs - 1; i >= 0; i--) {
                if (adjMatrix[u][i] != 0 && !track[i]) {
                    stack.push(i);
                }
            }
        }
        printList();
        return list;
    }
    
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
        list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(v);
        
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!track[u]) {
                list.add(u);
                track[u] = true;
            }
            if (u == t) break;
            for (int i = numberVexs - 1; i >= 0; i--) {
                if (adjMatrix[u][i] != 0 && !track[i]) {
                    stack.push(i);
                }
            }
        }
        printList();
    }
    
    public boolean checkBipartiteGraph(int v) {
        int[] color = new int[numberVexs];
        Arrays.fill(color, -1);
        Stack<Integer> stack = new Stack<>();
        
        stack.push(v);
        color[v] = 1;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!track[u]) {
                list.add(u);
                track[u] = true;
            }
            
            for (int i = numberVexs - 1; i >= 0; i--) {
                
                if (adjMatrix[u][i] != 0 && !track[i]) {
                    stack.push(i);
                    if (color[u] == 1) {
                        color[i] = 0;
                    } else {
                        color[i] = 1;
                    }
                } else if (adjMatrix[u][i] != 0 && color[i] == color[u]) {
                    return false;
                }
            }
        }
        System.out.println(Arrays.toString(color));
        return true;
    }
    
    @Override
    public String checkEuler() {
        if (!checkConnect()) {
            return "Do thi khong co chu trinh Euler";
        } else {
            int evenVex = 0;
            int oddVex = 0;
            for (int i = 0; i < numberVexs; i++) {
                if (this.deg(i) % 2 == 0) {
                    evenVex++;
                } else {
                    oddVex++;
                }
            }
            if (oddVex == 2) {
                return "Do thi co duong di euler khong co chu trinh euler";
            } else if (oddVex == 0) {
                return "Do thi co chu trinh euler";
            } else {
                return "Do thi khong co chu trinh va khong co duong di Euler";
            }
            
        }
    }
    
    @Override
    public boolean isEulerGraph() {
        if (checkConnect()) {
            for (int i = 0; i < adjMatrix.length; i++) {
                if (this.deg(i) % 2 != 0) return false;
            }
            return true;
        } else {
            System.out.println("Do thi khong lien thong" + (isHalfEulerGraph() ? " nhung la duong di euler" : "va khong phai duong di euler"));
            return false;
        }
    }
    
    @Override
    public boolean isHalfEulerGraph() {
        int count = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (this.deg(i) % 2 != 0) {
                count++;
            }
        }
        return count == 2;
    }
    
    @Override
    public void findEulerCycle(int v) {
        if (isEulerGraph()) {
            tour = new Stack<>();
            list = new ArrayList<>();
            
            tour.push(v);
            
            while (!tour.isEmpty()) {
                int x = tour.peek();
                if (findTour(x) != x) {
                    tour.push(findTour(x));
                    removeEdge(x, findTour(x));
                    x = findTour(findTour(x));
                } else {
                    list.add(tour.pop());
                }
            }
            printList();
        } else {
            System.out.println("Not found Euler Cycle");
        }
    }
    
    
    @Override
    public int findTour(int v) {
        for (int i = 0; i < numberVexs; i++) {
            if (adjMatrix[v][i] != 0) {
                return i;
            }
        }
        return v;
    }
    
    @Override
    public void findHalfEulerGraph() {
        if (isHalfEulerGraph()) {
            tour = new Stack<>();
            list = new ArrayList<>();
            
            int startIndex = 0;
            for (int i = 0; i < numberVexs; i++) {
                if (deg(i) % 2 != 0) startIndex = i;
            }
            
            tour.push(startIndex);
            
            while (!tour.isEmpty()) {
                int x = tour.peek();
                if (findTour(x) != x) {
                    tour.push(findTour(x));
                    removeEdge(x, findTour(x));
                    x = findTour(findTour(x));
                } else {
                    list.add(tour.pop());
                }
            }
            printList();
        } else {
            System.out.println("Not found Half Euler");
        }
    }
    
    @Override
    public List<Integer> alogEuler(int v) {
        if (isEulerGraph()) {
            findEulerCycle(v);
            return list;
        } else if (isHalfEulerGraph()) {
            findHalfEulerGraph();
            return list;
        } else {
            return null;
        }
    }
    
    public boolean checkHamilton() {
        if (checkConnect()) {
            
            for (int i = 0; i < numberVexs; i++) {
                if (deg(i) <= 1 && deg(i) < numberVexs / 2) {
                    return false;
                }
            }
            return true;
        } else return false;
    }
    
    @Override
    public List<Integer> findHamilton(int v) {
        if (this.checkHamilton()) {
        
        } else {
            return List.of();
        }
        return List.of();
    }
    
    @Override
    public List<Integer> findPathHamilton(int v) {
        return List.of();
    }
    
    @Override
    public boolean hasCycle(int u, int v, int[][] tree) {
        Queue<Integer> list1 = new LinkedList<>();
        list1.add(u);
        track[u] = true;
        while (!list.isEmpty()) {
            int k = list1.remove();
            for (int i = 0; i < numberVexs; i++) {
                if (adjMatrix[k][i] != 0 && !track[i]) {
                    track[i] = true;
                    list1.add(i);
                } else if (i == v) {
                    System.out.println("do thi co chu trinh");
                    return true;
                }
            }
            
        }
        return false;
    }
    
    
    @Override
    public boolean hasCycle(int[][] w){
        int[] pathPre = new int[numberVexs];
        
        for (int i = 0; i < numberVexs; i++) {
            if (!track[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                track[i] = true;


                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int j = 0; j < numberVexs; j++) {
                        if (w[v][j] != 0) {
                            if (!track[j]) {
                                queue.add(j);
                                pathPre[j] = v;
                                track[j] = true;
                            } else if (j != pathPre[j]) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void dfsMTS(int v){
        int[][]treeMST = new int[numberVexs][numberVexs];
        Stack<Integer> st = new Stack<>();
        st.push(v);
        track[v] = true;
        while (!st.isEmpty()){
            int u = st.pop();
            for (int i = numberVexs-1; i >= 0; i--) {
                if (adjMatrix[u][i] != 0 && !track[i]){
                    if (!hasCycle(u,i,treeMST)){
                        treeMST[u][i] = treeMST[i][u] = adjMatrix[u][i];
                        System.out.println("Canh:" + u +"-" + i);
                        track[i] =true;
                        st.push(i);
                    }
                }
            }
        }
        System.out.println("DFS MST:");
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
                System.out.print(treeMST[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        
    }
    
    @Override
    public int[][] bfsMTS(int v) {
        int[][]treeMST = new int[numberVexs][numberVexs];
        Queue<Integer> st = new LinkedList<>();
        st.add(v);
        track[v] = true;
        while (!st.isEmpty()){
            int u = st.poll();
            for (int i = 0; i < numberVexs;i++) {
                if (adjMatrix[u][i] != 0 && !track[i]){
                    if (!hasCycle(u,i,treeMST)){
                        treeMST[u][i] = treeMST[i][u] = adjMatrix[u][i];
                        System.out.println("Canh:" + u +"-" + i);
                        track[i] =true;
                        st.add(i);
                    }
                }
            }
        }
        System.out.println("BFS MST:");
        for (int i = 0; i < numberVexs; i++) {
            for (int j = 0; j < numberVexs; j++) {
                System.out.print(treeMST[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        return null;
    }
}
