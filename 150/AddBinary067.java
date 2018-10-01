class AddBinary067 {
    // a FASTER VERSION
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1; 
        int j = b.length() - 1;
        int anum = 0; int bnum = 0; int count = 0;
        while (i >= 0 || j >= 0 || count > 0) {
            anum = i >= 0 ? a.charAt(i) - '0' : 0;
            bnum = j >= 0 ? b.charAt(j) - '0' : 0;
            int plus = anum + bnum + count;
            sum.append(plus % 2);
            count = plus / 2;
            i--; j--;
        }
        return sum.reverse().toString();
    }

	public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1; 
        int j = b.length() - 1;
        int anum = 0; int bnum = 0; int count = 0;
        while (i >= 0 || j >= 0 || count > 0) {
        	anum = i >= 0 ? a.charAt(i) - '0' : 0;
        	bnum = j >= 0 ? b.charAt(j) - '0' : 0;
        	switch(anum + bnum + count) {
        		case 0 : sum.append('0'); count = 0; break;
        		case 1 : sum.append('1'); count = 0; break;
        		case 2 : sum.append('0'); count = 1; break;
        		case 3 : sum.append('1'); count = 1; break;
        		default: break;
        	}
        	i--; j--;
        }
        return sum.reverse().toString();
    }


}