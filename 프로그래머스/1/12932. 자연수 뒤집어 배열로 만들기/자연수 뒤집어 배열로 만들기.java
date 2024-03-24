class Solution {
    public int[] solution(long n) {
        String x = String.valueOf(n);
        int a = x.length() - 1;
        int[] answer = new int[x.length()];
        for (int i = 0; i < x.length(); i++) { 
            answer[i] = x.charAt(a--) - '0'; // 문자를 정수로 변환하여 저장
        }
        return answer;
    }
}