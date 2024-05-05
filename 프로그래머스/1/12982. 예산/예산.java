import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int num =0;
        Arrays.sort(d);
        for(int i : d){
            if(answer<=budget){
                answer+=i;
                num++;
            }
            if(answer>budget){
                num--;
                break;
            }
        }
        return num;
    }
}