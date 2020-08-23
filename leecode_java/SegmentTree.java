package code.wsq.notsubmit;

public class SegmentTree {
	public static int MAX_LEN = 1000;
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11};
		int[] segTree = new int[MAX_LEN];
		int start = 0;
		int end = arr.length - 1;
		int node = 0;
		// 构建线段树
		buildTree(arr, segTree, start, end, node);
		for(int i = 0; i < 15; i++) {
			System.out.println("node[" + i + "] = " + segTree[i]);
		}
		// 查询数组的某线段内的数字和
		int L = 2;
		int R = 5;
		int total_sum = query(segTree, start, end, node, L, R);
		System.out.println("the sum of [" + L + "," + R + "] is " + total_sum);
		
		// 更新线段树
		int idx = 4;
		int val = 6;
		update(arr, segTree, start, end, node, idx, val);
		
		// 查询数组的某线段内的数字和

		total_sum = query(segTree, start, end, node, L, R);
		System.out.println("the sum of [" + L + "," + R + "] is " + total_sum);
	}
	/**
	 * 	构建线段树
	 * @param arr 原始数组
	 * @param segTree 保存线段树的数组
	 * @param start 线段的起始位置
	 * @param end   线段的终止位置
	 * @param node  所在的节点位置
	 */
	private static void buildTree(int[] arr, int[] segTree, int start, int end, int node) {
		// TODO Auto-generated method stub
		if(start == end) {
			segTree[node] = arr[start];
			return;
		}
		int mid = (start + end) >> 1; 
		int leftNode = 2 * node + 1;
		int rightNode = 2 * node + 2;
		
		buildTree(arr, segTree, start, mid, leftNode);
		buildTree(arr, segTree, mid + 1, end, rightNode);
		segTree[node] = segTree[leftNode] + segTree[rightNode];
	}
	/**
	 * 	查询数组的线段和
	 * @param segTree 构建好的线段树
	 * @param start	  node节点对应的线段起始位置
	 * @param end	  node节点对应的线段终止位置
	 * @param node	     当前节点坐在位置
	 * @param L 	     所求线段的起始位置
	 * @param R	               所求线段的终止位置
	 * @return
	 */
	private static int query(int[] segTree, int start, int end, int node, int L, int R) {
		// TODO Auto-generated method stub
		System.out.println("start:" + start);
		System.out.println("end:" + end);
		
		if(start >= L && end <= R) {
			return segTree[node];
		}
		if(R < start || L > end) {
			return 0;
		}
		int mid = (start + end) >> 1;
		int leftNode = 2 * node + 1;
		int rightNode = 2 * node + 2;
		
		int sum_left = query(segTree, start, mid, leftNode, L, R);
		int sum_right = query(segTree, mid + 1, end, rightNode, L, R);
		
		return sum_left + sum_right;
	}
	/**
	 * 	更新线段树
	 * @param arr
	 * @param segTree
	 * @param start
	 * @param end
	 * @param node
	 * @param idx
	 * @param val
	 */
	private static void update(int[] arr, int[] segTree, int start, int end, int node, int idx, int val) {
		// TODO Auto-generated method stub
		System.out.println("start:" + start);
		System.out.println("end:" + end);
		if(start == end) {
			arr[idx] = val;
			segTree[node] = val;
			return;
		}
		
		int mid = (start + end) >> 1;
		int leftNode = 2 * node + 1;
		int rightNode = 2 * node + 2;
		
		if(idx >= start && idx <= mid) {
			update(arr, segTree, start, mid, leftNode, idx, val);
		}else {
			update(arr, segTree, mid + 1, end, rightNode, idx, val);
		}
		segTree[node] = segTree[leftNode] + segTree[rightNode];
	}
}
