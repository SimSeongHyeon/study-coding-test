class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] countX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] countY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        for (int i = 0; i < X.length(); i++) {
            countX[X.charAt(i) - 48]++; 
        }
        
        for (int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i) - 48]++; 
        }
        
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Math.min(countX[i], countY[i]); j++) {
                sb.append(i);
            }
        }
        
        if ("".equals(sb.toString())) {
            return "-1";
        }
        
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}