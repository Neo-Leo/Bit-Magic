/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/hamming-distance/
 */ 

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int temp = x^y; 
        int count = 0, one = 1; 
        while(temp > 0) {
            if((temp&one) == 1) {
                count++; 
            }
            temp = temp >> 1; 
        }
        return count; 
    }
}