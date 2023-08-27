import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String answer = "";
        
        String s = String.valueOf(n);
        
        int[] nums = new int[s.length()];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        
        Arrays.sort(nums);
        
        for (int i = nums.length - 1; i >= 0 ; i--) {
            answer += String.valueOf(nums[i]);
        }
        
        return Long.parseLong(answer);
    }
}