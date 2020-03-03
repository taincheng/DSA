package luogu_project.pj.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
马走日
 */
public class p_1443 {
    static int N, M;
    static Queue<int[]> queue;
    static int[][] house_work = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    static int[][] house_worked;
    static boolean[][] is_work;

    public static void bfs(int x, int y) {
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] ab = queue.poll();
            int a = ab[0];
            int b = ab[1];
            for (int i = 0; i < 8; i++) {
                int newX = a + house_work[i][0];
                int newY = b + house_work[i][1];
                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {//越界判断
                    if (!is_work[newX][newY]) {//处理走过的路
                        queue.offer(new int[]{newX, newY});
                        house_worked[newX][newY] = house_worked[a][b] + 1;
                        is_work[newX][newY] = true;
                    }
                }

            }

        }
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            N = Integer.parseInt(s.split(" ")[0]);
            M = Integer.parseInt(s.split(" ")[1]);
            int X = Integer.parseInt(s.split(" ")[2]) - 1;
            int Y = Integer.parseInt(s.split(" ")[3]) - 1;

            is_work = new boolean[N][M];
            house_worked = new int[N][M];
            queue = new LinkedList<>();
            is_work[X][Y] = true;
            house_worked[X][Y] = 0;

            bfs(X, Y);
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < M; k++) {
                    if ((i != X || k != Y) && house_worked[i][k] == 0) {
                        System.out.printf("%-5d", -1);
                    } else {
                        System.out.printf("%-5d", house_worked[i][k]);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
