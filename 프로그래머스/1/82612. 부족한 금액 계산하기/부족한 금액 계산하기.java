class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long x =0;
        for(int i =1; i<=count; i++){
            x+= price*i;
        }
        if(x<money){
            answer =0;
        }else{
            answer = x-money;
        }
        return answer;
    }
}