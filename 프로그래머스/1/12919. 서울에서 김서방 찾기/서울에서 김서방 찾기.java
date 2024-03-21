class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String a = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                a = Integer.toString(i);
                break;
            }
        }
        return "김서방은 " + a + "에 있다";
    }
}