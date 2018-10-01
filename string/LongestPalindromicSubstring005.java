class LongestPalindromicSubstring005 {
	// dynamic programming
	// 首先本题有两种情况，一种是偶数个的palindromic substring, 一种是奇数个的
	// 假定P(i, j)表示s的substring(从i到j)是palindromic的
	// 那么我们可以从两种情况开始"expand": P(i, i) 奇数个 和 P(i, i + 1) 偶数个
	// 只要在一定范围内符合条件 我们就expand it， 最后返回length
	// 由于palindromic是镜像的，所以有i,有length，我们就可以得到start 和 end

	// 我们用start 和end来记录当前palindromic substring的index和最大长度
	// 但我们也是先比较P(i, i)和P(i, i+1)哪个长度更大，将更大的那个再和当前的长度比较
	// 把最长的那个存放在start 和 end中
	public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int start = 0; int end = 0;
        for (int i = 0; i < s.length(); i++) {
        	int len1 = palindrome(s, i, i);
        	int len2 = palindrome(s, i, i + 1);
        	int len = Math.max(len1, len2);
        	if (len > end - start) {
        		start = i - (len - 1) / 2;
        		end = i + len / 2;
        	}
        }
        return s.substring(start, end + 1);
    }

    private int palindrome(String s, int center1, int center2) {
    	// expand the center according to valid rules
    	// 如果center1 == center2, 那么返回的情况是: 1, 3, 5, 7, ...
    	// 如果center1 != center2, 那么返回的情况是: 0, 2, 4, 6, ...
    	int left = center1;
    	int right = center2;
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left--;
    		right++;
    	}
    	return right - left - 1;

    }
}