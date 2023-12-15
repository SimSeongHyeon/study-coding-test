class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sq_sum = 0;
        
        for (int i : num_list) {
            mul *= i;
            sq_sum += i;
        }
        
        sq_sum *= sq_sum;
            
        if (mul < sq_sum) return 1;
        else return 0;
    }
}