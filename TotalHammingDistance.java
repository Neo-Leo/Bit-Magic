/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/total-hamming-distance/
 */ 

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int[] ones = new int[32]; 
        int[] zeroes = new int[32];
        int result = 0, one=1; 
        for(int num : nums){
            int bitpos = 0; 
            while(bitpos <= 31){
                if((num&one) == 1){
                    ones[bitpos]++; 
                } else {
                    zeroes[bitpos]++; 
                }
                num = num>>1;
                bitpos++;
            }
        }
        for(int i=0; i<=31; i++){
            result += ones[i]*zeroes[i]; 
        }
        return result; 
    }
}