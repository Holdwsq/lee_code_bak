package code.wsq.notsubmit;

public class ClimbStairs {
    public int climbStairs(int n) {
    	int p = 0, q = 0, r = 1;
    	
    	for(int i = 1; i <= n; ++i) {
    		p = q;
    		q = r;
    		r = p + q;
    	}
    	
    	return r;
    }
    public static void main(String[] args) {
    	int n = 2;
    	ClimbStairs cs = new ClimbStairs();
    	int ans = cs.climbStairs(n);
    	System.out.println(ans);
	}
}
