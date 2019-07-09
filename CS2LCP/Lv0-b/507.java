class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                sum += i + (i == num / i ? 0 : num / i);
            }
        }
        return sum == num;
    }
}