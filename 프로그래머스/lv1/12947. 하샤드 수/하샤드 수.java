class Solution {
    public boolean solution(int x) {
        int x1 = x;
        int sum = 0;
        while (x1!=0) {
            sum += x1%10;
            x1 /= 10;
        }
        if(x % sum == 0) {
            return true;
        }
        return false;
    }
}