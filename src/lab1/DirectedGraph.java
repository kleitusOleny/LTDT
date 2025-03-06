package lab1;

public class DriectGraph extends Graph {
    public DriectGraph() {}
    
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
    
    }
    
    @Override
    public void removeEdge(int[][] matrix, int v1, int v2) {
    
    }
    
    @Override
    public int deg(int v) {
        return 0;
    }
    
    @Override
    public int sumDeg() {
        return 0;
    }
}
