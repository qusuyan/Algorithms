import java.util.*;

public class A {

    static Map<List<Integer>, Integer> dp;
    static int[] train;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        train = new int[n];
        for (int i = 0; i < n; i++) {
            train[i] = in.nextInt();
        }

        dp = new HashMap<>();
        int ans = recurse(0, 10000, 0);
        System.out.println(ans);
    }

    public static int recurse(int curr, int min, int max) {
        if (curr >= train.length)
            return 0;
        List<Integer> key = Arrays.asList(curr, min, max);
        Integer val = dp.get(key);
        if (val != null)
            return val;

        int a = recurse(curr + 1, min, max);
        int ans;
        if (train[curr] > min && train[curr] < max) {
            ans = a;
        } else if (train[curr] <= min) {
            int b = recurse(curr + 1, train[curr], (train[curr] >= max) ? train[curr] : max) + 1;
            ans = Math.max(a, b);
        } else {
            int b = recurse(curr + 1, min, train[curr]) + 1;
            ans = Math.max(a, b);
        }
        dp.put(key, ans);
        return ans;
    }

}
