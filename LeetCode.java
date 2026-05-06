class LeetCode {
    public int sumOfTheDigitsOfHarshadNumber(int x) {

        int sum = 0, temp = x;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (sum == 0) return -1;

        return (x % sum == 0) ? sum : -1;
    }
}