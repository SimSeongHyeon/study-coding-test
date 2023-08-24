class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] rooms = new int[1450];
        
        for (int i = 0; i < book_time.length; i++) {
            rooms[calTime(book_time[i][0])]++;
            rooms[calTime(book_time[i][1]) + 10]--;
        }
        
        for (int i = 1; i < 1450; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }
        
        return answer;
    }
    
    public int calTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String min = split[1];
        
        return Integer.parseInt(hour) * 60 + Integer.parseInt(min);    
    }
}