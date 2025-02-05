import java.util.ArrayList;
import java.util.Scanner;

class Node707B{
    int distance;
    int destination;
    public Node707B(int x, int y){
        this.distance = x;
        this.destination = y;
    }
}

public class Problem707B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        int[] storage = new int[k];
        for (int i = 0; i < k; i++) {
            storage[i] = sc.nextInt();
        }

        Problem707B obj = new Problem707B();
        obj.solve(n, m, k, arr, storage);
    }
    public void solve(int n, int m, int k, int[][] arr, int[] storage) {
        ArrayList<Node707B>[] graph = new ArrayList[n];
        boolean[] marked = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] input = arr[i];
            int u = input[0];
            int v = input[1];
            int l = input[2];

            graph[u-1].add(new Node707B(l, v-1));
            graph[v-1].add(new Node707B(l, u-1));
        }

        for (int i = 0; i < k; i++) {
            marked[storage[i]-1] = true;
        }

        int minlength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (marked[i]) {
                for (Node707B p : graph[i]) {
                    if (!marked[p.destination]) {
                        minlength = Math.min(minlength, p.distance);
                    }
                }
            }
        }
        if (minlength == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minlength);
        }
    }
}
