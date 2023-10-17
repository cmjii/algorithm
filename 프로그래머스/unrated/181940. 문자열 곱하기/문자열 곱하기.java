class Solution {
    public String solution(String my_string, int k) {
        StringBuilder st = new StringBuilder();
        for(int i =1; i<=k; i++) {
        	st.append(my_string);
        }
        return st.toString();
    }
}