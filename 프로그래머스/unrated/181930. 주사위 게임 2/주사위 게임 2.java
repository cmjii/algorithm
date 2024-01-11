class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if(a!=b && a!=c && b!=c) {
        	answer = a+b+c;
        }else if(a==b&&a==c&&b==c) {
        	answer = (a+b+c)*(a*a+c*c+b*b)*(a*a*a+b*b*b+c*c*c);
        }else {
        	answer = (a+b+c)*(a*a+c*c+b*b);
        }
        return answer;
    }
}