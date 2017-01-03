/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */ 

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask=0, max=0; 
        for(int i=30; i>=0; i--) {
            mask = mask | (1<<i); 
            HashSet<Integer> hs = new HashSet<Integer>(); 
            for(int num : nums) {
                hs.add(num&mask); 
            }
            int candidate = max | (1<<i); 
            for(int prefix : hs) {
                if(hs.contains(candidate ^ prefix)) {
                    max = candidate; 
                    break; 
                } 
            }
        }
        return max; 
    }
}