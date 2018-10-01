class SetMatrixZeroes073 {
	public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        boolean rowZero = false;
        boolean colZero = false;
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) {
        			if (i == 0) { 
                        rowZero = true; 
                        if (j == 0) colZero = true;
                        continue; }
        			if (j == 0) { colZero = true; continue; }
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }

        // make all the 0's column in the first row to be 0
        for (int j = 1; j < matrix[0].length; j++) {
        	if (matrix[0][j] == 0) {
        		for (int i = 1; i < matrix.length; i++) matrix[i][j] = 0;
        	}
        }

        // make all the 0's row in the first column to be 0
        for (int i = 1; i < matrix.length; i++) {
        	if (matrix[i][0] == 0) {
        		for (int j = 1; j < matrix[0].length; j++) matrix[i][j] = 0;
        	}
        }
        
        // if initially the row has 0, make all the elements 0
        if (rowZero) {
        	for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        }

        // if initially the col has 0, make all the elements 0
    	if (colZero) {
    		for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    	}
    }
}