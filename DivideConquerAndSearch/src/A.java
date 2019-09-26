package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        int a = 1;
        List<Integer> den = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        num.add(0);
        num.add(1);
        while (a <= 1000000) {
            a *= 3;
            if (finite(a - 1))
                den.add(a);
            List<Integer> span = new ArrayList<>();
            for (Integer integer : num) {
                span.add(integer + a);
            }
            num.addAll(span);
        }
        Set<Double> set = new HashSet<>();
        den.forEach(d -> num.forEach(n -> set.add(n * 2.0 / (d - 1))));

        Scanner in = new Scanner(System.in);
        String input;
        while (!(input = in.nextLine()).equals("END")) {
            double tmp = Double.parseDouble(input);
            System.out.println((set.contains(tmp))?"MEMBER":"NON-MEMBER");
        }
    }

    public static boolean finite(int a) {
        if (a == 0)
            return true;
        while (a % 2  == 0) {
            a /= 2;
        }
        while (a % 5 == 0) {
             a /= 5;
        }
        return a == 1;
    }

}
