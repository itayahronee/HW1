public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {//I am taking algorithms right now, so I just implemented BFS with a queue implemented by an array.
        if (m.length == 0) {
            return -1;
        }
        if (i==j){
            return 0;
        }
        int[] distances = new int[m.length];
        for(int k=0;k<m.length;k++){
            distances[k]=-1;
        }
        distances[i]=0;
        int[] q = new int[m.length];
        int head = 0;
        int tail = 0;
        q[0] = i;
        tail++;
        int current;
        while(head<tail){
            current = q[head];
            for (int k=0;k<m.length;k++){
                if (m[current][k]==1 && distances[k]==-1){
                    distances[k] = distances[current]+1;
                    q[tail] = k;
                    tail++;
                }
            }
            head++;
        }
        if (distances[j]!=-1){
            return distances[j];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}