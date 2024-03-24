class Solution {
    public String solution(String phone_number) {
        String answer = phone_number.substring(0,phone_number.length()-4).replaceAll(".","*");
        return answer+phone_number.substring(phone_number.length()-4);
    }
}