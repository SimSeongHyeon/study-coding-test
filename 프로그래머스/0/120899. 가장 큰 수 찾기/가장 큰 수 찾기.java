class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        answer[0] = array[0];
        
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] < array[i + 1]) {
                answer[0] = array[i + 1];
                answer[1] = i + 1;
            }
        }
        return answer;
    }
}