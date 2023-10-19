import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
    	   HashMap<String, Integer> hm = new HashMap<String, Integer>();
           for(int i=0; i<players.length; i++) {
            hm.put(players[i], i);
           }
           
           for(String calling : callings) {
           int rank = hm.get(calling);
           String bplayer = players[rank-1];
           players[rank-1] = calling;
           players[rank] = bplayer;
           
           hm.put(calling, rank-1);
           hm.put(bplayer, rank);
           }
           
           
           return players;
       }

    }