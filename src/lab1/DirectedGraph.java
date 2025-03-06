package lab1;

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
    public void addEdge(int[][] matrix, int v1, int v2) {
        if(v1 < 0 || v2 < 0 || v1 >= numberVexs || v2 >= numberVexs) {
            System.out.println("Something when wrong! Invalid vertex");
        }else {
            adjMatrix[v1][v2] = adjMatrix[v2][v1] = 1;
        }
    }
    
    @Override
    public void removeEdge(int[][] matrix, int v1, int v2) {
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
            for (int j = 0; j < numberVexs/2; j++) {
                res += adjMatrix[v][i];
            }
        }
        return res;
    }
    
    @Override
    public int sumDeg() {
        int res = 0;
        for (int i = 0; i < numberVexs; i++) {
            res += deg(i);
        }
        return res;
    }
}
