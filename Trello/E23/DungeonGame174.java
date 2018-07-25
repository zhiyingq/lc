import java.lang.IllegalArgumentException;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
class DungeonGame174 {
	public int calculateMinimumHP(int[][] dungeon) {
        // idea: Topological / Acyclic edge-weighted digraph algorithm
        // every room's value should be -value;

        // 1. the topological order has been already determined
        // 2. just relax the edges according to the topological order
        // 3. (0,0) - (0,1),(1,0) - (0,2),(1,1),(2,0)
        // (0,3), (1,2), (2,1), (3,0)
		// Rows: M X N
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int lenR = dungeon.length; int lenC = dungeon[0].length; 
		
		// -------initialize the matrix distTo----------
		int[][][] distTo = new int[lenR][lenC][2]; // a matrix to save the dist
		// distTo[i][j][0] = the least negative or 0 number until now;
		// distTo[i][j][1] = the largest remaining value until now;
		for (int i = 0; i < lenR; i++) {
			for (int j = 0; j < lenC; j++) {
				distTo[i][j][0] = Integer.MIN_VALUE; 
				distTo[i][j][1] = Integer.MIN_VALUE;
			}
		}
		distTo[0][0][0] = (dungeon[0][0] < 0 ? dungeon[0][0] : 0);
		distTo[0][0][1] = dungeon[0][0];
		

		// -------initialization done----------

		// -------update the distTo matrix----------
		int level = 0;
		while (level < lenR + lenC - 1) { // in total there are lenR + lenC - 1 levels
			// each room in one level is in the same topological order
			// level ranges from 0 -> lenR + lenC - 1,
			// contains every room 
			// for each room in the same level 
			for (int[] coordinate : getLevelCombs(level, lenR, lenC)) {
				relax(coordinate, dungeon, distTo, lenR, lenC);
			}
			level++;
		}
		// -------update done----------

		// Now we return a matrix
		// if the bottom-right is positive, set 0
		// if negative, set -negative + 1
		return (distTo[lenR - 1][lenC - 1][0] < 0 ? 1 - distTo[lenR - 1][lenC - 1][0] : 1);
    }

    // return the list of integers from the given level, lenR and lenC
    private List<int[]> getLevelCombs(int level, int lenR, int lenC) {
    	List<int[]> list = new ArrayList<int[]>();
    	for (int i = 0; i < lenR; i++) {
    		if (level - i < 0 || level - i >= lenC) { continue; }
    		int[] coord = new int[2];
    		coord[0] = i; coord[1] = level - i;
    		list.add(coord);
    	}
    	return list;
    }

    // relax the edges from the certian room
    private void relax(int[] coordinate, int[][] dungeon, int[][][] distTo, int lenR, int lenC) {
    	int x = coordinate[0];  int y = coordinate[1];
    	if (isValid(x + 1, y, lenR, lenC)) { 
    		// 目前为止最小的负数 = 目前为止上面最小的负数 V.S. 现在的值 哪个更小 取哪个
    		// distTo 看: 会不会让目前为止更小的数变大？会
    		// distTo[x][y][1] + dungeon[x + 1][y]: 当前值
    		// distTo[x][y][0]: 当前最小值
    		if (distTo[x + 1][y][0] < Math.min(distTo[x][y][1] + dungeon[x + 1][y], distTo[x][y][0])) {
    			distTo[x + 1][y][1] = Math.max(distTo[x][y][1] + dungeon[x + 1][y], distTo[x][y][1]);
    			distTo[x + 1][y][0] = Math.min(distTo[x][y][1] + dungeon[x + 1][y], distTo[x][y][0]); 
    			// System.out.println("distTo "+(x+1)+" "+y+" = ["+distTo[x + 1][y][0]+" "+distTo[x + 1][y][1]+"]");
    		}
    		
    	}
    	if (isValid(x, y + 1, lenR, lenC)) {
    		if (distTo[x][y + 1][0] < Math.min(distTo[x][y][1] + dungeon[x][y + 1], distTo[x][y][0])) {
    			distTo[x][y + 1][1] = Math.max(distTo[x][y][1] + dungeon[x][y + 1], distTo[x][y][1]);
    			distTo[x][y + 1][0] = Math.min(distTo[x][y][1] + dungeon[x][y + 1], distTo[x][y][0]); 
    			// System.out.println("distTo "+(x)+" "+(y+1)+" = ["+distTo[x][y + 1][0]+" "+distTo[x][y + 1][1]+"]");
    		}
    	
    	}
    }

    // judge whether a corrdinate is valid
    private boolean isValid(int i, int j, int lenR, int lenC) {
    	if (i < 0 || i >= lenR || j < 0 || j >= lenC) { return false; }
    	return true;
    }

    public static void main(String[] args) {
    	DungeonGame174 d = new DungeonGame174();
    	// int[][] m = new int[][] {{-2,-3,3,-4,-3}, {-5,-2,-1,-10,1}, {10,8,-6,30,-5}};
    	int[][] m = new int[][] {{3,0,-3}, {-3,-2,-2},{3,1,-3}};
    	System.out.println(d.calculateMinimumHP(m));
    }
}