import java.util.List;
import java.util.ArrayList;

// Main Idea: Union-Find
class RedundantConnection684 {
	public int[] findRedundantConnection(int[][] edges) {
        // reasonably, there should be n - 1 edges for n nodes
        // but there is one extra: n edges
        // edges.length = n
        // construct an array with size n + 1, index ranges from 1 - n
		UnionFind uf = new UnionFind(edges.length);
		int[] result = new int[2];
		for (int[] edge : edges) {
			int p = edge[0]; int q = edge[1];
			if (uf.connected(p,q)) { result = edge; }
			else { uf.union(p,q); }
		}
		return result;
    }

    // UnionFind of n numbers
    // index from: 1 - n
    class UnionFind {
    	int[] id;
    	int[] size;
    	public UnionFind(int n) {
    		id = new int[n + 1];
    		size = new int[n + 1];
    		for (int i = 1; i < n + 1; i++) {
    			id[i] = i;
    			size[i] = 1;
    		}
    	}

    	// return the root of i
    	public int root(int i) {
    		while (i != id[i]) { id[i] = id[id[i]]; i = id[i]; }
    		return i;
    	}

    	public void union(int p, int q) {
    		int rp = root(p);
    		int rq = root(q);
    		if (rp != rq) {
    			if (size[rp] < size[rq]) { id[rp] = rq; size[rq] += size[rp]; }
    			else { id[rq] = rp; size[rp] += size[rq]; }
    		}
    	}

    	public boolean connected(int p, int q) {
    		return root(p) == root(q);
    	}
    }

    public static void main(String[] args) {
    	RedundantConnection684 r = new RedundantConnection684();

    }
}