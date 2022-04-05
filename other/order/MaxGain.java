/*
Prices = [2, 3, 10, 1, 12, 80, 6, 8, 30]
find the highest profite from this list in a linear time window
for exemple in this list it's 80 - 1
*/


class MaxGain {
    public static void main(String[] args) {
        System.out.println(maxGain(new int[]{2, 3, 10, 1, 12, 80, 6, 8, 30}));
    }

    public static int maxGain(int[] prices) {
        int res = 0;
        int a = 0, b = 1;
        while (a < b && b < prices.length) {
            if (prices[a] < prices[b]) {
                res = Math.max(prices[b] - prices[a], res);
                b++;
            } else {
                a = b;
                b = a + 1;
            }
        }
        return res;
    }
}