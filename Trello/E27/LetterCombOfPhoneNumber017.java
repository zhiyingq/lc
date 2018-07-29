import java.lang.IllegalArgumentException;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder; 

class LetterCombOfPhoneNumber017 {
	/*
	本题思路： 
	用一个char数组保存所有数字对应的字符
	dfs的主要思路就是，对于一个stringbuilder,不断append，直到s.length = 规定长度为止
	一旦加完，再去掉，这对于最后一个dfs很好理解
	其他的都是加了再删，删了再加，以此类推

	其实等到一个append完，说明它后面所有的情况都已经遍历过了
	到时候再删掉就可以了
	*/
	public List<String> letterCombinations(String digits) {
		List<String> sList = new ArrayList<String>();
		if (digits == null || digits.length() == 0) { return sList; }
		char[][] charList = new char[digits.length()][];
		for (int i = 0; i < digits.length(); i++) {
			charList[i] = getChars(digits.charAt(i) - '0');
		}
		StringBuilder sb = new StringBuilder();		
		// 以上，新建了一个charList存放digits对应的数字及其取值
		dfs(sList, 0, charList, sb);
		return sList; 
	}

	private void dfs(List<String> sList, int i, char[][] charList, StringBuilder sb) {
		if (i >= charList.length) { return; }
		for (int j = 0; j < charList[i].length; j++) {
			sb.append(charList[i][j]);
			if (sb.length() == charList.length) {
				sList.add(sb.toString());
			}
			else { dfs(sList, i + 1, charList, sb); }
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private char[] getChars(int n) {
		switch (n) {
			case 2 : return new char[] {'a', 'b', 'c'};
			case 3 : return new char[] {'d', 'e', 'f'};
			case 4 : return new char[] {'g', 'h', 'i'};
			case 5 : return new char[] {'j', 'k', 'l'};
			case 6 : return new char[] {'m', 'n', 'o'};
			case 7 : return new char[] {'p', 'q', 'r', 's'};
			case 8 : return new char[] {'t', 'u', 'v'};
			case 9 : return new char[] {'w', 'x', 'y', 'z'};
			default: throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {
		LetterCombOfPhoneNumber017 l = new LetterCombOfPhoneNumber017();
		List<String> list = l.letterCombinations("2323");
		System.out.println(list);
		System.out.println(list.size());
	}
}