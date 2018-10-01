class ExcelSheetColumnTitle168 {
	public String convertToTitle(int n) {
        // n is a positive integer
        StringBuilder str = new StringBuilder();

        while (n > 0) {
            int mod = (n - 1) % 26; // 'A' -- 0, 'B' -- 1, ..., 'Z' -- 25
        	str.insert(0, (char) (mod + 'A'));
        	n = (n - mod - 1) / 26;
        }

        return str.toString();
    }
}