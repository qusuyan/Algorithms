package src;

import java.util.*;

public class B {
    public static void main(String[] args) {
        char[] op = {'+', '-', '*', '/'};
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    char[] ops = {op[i], op[j], op[k]};
                    int[] num = {4, 4, 4, 4};
                    for (int m = 0; m < ops.length; m++) {
                        if (ops[m] == '*' || ops[m] == '/') {
                            num[m + 1] = (ops[m] == '*') ? num[m] * num[m + 1] : num[m] / num[m + 1];
                            num[m] = 0;
                            ops[m] = m > 0 ? ops[m-1] : '+';
                        }
                    }

                    int ans = num[0];
                    for (int m = 0; m < ops.length; m++) {
                        if (ops[m] == '+')
                            ans += num[m + 1];
                        else
                            ans -= num[m + 1];
                    }

                    String eq = "4 " + op[i] + " 4 " + op[j] + " 4 " + op[k] + " 4 = " + ans;
                    map.put(ans, eq);
                }
            }
        }

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int input = in.nextInt();
            System.out.println(map.getOrDefault(input, "no solution"));
        }
    }
}
