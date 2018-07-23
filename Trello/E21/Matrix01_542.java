import java.lang.Math;

class Matrix01_542 {
	public int[][] updateMatrix(int[][] matrix) {
        // There are at least one 0 in the matrix
        // First find all the 0s and update the value around them
        int[][] update = new int[matrix.length][matrix[0].length]; // the matrix to be returned
        boolean[][] visited = new boolean[matrix.length][matrix[0].length]; // record if the element is updated/visited

        // save the index i, j of 0
        List<List<Integer>> zero = new ArrayList<List<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) { 
        			List<Integer> zeroindex = new ArrayList<Integer>();
                    zeroindex.add(i); zeroindex.add(j);
                    zero.add(zeroindex);
        		}
        	}
        }
        // System.out.println(zero);
        for (int i = 0; i < zero.size(); i++) {
            // System.out.println(i);
            boolean[][] dfsVisited = new boolean[matrix.length][matrix[0].length]; // record dfs
            dfs(matrix, zero.get(i).get(0), zero.get(i).get(1), update, dfsVisited);
        }
        
        return update;
    }

    private void dfs(int[][] matrix, int i, int j, int[][] update, boolean[][] dfsVisited) {
    	dfsVisited[i][j] = true;
        // System.out.println("Loading "+i+" and "+j+" ...");
        // if matrix[i][j] = 0 then update[i][j] = 0; 
        // else it should be the min of the neighborhood + 1
        // here we just consider the case that !matrix[i][j] == 0; because in this case the update[i][j] will be updated
        // but the update will only be done according to the existed value; 
        // otherwise it will be kept zero
        if (!(matrix[i][j]  == 0)) {
            int min = matrix.length + matrix[0].length;
    		if (isValid(matrix, i - 1, j) && dfsVisited[i - 1][j]) { min = Math.min(min, update[i - 1][j] + 1); }
    		if (isValid(matrix, i + 1, j) && dfsVisited[i + 1][j]) { min = Math.min(min, update[i + 1][j] + 1); }
    		if (isValid(matrix, i, j - 1) && dfsVisited[i][j - 1]) { min = Math.min(min, update[i][j - 1] + 1); }
    		if (isValid(matrix, i, j + 1) && dfsVisited[i][j + 1]) { min = Math.min(min, update[i][j + 1] + 1); }
            // if the inital value of update[i][j] != 0;
            // meaning that: it has been updated
            // so we just update it according to its initial value
    		update[i][j] = (update[i][j] == 0 ? min : Math.min(update[i][j], min));  
            // System.out.println(i+" and "+j+"'s value changes to: "+min);
        }
    	
    	if (isValid(matrix, i - 1, j) && !dfsVisited[i - 1][j]) { dfs(matrix, i - 1, j, update, dfsVisited); } 
    	if (isValid(matrix, i + 1, j) && !dfsVisited[i + 1][j]) { dfs(matrix, i + 1, j, update, dfsVisited); } 
    	if (isValid(matrix, i, j - 1) && !dfsVisited[i][j - 1]) { dfs(matrix, i, j - 1, update, dfsVisited); } 
    	if (isValid(matrix, i, j + 1) && !dfsVisited[i][j + 1]) { dfs(matrix, i, j + 1, update, dfsVisited); } 
    }

    private boolean isValid(int[][] matrix, int i, int j) {
    	if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) { return false; }
    	return true;
    }

    public static void main(String[] args) {

    }
}