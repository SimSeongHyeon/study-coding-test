class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        
        long needed_money = 0;
        
        for (int i = 1; i <= count; i++) {
            long temp = price * i;
            needed_money += temp;            
        }
        
        answer = needed_money - money > 0 ? needed_money - money : 0;
        
        return answer;
    }
}