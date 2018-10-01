import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;
class FindEventualSafeStates802 {
    // 这个的问题在于，从某个点开始，是否可能会碰到一个circle
    // 而不仅仅在于，是否是strongly connected component
    // 所以，我们要找的是从某个点出发碰到circle的所有点
    // strongly connect component只是它的子集！！
    private boolean[] onstack; // to check if the node is on stack
    private boolean[] visited; // to check if the node's cycle has been determined
    private boolean[] cycle; // true: it will meet a cycle; 
    private int[][] myGraph;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        onstack = new boolean[graph.length]; 
        visited = new boolean[graph.length]; 
        cycle = new boolean[graph.length]; 
        myGraph = graph;
        
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) ifCycle(i);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < cycle.length; i++) {
            if (!cycle[i]) result.add(i);
        }
        
        return result;
        
    }
    
    private boolean ifCycle(int i) {
        if (visited[i]) { return cycle[i]; } 
        if (onstack[i]) { cycle[i] = true; return cycle[i]; }
        else { onstack[i] = true; }
        
        // If one neighbor will meet a cycle, the node will meet a cycle as well
        for (int j : myGraph[i]) { 
            cycle[i] |= ifCycle(j);
        }
        
        onstack[i] = false;
        visited[i] = true;
        return cycle[i];
    }
	
	



	/*
	<------------DETECT STRONGLY CONNECTED COMPONENTS------------->
	private int[][] myGraph;
	private List<List<Integer>> reGraph;
	private boolean[] ifVisited;
	private int count;
	private List<List<Integer>> idMap;
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> safeNodes = null;
        if (graph == null || graph.length == 0) return safeNodes;
        
        // initialize the variables
        myGraph = graph; 
        reGraph = new ArrayList<List<Integer>>();
        count = 0;
        ifVisited = new boolean[myGraph.length];
        idMap = new ArrayList<List<Integer>>();

        // get the reverse graph
        for (int i = 0; i < myGraph.length; i++) { 
        	reGraph.add(new ArrayList<Integer>());
        	idMap.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < myGraph.length; i++) {
        	for (int j = 0; j < myGraph[i].length; j++) {
        		reGraph.get(myGraph[i][j]).add(i);
        	}
        }
        System.out.println(reGraph);
        // 
        // do dfs on the reverse graph
        List<Integer> order = reversePostOrder(reGraph);
        System.out.println(order);
        // do dfs on the origin graph according to the reverse postorder
        for (int i : order) {
        	if (!ifVisited[i]) { dfsGraph(i); count++; }
        }

        safeNodes = new ArrayList<>();
        for (int i = 0; i < idMap.size(); i++) {
        	if (idMap.get(i).size() == 1) { safeNodes.add(idMap.get(i).get(0)); }
        }
        System.out.println("idMap: \n"+idMap);

        Collections.sort(safeNodes);
        System.out.println("safeNodes :" + safeNodes);
        return safeNodes;
    }

    private void dfsGraph(int i) {
    	ifVisited[i] = true;
    	idMap.get(count).add(i);
    	for (int j : myGraph[i]) {
    		if (!ifVisited[j]) {
    			dfsGraph(j);
    		}
    	}
    }

    private List<Integer> reversePostOrder(List<List<Integer>> graph) {
    	boolean[] visited = new boolean[graph.size()];
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	for (int i = 0; i < graph.size(); i++) {
    		if (!visited[i]) { dfs(stack, graph, i, visited); }
    	}
    	return stack; // return a stack
    }

    private void dfs(LinkedList<Integer> stack, List<List<Integer>> graph, int i, boolean[] visited) {
    	visited[i] = true;
    	for (int j : graph.get(i)) {
    		if (!visited[j]) {
    			dfs(stack, graph, j, visited);
    		}
    	}
    	stack.add(0, i);
    	System.out.println("stack add: "+i);
    }
    */

    public static void main(String[] args) {
    	FindEventualSafeStates802 f = new FindEventualSafeStates802();
    	f.eventualSafeNodes(new int[][]{{0}, {2,3,4}, {3, 4}, {0,4},{}});
    }
    

}