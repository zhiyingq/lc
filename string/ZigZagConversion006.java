import java.lang.StringBuilder;
class ZigZagConversion006 {
	public String convert(String s, int numRows) {
        if (numRows == 1) { return s; }
        // initialize the container
        StringBuilder[] zigzag = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) { zigzag[i] = new StringBuilder(); }

        int num2 = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
        	if (i / numRows == i / num2) {
        		zigzag[i % numRows].append(s.charAt(i));
        	}
        	else {
        		zigzag[numRows - i % numRows - 2].append(s.charAt(i));
        	}
        }

        String zig = new String();
        for (int i = 0; i < numRows; i++) {
        	zig += new String(zigzag[i]);
        }

        return zig;
    }
}