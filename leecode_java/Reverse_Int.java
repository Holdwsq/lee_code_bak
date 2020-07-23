package code.wsq;

public class Reverse_Int {
	public int reverse(int x) {
		boolean negative_num  = false;
		long tmp_x = x;
		if(tmp_x < 0) {
			negative_num = true;
			tmp_x = -tmp_x;
		}
		long ans_num = 0;
		while(tmp_x != 0) {
			long remain_num = tmp_x % 10;
			tmp_x = tmp_x / 10;
			if(ans_num == 0 && remain_num == 0) {
				 continue;
			}
			ans_num = ans_num * 10 + remain_num;
		}
		
		if(negative_num) {
			if(ans_num > Math.pow(2, 31)) {
				ans_num = 0;
			}else {				
				ans_num = -ans_num;
			}
		}else {
			if(ans_num > Math.pow(2, 31) -1) {
				ans_num = 0;
			}
		}
		return (int) ans_num;
	}
	public static void main(String[] args) {
		int x = -2147483648;
		System.out.println(x % 10);
//		Reverse_Int r = new Reverse_Int();
//		int reverse_num = r.reverse(x);
//		System.out.println(reverse_num);
//		System.out.println(Integer.MAX_VALUE);
	}
}
