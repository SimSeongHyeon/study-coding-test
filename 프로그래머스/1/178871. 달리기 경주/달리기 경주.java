import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndex = new HashMap<>();
        String[] answer = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int index = playerIndex.get(callings[i]);
            if (index != 0) {
                String temp = players[index - 1];
                players[index - 1] = callings[i];
                players[index] = temp;
                playerIndex.put(callings[i], index - 1);
                playerIndex.put(temp, index);
            }
        }

        return players;
    }
}
