class StringtoInteger008 {
	/*
	The function first discards as many whitespace characters as necessary until 
	the first non-whitespace character is found. 丢弃空白符
	Then, starting from this character, takes an optional initial plus or minus 
	sign followed by as many numerical digits as possible, and interprets them 
	as a numerical value. 第一个非空字符如果是符号的话，看后面跟着的数字

	The string can contain additional characters after those that form the integral 
	number, which are ignored and have no effect on the behavior of this function.
	数字后面还可以跟无关的字符

	If the first sequence of non-whitespace characters in str is not a valid integral
	number, or if no such sequence exists because either str is empty or it contains 
	only whitespace characters, no conversion is performed. 如果第一个字符非valid，返回0

	If no valid conversion could be performed, a zero value is returned.
	*/
	public int myAtoi(String str) {
		
		// locate the firstNonWhite index
		int firstNonWhite = 0;
		for (; firstNonWhite < str.length(); firstNonWhite++) {
			if (!(str.charAt(firstNonWhite) == ' ')) break;
		}

		int lastDigit = firstNonWhite; boolean sign = false; boolean negative = false;
		for (; lastDigit < str.length(); lastDigit++) {
			if (lastDigit == firstNonWhite && (str.charAt(lastDigit) == '+' || str.charAt(lastDigit) == '-')) {
				sign = true;
				negative = (str.charAt(lastDigit) == '-' ? true : false);
				continue; 
			}
			if (!isDigit(str.charAt(lastDigit))) break;
		}

		// if sign, we only get the number after the sign
        if (sign) { firstNonWhite++; }
        // delete the leading 0s
        while ( firstNonWhite < str.length() && str.charAt(firstNonWhite) == '0') { firstNonWhite++; }
        if (lastDigit == firstNonWhite) return 0;

		// [firstNonWhite, lastDigit)
		// int toInt = Integer.parseInt(String.valueOf(str.substring(firstNonWhite, lastDigit)));
		String max = String.valueOf(Integer.MAX_VALUE);
        	
		if (lastDigit - firstNonWhite > max.length()) return (negative ? Integer.MIN_VALUE : Integer.MAX_VALUE);
		else if (lastDigit - firstNonWhite == max.length()) {
			if (str.substring(firstNonWhite, lastDigit).compareTo(max) > 0) 
                return (negative ? Integer.MIN_VALUE : Integer.MAX_VALUE);
		}
		
        // all valid
        return negative ? -Integer.parseInt(str.substring(firstNonWhite, lastDigit)) : Integer.parseInt(str.substring(firstNonWhite, lastDigit));
    }

    private boolean isDigit(char d) {
    	return (d - '0' >= 0 && d - '9' <= 0);
    }

    public static void main(String[] args) {
    	System.out.println(Integer.MAX_VALUE);
    	System.out.println(Integer.MIN_VALUE);
    	System.out.println(3*"-1");

    }
}