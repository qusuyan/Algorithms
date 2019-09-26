import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        int a, b;
        int[][] paths;
        int[][] dp;
        Scanner in = new Scanner(System.in);
        while ((a = in.nextInt()) != 0) {
            b = in.nextInt();
            paths = new int[a+1][a+1];
            for (int i = 0; i < b; i++) {
                int f = in.nextInt(); int t = in.nextInt(); int c = in.nextInt();
                paths[f][t] = c; paths[t][f] = c;
            }



        }
    }

}
