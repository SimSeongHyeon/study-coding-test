class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] buttonCounts = new int[26];
        
        for (String button : keymap) {
            for (int i = 0; i < button.length(); i++) {
                char alphabet = button.charAt(i);
                if (buttonCounts[alphabet - 'A'] == 0 || i + 1 < buttonCounts[alphabet - 'A']) {
                    buttonCounts[alphabet - 'A'] = i + 1;
                }
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int i = 0 ; i < targets.length; i++) {
            int counts = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int count = buttonCounts[targets[i].charAt(j) - 'A'];
                if (count == 0) {
                    System.out.println("count: " + count);
                    answer[i] = -1;
                    break;
                } else {
                    counts += count;
                }
            }
            
            if (answer[i] != -1) {
                answer[i] = counts;
            }
        }
        
        return answer;
    }
}