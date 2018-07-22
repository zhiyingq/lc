/*
	return the topological order of each node and combine them together
	[0,1] means 1(start) -> 0(end)

	Basic Idea:
	The graph is represented in "List", which is, if there are n numbers ranging from 0 - (n-1)
	A Bag<Integer>[] object is created to save the corresponding edges
	Then doing dfs & circle detection at the same time
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

class CourseScheduleII210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        // Initialize the list with "numCourses" items
        for (int i = 0; i < numCourses; i++) { lists.add(new ArrayList<Integer>()); }
        // if [0,1], then add the 1st ArrayList with 0
        for (int[] edge : prerequisites) { lists.get(edge[1]).add(edge[0]); }
        System.out.println(lists);
        // Now the graph is initialzied.
        // DFS Search
        boolean[] visited = new boolean[numCourses]; // to record if a vertix is visited
    	Stack<Integer> reverse = new Stack<Integer>(); // to record the reverse sequence
    	// as long as "i" enters the dfs function
    	// it will be marked as visited, and it is finished and put in the stack
    	// is it possible that i is visited but not put onto the stack yet?
    	// yes, this will generate a circle. we need to check it.
    	Set<Integer> circle = new HashSet<Integer>();
    	boolean ifValid = true;
    	for (int i = 0; i < numCourses; i++) {
    		if (!visited[i]) { 
    			ifValid = validDFS(i, lists, visited, reverse, circle); 
    			if (!ifValid) { break; }
    		}
    	}
    	if (!ifValid) { return new int[0]; }
    	// System.out.println(reverse);
    	int[] order = new int[numCourses]; int i = 0;
    	while(reverse.size() > 0) { order[i] = reverse.pop(); i++; }
        return order;
    }

    private boolean validDFS(int i, List<List<Integer>> lists, boolean[] visited, Stack<Integer> reverse, Set<Integer> circle) {
    	if (circle.contains(i)) { return false; }
    	circle.add(i); boolean ifValid = true;
    	for (int w : lists.get(i)) { 
    		if (!visited[w]) { 
    			ifValid = validDFS(w, lists, visited, reverse, circle); 
    			if (!ifValid) { break; }
    		}
    	}
    	circle.remove(i);
    	reverse.push(i);
    	visited[i] = true;
    	return ifValid;
    }

    public static void main(String[] args) {
    	CourseScheduleII210 c = new CourseScheduleII210();
    	// , {2,0}, {3,1}, {4,2}, {5,3}, {9,8}, {8,6}, {7,8}, {0,1}
    	int[][] graph = new int[][] {{0,1}, {1,0}};
    	for (int i : c.findOrder(3, graph)) {
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
}