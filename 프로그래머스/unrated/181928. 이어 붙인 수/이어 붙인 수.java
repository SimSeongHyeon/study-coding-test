class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        String oddNumToStr = new String();
        String evenNumToStr = new String();
        
        for (int i : num_list) {
            if (i % 2 == 1) {
                evenNumToStr += i;
            } else {
                oddNumToStr += i;
            }
        }
        
        answer = Integer.parseInt(evenNumToStr) + Integer.parseInt(oddNumToStr);
        return answer;
    }
}