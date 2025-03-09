package lab1;

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
    
    //Lab2
    @Override
    public boolean checkConnect(){
        for (int i = 0; i < numberVexs; i++) {
            int sum = 0;
            for (int j = 0; j < numberVexs; j++) {
                sum += adjMatrix[i][j];
            }
            if (sum == 0) return false;
        }
        return true;
    }
    
    @Override
    public void diTimCacDinhLienThong(int vexs) {
        if(vexs < 0 || vexs > numberVexs ) System.out.println("Something when wrong! Invalid vertex");
        else {
            for (int i = 0; i < numberVexs; i++) {
                System.out.println();
            }
        };
    }
}
