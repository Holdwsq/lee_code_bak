/**
 * 130. 被围绕的区域
 * @author Liu
 * @date 2020/8/11
	 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
	找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
	
	示例:
	X X X X
	X O O X
	X X O X
	X O X X
	
	运行你的函数后，矩阵变为：
	X X X X
	X X X X
	X X X X
	X O X X
	解释:

	被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 
	任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
	如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
	
	链接：https://leetcode-cn.com/problems/surrounded-regions
 */
package code.wsq.notsubmit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SurroundedArea {
//	Map<String, Integer> search_state = new HashMap<String, Integer>();
	Set<String> visited_str = new HashSet<String>();
	int row_len;
	int col_len;
    public void solve(char[][] board) {
    	row_len = board.length;
    	if(row_len == 0) {
    		return;
    	}
    	col_len = board[0].length;
    	// 获取边界点
    	String item;
    	for(int i = 0; i < row_len; ++i) {
    		if(i == 0 || i == row_len - 1) {
    			for(int j = 0; j < col_len; ++j) {
    				if(board[i][j] == 'O') {
    					item = i + "," + j;
    					if(!visited_str.contains(item)) {
							visited_str.add(item);
							bfs(board, i, j);
						}
    				}
    			}
    		}else {
    			if(board[i][0] == 'O') {
    				item = i + "," + 0;
					if(!visited_str.contains(item)) {
						visited_str.add(item);
						bfs(board, i, 0);
					}
    			}
    			if(board[i][col_len - 1] == 'O') {
    				item = i + "," + (col_len - 1);
					if(!visited_str.contains(item)) {
						visited_str.add(item);
						bfs(board, i, col_len - 1);
					}
    			}
    		}
    	}
    	
    	for(int i = 1; i < row_len - 1; ++i) {
    		for(int j =1; j < col_len - 1; ++j) {
    			if(board[i][j] == 'O' && !visited_str.contains(i + "," + j)) {
    				board[i][j] = 'X';
    			}
    		}
    	}
    }
    public void bfs(char[][] board, int row_id, int col_id) {
    	if(row_id + 1 < row_len && board[row_id + 1][col_id] == 'O') {
    		String item = (row_id + 1) + "," + col_id;
    		if(!visited_str.contains(item)) {
    			visited_str.add(item);
    			bfs(board, row_id + 1, col_id);
    		}
    	}
    	if(row_id - 1 >= 0 && board[row_id - 1][col_id] == 'O') {
    		String item = (row_id - 1) + "," + col_id;
    		if(!visited_str.contains(item)) {
    			visited_str.add(item);
    			bfs(board, row_id - 1, col_id);
    		}
    	}
    	if(col_id + 1 < col_len && board[row_id][col_id + 1] == 'O') {
    		String item = row_id + "," + (col_id + 1);
    		if(!visited_str.contains(item)) {
    			visited_str.add(item);
    			bfs(board, row_id, col_id + 1);
    		}
    	}
    	if(col_id - 1 >= 0 && board[row_id][col_id - 1] == 'O') {
    		String item = row_id + "," + (col_id - 1);
    		if(!visited_str.contains(item)) {
    			visited_str.add(item);
    			bfs(board, row_id, col_id - 1);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	char[][] board = {{'X','O','X','X'},
    					  {'X','O','O','X'},
    					  {'X','X','O','X'},
    					  {'X','O','X','X'}};
    	SurroundedArea sa = new SurroundedArea();
    	sa.solve(board);
//    	String s = 1 + "," + 2;
//    	System.out.println();
	}
}
