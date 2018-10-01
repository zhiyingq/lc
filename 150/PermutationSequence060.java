class PermutationSequence060 {

	// Method1: Very Solow Version
	private int count = 0;
	private String nth = new String();
	public String getPermutation(int n, int k) {
		getNth(n, k, new StringBuilder(), new boolean[n + 1]);
		return this.nth;
    }

    private void getNth(int n, int target, StringBuilder str, boolean[] visited) {
    	if (str.length() == n) { 
    		if (++this.count == target) { this.nth = str.toString(); }
    		return;
    	}

    	for (int i = 1; i <= n; i++) {
            if (this.count >= target) return;
    		if (visited[i]) continue;
    		str.append(i);
    		visited[i] = true;
    		getNth(n, target, str, visited);
    		visited[i] = false;
    		str.deleteCharAt(str.length() - 1);
    	}
    }

    // Method2: Much faster!
    public String getPermutation(int n, int k) {
    	StringBuilder str = new StringBuilder();
    	getNth(new boolean[n + 1], n, k, str);
    	return str.toString();
    }

    private void getNth(boolean[] visited, int n, int k, StringBuilder str) {
    	// n: how many numbers unchosen/left
    	// k: get the kth number in the n left numbers
    	// rank: the number's rank we wanna get
    	// nth: has the rank in the n numbers
    	if (str.length() == visited.length - 1) { return; }
        int fract = fractional(n - 1);
    	int rank = (int) (Math.ceil((double)k / fract));

    	// get the nth number (according to rank) in the array 1-n
    	int nth = 0;
    	for (int i = 1; i < visited.length; i++) {
    		if (visited[i]) continue;
    		nth++;
    		if (nth == rank) {
    			nth = i;
    			break;
    		}
    	}

    	str.append(nth); 
    	visited[nth] = true;
    	if (rank == 1) { getNth(visited, n - 1, k, str); }
    	else { getNth(visited, n - 1, k - (rank - 1) * fract, str); }
    }

    private int fractional(int n) {
    	if (n == 0 || n == 1)  return 1;
    	return n * fractional(n - 1);
    }
}












