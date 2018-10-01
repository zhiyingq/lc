class IntegerToRoman012 {
	public String intToRoman(int num) {
		int digit = 1;
		String roman = "";
		while (num > 0) {
			String number = getSymbol(num % 10, digit++);
			number += roman;
			roman = number;
			num /= 10;
		}
		return roman;     
    }

    private String getSymbol(int num, int digit) {
    	swith(digit) {
    		case 1: 
    			if (num == 4) { return "IV"; }
    			if (num == 9) { return "IX"; }
    			if (num < 4) { return getNumber(num, "I"); }
    			return "V" + getNumber(num - 5, "I");
    		case 2:
    			if (num == 4) { return "XL"; }
    			if (num == 9) { return "XC"; }
    			if (num < 4) { return getNumber(num, "X"); }
    			return "L" + getNumber(num - 5, "X");
    		case 3:
    			if (num == 4) { return "CD"; }
    			if (num == 9) { return "CM"; }
    			if (num < 4) { return getNumber(num, "C"); }
    			return "D" + getNumber(num - 5, "C");
    		case 4:
    			return getNumber(num, "M");
    	}
    	return "";
    }

    private String getNumber(int num, String symbol) {
    	String number = "";
    	for (int i = 0; i < num; i++) {
    		number += symbol;
    	}
    	return number;
    }

}