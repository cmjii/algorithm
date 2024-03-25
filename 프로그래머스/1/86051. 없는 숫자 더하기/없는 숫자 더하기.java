class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int a = 1+2+3+4+5+6+7+8+9;
        for(int i : numbers){
            a = a-i;
        }
        return a;
    }
}