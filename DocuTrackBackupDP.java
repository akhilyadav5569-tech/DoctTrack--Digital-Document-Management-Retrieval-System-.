public class DocuTrackBackupDP {

    public static int knapsack(int capacity, int size[],
                               int importance[], int n) {

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= capacity; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                else if (size[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            importance[i - 1]
                            + dp[i - 1][w - size[i - 1]],
                            dp[i - 1][w]);
                }
                else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[] size = {2, 3, 4, 5};
        int[] importance = {4, 5, 7, 10};

        int capacity = 8;

        int result = knapsack(
                capacity,
                size,
                importance,
                size.length);

        System.out.println(
                "Maximum Backup Importance = " + result);
    }
}