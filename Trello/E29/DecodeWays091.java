class DecodeWays091 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) { return 0; }
		int[] combs = new int[s.length()]; // to save and calculate the # decoding
		for (int i = 0; i < combs.length; i++) {
			// the first element, we should pay attention that the first element may be 0
			// if the first element is 0, we just return 0
			if (i == 0) { 
				if (s.charAt(0) == '0') return 0;
				combs[i] = 1; 
				continue; 
			}
			// i >= 1
			// get the 2-digit number
			int num = Integer.parseInt(s.substring(i - 1, i + 1));
			if (num == 0) { return 0; } // num == 0 means "00", it is not allowed
			
			// 如果后面有0，那么该数必须与0捆绑，因此只需使其数字与前面的相同即可
			// 进入下一次循环，因为该数已经和0捆绑了，不能再和其他数进行组合
            if (i < combs.length - 1 && s.charAt(i + 1) == '0') { combs[i] = combs[i - 1]; continue; }
			// 判断成立条件: [11, 26] 且不包含20的，可以成立
			if (num <= 26 && num > 10 && num != 20) { 
				if (i == 1) { combs[i] = 2; } 
				else { combs[i] = combs[i - 1] + combs[i - 2]; }
			}
            // 而如果>=30，那么该数无论如何也没办法decode
            // 这是因为：0不能独立存在，0不能作为开头，所以0必须与前面的数字绑定
            // 既然必须绑定，又超过了阈值26，因此认为decode无效
            else if (num % 10 == 0 && num > 20) {
                return 0;
            }
            // 其他的情况就是以0开头，或者以0结尾，比如01, 02, ...10
            // [1,10]及20的情况，这样的话不能组成更多的
			else {
				combs[i] = combs[i - 1];
			}
		}
		return combs[combs.length - 1];
	}

	public int numDecodings2(String s) {
		int[] combs = new int[s.length()]; // to save and calculate the # decoding
		if (s.charAt(0) == 0) { return 0; }
		combs[0] = 1;
		for (int i = 1; i < combs.length; i++) {
			int num1 = Integer.parseInt(s.substring(i, i + 1));
			int num2 = Integer.parseInt(s.substring(i - 1, i + 1));
			if (num1 >= 1 && num1 <= 9) {
				combs[i] += combs[i - 1];
			}
			if (num2 >= 10 && num2 <= 26) {
				if (i == 1) { combs[i] += 1; }
				else { combs[i] += combs[i - 2]; }
			}
		}
		return combs[s.length() - 1];
	}

	public static void main(String[] args) {
		DecodeWays091 d = new DecodeWays091();
		System.out.println(d.numDecodings2("10120222203"));
	}


}