class Solution {
    public int solution(int n) {
      int a =0;
    if(n%7==0) {
    	a = (int)n/7;
    }else {
    	a+= (int)n/7+1;
    }return a;
        
    }
}