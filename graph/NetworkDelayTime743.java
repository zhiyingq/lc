class NetworkDelayTime743 {
	// Dijkstra
	public int networkDelayTime(int[][] times, int N, int K) {
		// construct a "distTo" to save the distance
		// initialize the distTo as MAX_VALUE and set K to be 0
		int[] distTo = new int[N + 1];
		for (int i = 1; i <= N; i++) { distTo[i] = Integer.MAX_VALUE; }
		distTo[K] = 0;

		// initialize the graph -- edges
		List<EndPoint>[] edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) { edges[i] = new ArrayList<EndPoint>(); }
		for (int[] edge : times) { edges[edge[0]].add(new EndPoint(edge[1], edge[2])); }
		
		
		// construct a visited array to keep the node that has been visited
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i < N; i++) {
			int index = getMin(distTo, visited);
            System.out.println(index+" has the least distance with "+distTo[index]);
			visited[index] = true;
            System.out.println("mark "+index+" as visited");
			for (EndPoint e: edges[index]) {
				if (distTo[e.node] > distTo[index] + e.weight) {
					distTo[e.node] = distTo[index] + e.weight;
                    System.out.println("set "+e.node+"'s value to "+distTo[e.node]);
				}
			}
		}

		int delay = -1;
		for (int i = 1; i <= N; i++) {
			if (distTo[i] == Integer.MAX_VALUE) return -1;
			if (distTo[i] > delay) { delay = distTo[i]; }
		}

		return delay;


	}

	private int getMin(int[] distTo, boolean[] visited) {
		int min = Integer.MAX_VALUE; int index = 0;
		for (int i = 1; i < distTo.length; i++) {
			if(distTo[i] <= min && !visited[i]) {
				min = distTo[i];
                index = i;
			}
		}
		return index;
	}

	class EndPoint {
		int node; int weight;
		public EndPoint(int node, int weight) { 
			this.node = node;
			this.weight = weight;
		}
	}

	

	private int getMin(int[] distTo, boolean[] visited) {
		int index = 1;
		for (int i = 1;; i < distTo.length; i++) {
			if(distTo[i] < distTo[index] && !visited[i]) {
				index = i;
			}
		}
		return index;
	}

	class EndPoint {
		int node; int weight;
		public EndPoint(int node, int weight) { 
			this.node = node;
			this.weight = weight;
		}
	}









	// 看上去是Dijkstra算法
	// 但好像修改一下，基于Kruskal Algorithm的思想
	// 从指定点开始，每次只取heap里最小的放入dist, 然后span it, 把邻居放入heap
	// 然后已经visit过的点就不放入了，永远只取最小的那个存入dist
	public int networkDelayTime(int[][] times, int N, int K) {
        // initialize the graph -- edges
		// a list of ArrayList<int[]>, index = node i, ArrayList = all edges from it & weight
        List<int[]>[] edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
        	edges[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < times.length; i++) {
        	edges[times[i][0]].add(new int[] {times[i][1], times[i][2]});
        }
        

        // pa: [int node, int weight]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
        	(array1, array2) -> array1[1] - array2[1]);
        pq.add(new int[] {K, 0}); 

        // initialize the distTo array
        // Function 1. to save the distance from K
        // Function 2. to check whether the node has been visited
        int[] distTo = new int[N + 1];
        for (int i = 0; i < distTo.length; i++) { distTo[i] = -1; }

        // while-loop, get the shortest path
        int count = 0;
        while (pq.size() > 0 && count < N) {
        	int[] edge = pq.poll(); // poll the edge with the minimum length
            if (distTo[edge[0]] != -1) continue; // if already in the dist, continue
        	distTo[edge[0]] = edge[1];  // mark the node as visited
            
        	for (int[] neighbor : edges[edge[0]]) { // put the neighbors to the heap
        		if (distTo[neighbor[0]] == -1) { 
        			pq.add(new int[] {neighbor[0], edge[1] + neighbor[1]});
        		}
        	}
        }

        int max = -1;
        for (int i = 1; i < distTo.length; i++) { 
        	if (distTo[i] == -1) return -1;
        	if (distTo[i] > max) { max = distTo[i]; } 
        }
        return max;
    }
}