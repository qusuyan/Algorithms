import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); int c = in.nextInt();
        int[][] apps = new int[n][2];
        for (int i = 0; i < n; i ++) {
            apps[i][0] = in.nextInt();
            apps[i][1] = in.nextInt();
        }

    }

}
