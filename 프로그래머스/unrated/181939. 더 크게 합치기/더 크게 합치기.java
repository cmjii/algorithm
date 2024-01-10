class Solution {
    public int solution(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int x = Integer.parseInt(strA + strB);
        int y = Integer.parseInt(strB + strA);

        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
}