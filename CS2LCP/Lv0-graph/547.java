class Solution {
    public int findCircleNum(int[][] M) {
        // can use union-find to solve this problem 
        int n = M.length;
        int[] id = new int[n], size = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
        Arrays.fill(size, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) union(id, size, i, j);
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (id[i] == i) count++;
        }
        
        return count;
    }
    
    private void union(int[] id, int[] size, int u, int v) {
        int ru = root(id, u), rv = root(id, v);
        if (size[ru] <= size[rv]) {
            id[ru] = rv;
            size[rv] += size[ru];
        } else {
            id[rv] = ru;
            size[ru] += size[rv];
        }
    }
    
    private int root(int[] id, int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}