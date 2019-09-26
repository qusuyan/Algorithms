import java.util.Scanner;

public class ACorr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] train = new int[n];
        for (int i = 0; i < n; i++) {
            train[i] = in.nextInt();
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[n][2];
        dp[n-1][0] = 1; dp[n-1][1] = 1;
        for (int i = n-2; i >= 0; i--) {
            dp[i][0] = 1; dp[i][1] = 1;
            for (int j = i + 1; j < n; j++) {
                if (train[j] > train[i] && dp[j][0] + 1 > dp[i][0])
                    dp[i][0] = dp[j][0] + 1;
                if (train[j] < train[i] && dp[j][1] + 1 > dp[i][1])
                    dp[i][1] = dp[j][1] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[i][0] + dp[i][1])
                max = dp[i][0] + dp[i][1];
        }

        System.out.println(max - 1);
    }

}
