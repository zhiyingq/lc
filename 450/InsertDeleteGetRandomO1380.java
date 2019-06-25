class InsertDeleteGetRandomO1380 {
	private Map<Integer, Integer> map;
	private List<Integer> array;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1380() {
        map = new HashMap<Integer, Integer>();
		array = new ArrayList<Integer>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // if contains, return false
        if (map.containsKey(val)) return false; 
        // if not contains, put the <value, index> to the map, and add the number to the array
        map.put(val, array.size());
        array.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // if map does not contains the key, just return false
        if (!map.containsKey(val)) return false;
        // else, if contians
        // 1. first get the <index>
        // 2. delete the last element of the array and record the value to -> last
        // 3. if index != last element's index, swap them
        // 4. update the map, last's pos and delete the val
        // 5. if index == last element's index, then we don't need to update last, just remove it
        int pos = map.get(val);
        int last = array.remove(array.size() - 1);
        if (pos != array.size()) {
        	array.set(pos, last);
            map.put(last, pos);
        }
        map.remove(val);
      	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int random = (int) (Math.random() * array.size());
        return array.get(random);
    }
}