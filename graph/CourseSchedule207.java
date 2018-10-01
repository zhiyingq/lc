import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
class CourseSchedule207 {
	// to detect whether a cycle exisiting in the graph
	private boolean[] visited;
	private boolean[] onstack;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onstack = new boolean[numCourses];
        List<Integer>[] edges = (ArrayList<Integer>[]) new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) { edges[i] = new ArrayList<Integer>(); }
        for (int[] edge : prerequisites) { edges[edge[1]].add(edge[0]); }
        for (int i = 0; i < numCourses; i++) {
        	if (!visited[i]) {
        		if (isCycle(i, edges)) return false;
        	}
        }
        return true;   
    }

    private boolean isCycle(int i, List<Integer>[] edges) {
    	if (onstack[i]) return true;
    	onstack[i] = true;
    	for (int j : edges[i]) {
    		if (!visited[j]) {
    			if (isCycle(j, edges)) {
    				// we don't care about the restoration of onstack and visited here
    				// because once there is a cycle, we will return true
    				// and the program will terminate, no need to check other nodes
                    return true; 
                }
    		}
    	}
    	onstack[i] = false;
    	visited[i] = true;
    	return false;
    }

    public boolean canFinishKahn(int numCourses, int[][] prerequisites) {
    	// initialize the "indegree" array to track the indegree	
    	// initialize the graph (edges)
    	int[] indegree = new int[numCourses];
    	Queue<Integer> noIncomingNodes = new LinkedList<Integer>();
    	List<Integer>[] edges = (ArrayList<Integer>[]) new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) { edges[i] = new ArrayList<Integer>(); }
        for (int[] edge : prerequisites) { 
        	edges[edge[1]].add(edge[0]); 
        	indegree[edge[0]]++;
        }

        // intialize the queue that saves nodes with no incoming edge
        for (int i = 0; i < indegree.length; i++) {
        	if (indegree[i] == 0) { noIncomingNodes.add(i); }
        }

        // poll the node with 0 indegree; substract the indegree of all edges starting with node
        // poll those whose indegree is 0 to the queue
        while (noIncomingNodes.size() > 0) {
        	int node = noIncomingNodes.poll();
        	for (int neighbor : edges[node]) {
        		indegree[neighbor]--;
        		if (indegree[neighbor] == 0) { noIncomingNodes.add(neighbor); }
        	}
        }

        // as long as there is a node with positive indegree, return false;
        for (int i = 0; i < indegree.length; i++) {
        	if (indegree[i] == 0) { return false; }
        }
        return true;
    }

    public static void main(String[] args) {
    	CourseSchedule207 c = new CourseSchedule207();
    	c.canFinish(3, new int[5][2]);
    	System.out.println("Worked");
    }
}
