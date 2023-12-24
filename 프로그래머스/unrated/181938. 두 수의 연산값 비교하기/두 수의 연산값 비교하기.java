	class Solution {
	    public int solution(int a, int b) {
	        int answer = 0;
	        String t = Integer.toString(a) + Integer.toString(b);
	        int tmp = Integer.parseInt(t);
	        int tmp2 = 2*a*b;
	        if(tmp>tmp2) {
	        	return tmp;
	        }else if(tmp<tmp2) {
	        	return tmp2;
	        }else {
	        	return tmp;
	        }
	    }
	}