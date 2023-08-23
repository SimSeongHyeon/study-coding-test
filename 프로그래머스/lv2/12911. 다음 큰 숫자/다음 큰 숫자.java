class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int oneSumOfN = 0;
        
        String binaryN = Integer.toBinaryString(n);
        
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') oneSumOfN++;
        }
         
        while (true) {
            String binaryAns = Integer.toBinaryString(answer);
            int oneSumOfAns = 0;
            
            for (int i = 0; i < binaryAns.length(); i++) {
                if (binaryAns.charAt(i) == '1') oneSumOfAns++;
            }
            
            if (oneSumOfN == oneSumOfAns) return answer;
            
            answer++;
        }
    }
}