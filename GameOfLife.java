/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/game-of-life/
 * T(n) = O(mn)	
 */ 

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return; 
        int rows = board.length, cols = board[0].length, liveCount=0, one=1, two=2; 
        for(int i=0; i<=rows-1;i++) {
            for(int j=0; j<=cols-1;j++) {
                liveCount = 0; 
                // Straight
                if(i != 0 && ((board[i-1][j]&one) == 1)) liveCount++; // Top
                if(i != rows-1 && ((board[i+1][j]&one) == 1)) liveCount++; // Bottom
                if(j != 0 && ((board[i][j-1]&one) == 1)) liveCount++; // Left
                if(j != cols-1 && ((board[i][j+1]&one) == 1)) liveCount++; // Right
                // Cross    
                if(i != 0 && j != 0 && ((board[i-1][j-1]&one) == 1)) liveCount++; // Top-left
                if(i != 0 && j != cols-1 && ((board[i-1][j+1]&one) == 1)) liveCount++; // Top-Right
                if(i != rows-1 && j != 0 && ((board[i+1][j-1]&one) == 1)) liveCount++; // Bottom-left
                if(i != rows-1 && j != cols-1 && ((board[i+1][j+1]&one) == 1)) liveCount++; // Bottom-Right
                    
                if(board[i][j] == 1){ // Live cell. 
                    if(liveCount >= 2 && liveCount <= 3) board[i][j] |= two;  
                } else { //Dead Cell
                    if(liveCount == 3) board[i][j] |= two;
                }       
            }
        }
        
        for(int i=0; i<=rows-1;i++){
            for(int j=0; j<=cols-1;j++) {
                board[i][j] >>= 1;        
            }
        }
    }
}