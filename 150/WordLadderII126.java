class WordLadderII126 {
	private List<List<String>> ladders;
	private int minLength = Integer.MAX_VALUE;
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
			// initialize the ladders, which is to save the solutions
			ladders = new ArrayList<List<String>>();
			// a hashset that saves all words
			Set<String> wordSet = new HashSet<String>(wordList);
			wordSet.add(beginWord);
			// if the wordSet does not contain the endWord, return 
			if (!wordSet.contains(endWord)) { return ladders; }

			// search from the beginWord
			dfs(beginWord, endWord, new ArrayList<String>(), wordSet);
			return this.ladders;
	}

	// given beginWord, find the neighbors
	// delete the beginWord from the wordSet
	// search the neighbors
	// push the beginWord back to the wordSet
	private void dfs(String beginWord, String endWord, List<String> solution, Set<String> wordSet) {
		// 1. add the beginWord to the solution
		// 2. remove the beginWord from the wordSet, if exists
		if (solution.size() >= minLength) { return; }
		solution.add(beginWord);
		wordSet.remove(beginWord); 

		// if the beginWord is the endWord, then the dfs is done
		if (beginWord == endWord) {
			if (solution.size() < minLength) {
				minLength = solution.size();
				this.ladders.clear();
			}

			if (solution.size() == minLength) {
				this.ladders.add(solution);
			}

			return;
		}

		// if the wordSet is already empty, no solution found
		if (wordSet.isEmpty()) return;

		// else, continue to find the neighbors of the beginWord
		List<String> neighbors = findNeighbors(beginWord, wordSet);
		for (String neighbor : neighbors) {
			dfs(neighbor, endWord, solution, wordSet);
		}

		wordSet.add(beginWord);
		solution.remove(solution.size() - 1);
	}

	// find and return a list of neighbors of the beginWord
	private List<String> findNeighbors(String beginWord, Set<String> wordSet) {
		// a list to save the neighbors found
		List<String> neighbors = new ArrayList<String>();

		// for every letter of the beginWord, change it to 'a' to 'z'
		for (int i = 0; i < beginWord.length(); i++) {
			char[] letters = beginWord.toCharArray();
			char old = letters[i];
			for (int j = 0; j < 26; j++) {
				letters[i] = (char) ('a' + j);
				String newWord = String.valueOf(letters);
				if (wordSet.contains(newWord)) {
					neighbors.add(newWord);
				}
			}
			letters[i] = old;
		}
		return neighbors;
	}
}




























