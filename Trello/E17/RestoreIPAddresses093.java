import java.util.List;
import java.util.ArrayList;
// import java.util.StringBuilder;

class RestoreIPAddresses093 {
	public List<String> restoreIpAddresses(String s) {
		List<String> ipList = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) { return ipList; }
		for (int i = 1; i <= 3; i++) {
			if (s.length() - i > 9) { continue; }
			if (isValidIP(s.substring(0, i))) {
				List<String> subList = validThreeIP(s.substring(i));
				if (subList.size() == 0) { continue; }
				for (String str : subList) {
					ipList.add(s.substring(0, i)+"."+str);
				}
			}
		}

		return ipList;
	}

	private List<String> validThreeIP(String s) {
		List<String> ipList = new ArrayList<String>(); 
		if (s == null || s.length() < 3 || s.length() > 9) { return ipList; }
		for (int i = 1; i <= 3; i++) {
			if (s.length() - i > 6) { continue; }
			if (isValidIP(s.substring(0, i))) {
				List<String> subList = validTwoIP(s.substring(i)); // get the valid subtwolist
				for (String str : subList) {
					ipList.add(s.substring(0, i)+"."+str);
				}
			}
		}
		return ipList;
	}

	private List<String> validTwoIP(String s) {
		List<String> ipList = new ArrayList<String>();
		if (s == null || s.length() < 2 || s.length() > 6) { return ipList; }
		int length = (s.length() > 3 ? 4 : s.length());
		for (int i = 1; i < length; i++) {
			if (s.length() - i > 3) { continue; }
			if (isValidIP(s.substring(0, i)) && isValidIP(s.substring(i))) {
				ipList.add(s.substring(0, i)+"."+s.substring(i));
			}
		}
		return ipList;
	}

	private boolean isValidIP(String s) {
		// This is only for s contained of digits

		int v = Integer.valueOf(s);
		if (String.valueOf(v).length() < s.length()) { return false; }
		return v >= 0 && v <= 255;
	}
	public static void main(String[] args) {
		RestoreIPAddresses093 r = new RestoreIPAddresses093();
		String a = "122";
		String b = "123";
		String[] c = new String[3];
		// 
		System.out.println(r.restoreIpAddresses("010010"));
	}
}