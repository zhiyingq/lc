import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
class ReconstructItinerary332 {
	private Map<String, Queue<String>> iterMap = new HashMap<>();
    private List<String> routine = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
		// put all the combs into the map
		// where key is the departure, and value is the destination
		// time complexity: O(nlgn)
        
        for (String[] combs : tickets) {
        	if (!iterMap.containsKey(combs[0])) { 
        		iterMap.put(combs[0], new PriorityQueue<String>());
        	}
        	iterMap.get(combs[0]).add(combs[1]); 	
        }
        hierholzer("JFK");
        return routine;
        
    }

    private void hierholzer(String current) {
    	// iterate all the neighbors
    	while (iterMap.containsKey(current) && iterMap.get(current).size() > 0) {
    		hierholzer(iterMap.get(current).poll());
    	}
    	// as long as it has no neighbor, save it 
    	routine.add(0, current);
    }

    public static void main(String[] args) {
    	ReconstructItinerary332 r = new ReconstructItinerary332();
    	String[][] tickets = { {"JFK","SFO"}, {"JFK","ATL"},
    							{"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
    	System.out.println(r.findItinerary(tickets));
    }
}