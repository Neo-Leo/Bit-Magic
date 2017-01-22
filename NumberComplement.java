/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/number-complement/
 */ 

public class NumberComplement {
    public int findComplement(int num) {
        if(num == 0) return 1; 
        
        int bitPosition=31, i=1<<31;
        
        while(bitPosition>=0 && (num&i)==0){
            i=i>>>1; 
            bitPosition--;
        }
        
        while(bitPosition>=0){
            if((num&i) != 0){
                num = num&(~i);
            } else {
                num = num|i;
            }
            i=i>>1; 
            bitPosition--;
        }
        
        return num; 
    }
}