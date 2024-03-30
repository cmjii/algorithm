class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int ascii[] = new int [s.length()];
        if(s.length()==4||s.length()==6){
        for(int i =0; i<s.length(); i++){
            ascii[i]=s.charAt(i);
        }
        }
        for(int x : ascii){
            if(!(x<58)||!(x>47)){
                answer = false;
                break;
            }
        }
        return answer;
    }
}