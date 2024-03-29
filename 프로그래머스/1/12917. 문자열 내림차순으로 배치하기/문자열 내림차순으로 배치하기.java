import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] asc = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            asc[i] = (int) s.charAt(i);
        }
        Arrays.sort(asc);
       for (int i = asc.length - 1; i >= 0; i--) {
            answer += (char) asc[i];
        }
        return answer;
    }
}