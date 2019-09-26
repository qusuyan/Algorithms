import java.util.Scanner;

public class C {

    public static int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int iter = 0; iter < n; iter++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int[] s = new int[2];
            s[0] = in.nextInt();
            s[1] = in.nextInt();
            int m = in.nextInt();
            int[][] beepers = new int[m + 1][2];
            for (int i = 0; i < m; i++) {
                beepers[i][0] = in.nextInt();
                beepers[i][1] = in.nextInt();
            }

            int[][] dp = new int[1024][m];
            int ac = (1 << m) - 1;
            for (int i = 0; i < m; i++)
                dp[ac][i] = dist(beepers[i], s);

            for (int i = ac - 1; i > 0; i--) {
                int[] zero = new int[m];
                int[] one = new int[m];
                int c_zero = 0;
                int c_one = 0;
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) == 0)
                        zero[c_zero++] = j;
                    else
                        one[c_one++] = j;
                }
                int[] cost = new int[c_zero];
                for (int j = 0; j < c_zero; j++) {
                    int next = i + (1 << zero[j]);
                    cost[j] = dp[next][zero[j]];
                }

                for (int j = 0; j < c_one; j++) {
                    dp[i][one[j]] = Integer.MAX_VALUE;
                    for (int k = 0; k < c_zero; k++) {
                        int tmp = cost[k] + dist(beepers[one[j]], beepers[zero[k]]);
                        if (tmp < dp[i][one[j]])
                            dp[i][one[j]] = tmp;
                    }
                }
            }

            int shortest = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                int next = 1 << i;
                int cost = dp[next][i] + dist(beepers[i], s);
                if (cost < shortest)
                    shortest = cost;
            }

            System.out.println(shortest);
        }
    }

}
