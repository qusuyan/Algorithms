package src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

    static int r, c, g_r, g_c, l_r, l_c;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        loop: do {
            String input;
            try {
                input = in.nextLine();
            } catch (Exception e) {
                break;
            }
            String[] tmp = input.split(" ");
            r = Integer.parseInt(tmp[0]);
            c = Integer.parseInt(tmp[1]);
            g_r = Integer.parseInt(tmp[2]);
            g_c = Integer.parseInt(tmp[3]);
            l_r = Integer.parseInt(tmp[4]);
            l_c = Integer.parseInt(tmp[5]);

            boolean[][] explored = new boolean[r+1][c+1];
            PriorityQueue<Point> queue = new PriorityQueue<>();
            Point init = new Point(g_r, g_c, 0, dist(g_r, g_c, l_r, l_c));
            queue.add(init);

            while (!queue.isEmpty()) {
                Point curr = queue.poll();
                if (explored[curr.x][curr.y])
                    continue;
                explored[curr.x][curr.y] = true;
                if (curr.h == 0) {
                    System.out.println(curr.g / 3);
                    continue loop;
                }
                queue.addAll(curr.getSuccessor(explored));
            }

            System.out.println("impossible");

        } while (true);
    }

    public static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1  - y2);
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int g;
        int h;

        public Point(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
        }

        public List<Point> getSuccessor(boolean[][] explored) {
            List<Point> ret = new ArrayList<>();
            if (x - 2 > 0) {
                if (y - 1 > 0 && !explored[x - 2][y - 1]) {
                    ret.add(new Point(x - 2, y - 1, g + 3, dist(x - 2, y - 1, l_r, l_c)));
                }
                if (y + 1 <= c && !explored[x - 2][y + 1]) {
                    ret.add(new Point(x - 2, y + 1, g + 3, dist(x - 2, y + 1, l_r, l_c)));
                }
            }
            if (x - 1 > 0) {
                if (y - 2 > 0 && !explored[x - 1][y - 2]) {
                    ret.add(new Point(x - 1, y - 2, g + 3, dist(x - 1, y - 2, l_r, l_c)));
                }
                if (y + 2 <= c && !explored[x - 1][y + 2]) {
                    ret.add(new Point(x - 1, y + 2, g + 3, dist(x - 1, y + 2, l_r, l_c)));
                }
            }
            if (x + 1 <= r) {
                if (y - 2 > 0 && !explored[x + 1][y - 2]) {
                    ret.add(new Point(x + 1, y - 2, g + 3, dist(x + 1, y - 2, l_r, l_c)));
                }
                if (y + 2 <= c && !explored[x + 1][y + 2]) {
                    ret.add(new Point(x + 1, y + 2, g + 3, dist(x + 1, y + 2, l_r, l_c)));
                }
            }
            if (x + 2 <= r) {
                if (y - 1 > 0 && !explored[x + 2][y - 1]) {
                    ret.add(new Point(x + 2, y - 1, g + 3, dist(x + 2, y - 1, l_r, l_c)));
                }
                if (y + 1 <= c && !explored[x + 2][y + 1]) {
                    ret.add(new Point(x + 2, y + 1, g + 3, dist(x + 2, y + 1, l_r, l_c)));
                }
            }
            return ret;
        }

        @Override
        public int compareTo(Point o) {
            return g + h - o.g - o.h;
        }
    }
}
