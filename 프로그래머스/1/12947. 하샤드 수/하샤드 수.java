class Solution {
    public boolean solution(int x) {
        int y = x;
        String xx = Integer.toString(x);
        int[] num = new int[xx.length()];
        int sum = 0;
        for (int i = 0; i < xx.length(); i++) {
            num[i] = x % 10; // 각 자릿수를 가져와 배열에 저장합니다.
            sum += num[i]; // 각 자릿수를 더합니다.
            x = x / 10; // 다음 자릿수로 이동합니다.
        }
        if (y % sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}