class LC925 {
	public boolean isLongPressedName(String name, String typed) {
		if (name.length() == 0 || type.length() == 0) {
			if (name.length() == 0 && type.length() == 0) return true;
			return false;
		}

		int i = 0,  j = 0;
        if (name.charAt(i) != type.charAt(j)) return false;
        char c = name.charAt(i);
        while (i < name.length() && name.charAt(i) == c) { i++; }
        while (j < type.length() && type.charAt(j) == c) { j++; }
        if (j < i) return false;

        return isLongPressedName(name.substring(i), typed.substring(j));
    }
}