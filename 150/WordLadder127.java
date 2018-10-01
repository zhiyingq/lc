class WordLadder127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS queue
        Queue<String> wordQueue = new LinkedList<String>();
        // hashset to keep the remaining words
        Set<String> wordSet = new HashSet<String>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        int distance = 2;
        // add the nearest words to the queue
        // if added, delete the word from the set
        addWords(beginWord, wordSet, wordQueue);
        while(!wordQueue.isEmpty()) {
        	int size = wordQueue.size();
        	for (int i = 0; i < size; i++) {
        		String head = wordQueue.poll();
        		if (head.equals(endWord)) return distance;
        		addWords(head, wordSet, wordQueue);
        	}	
        	distance++;
        }
        return 0;
    }

    // this function is to add the words that have distance 1
    private void addWords(String beginWord, Set<String> wordSet, Queue<String> wordQueue) {
    	// for every digit in beginWord, change the certian digit
    	char[] letters = beginWord.toCharArray();
    	for (int i = 0; i < beginWord.length(); i++) {  
    		// traverse all the possible letters from a to z	
    		char old = letters[i];	
    		for (int j = 0; j < 26; j++) {    			
    			letters[i] = (char) ('a' + j);
    			String newWord = String.valueOf(letters);
    			if (wordSet.contains(newWord)){
    				wordQueue.offer(newWord);
                    //System.out.println("wordQueue offer: "+newWord);
    				wordSet.remove(newWord);
                    //System.out.println("wordSet removed ");
    			}		
    		}
    		letters[i] = old;
    	}
    }
}