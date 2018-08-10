class GuessNumberHigherorLower374 {
	public int guessNumber(int n) {
    	int low = 1; int high = n;
    	int num = 0;
    	while(low <= high) {
    		num = low + (high - low) / 2;
    		if (guess(num) > 0) { low = num + 1; }
    		else if (guess(num) < 0) { high = num - 1; }
    		else { break; }
    	}
    	return num;
    }

    public int guessNumberlg3(int n) {
    	int low = 1; int high = n;
    	int tri1, tri2
    	while (low <= high) {
    		tri1 = low + (high - low) / 3;
    		tri2 = high - (high - low) / 3;
    		// if tri1 is the answer
    		if (guess(tri1) == 0) { return tri1; }
    		// if tri2 is the answer
    		if (guess(tri2) == 0) { return tri2; }
    		// the leftmost triple
    		if (guess(tri1) < 0) { high = tri1 - 1; continue; }
    		// the right most triple
    		if (guess(tri2) > 0) { low = tri2 + 1; continue; }
    		// the middle
    		high = tri2 - 1; 
    		low = tri1 + 1;
    	}
    	return 0;
    }

    
}