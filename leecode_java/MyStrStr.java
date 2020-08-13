package code.wsq.notsubmit;

public class MyStrStr {
    public int strStr(String haystack, String needle) {
    	if(haystack == null || needle == null) {
    		return -1;
    	}
    	int n_len = needle.length();
		if(n_len == 0) {
    		return 0;
    	}
    	int h_len = haystack.length();
		if(h_len < n_len) {
    		return -1;
    	}
    	for(int i = 0; i < h_len - n_len + 1; ++i) {
    		if(haystack.charAt(i) == needle.charAt(0)) {
    			String substring = haystack.substring(i, Math.min(i + n_len, h_len));
    			if(substring.equals(needle)) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }
    public static void main(String[] args) {
    	String haystack = "hello";
    	String needle = "ll";
		MyStrStr ms = new MyStrStr();
		int ans = ms.strStr(haystack, needle);
		System.out.println(ans);
	}
}
