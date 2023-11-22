import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        ArrayList<Character> alphabet = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            alphabet.add((char)('a' + i));
        }
        
        for (Character c : skip.toCharArray()) {
            alphabet.remove(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Character c : s.toCharArray()) {
            int i = alphabet.indexOf(c);
            i = (i + index) % alphabet.size();
            sb.append(alphabet.get(i));
        }
        
        return sb.toString();
    }
}