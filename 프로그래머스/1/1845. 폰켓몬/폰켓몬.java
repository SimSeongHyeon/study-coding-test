class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        boolean[] type = new boolean[200001];
        
        for (int i : nums) {
            type[i] = true;
        }
        
        int cnt = 0; 
        
        for (int i = 0; i < type.length; i++) {
            if(type[i]) cnt++;    
        }
        
        answer = Math.min(cnt, nums.length / 2);
        
        return answer;
    }
}