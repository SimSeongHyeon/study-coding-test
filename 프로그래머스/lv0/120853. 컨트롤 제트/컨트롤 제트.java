class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] nums = s.split(" ");
        
        for (int i = 0; i < nums.length; i++) {
            if (!nums[i].equals("Z")) {
                answer += Integer.parseInt(nums[i]);
            }
            
            else {
                answer -= Integer.parseInt(nums[i - 1]);
            }
        }
        return answer;
    }
}