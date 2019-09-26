import java.util.Scanner;

public class E {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            double p = in.nextDouble();

            // P(i+1, k) = P(i, k-1) * p
            // Q(i+1, k) = Q(i, k) + P(i, k) * (1 - p)
            // sum{ [P(n, k) + Q(n,k)] * k }

        }
    }

}
