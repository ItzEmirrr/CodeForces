import java.util.ArrayList;
import java.util.Scanner;

public class Problem1344A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] visited = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

                int x = (arr[i] % n + n) % n;
                x = (x+i) % n;

                visited[x]++;
            }

            String answer = "YES";

            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    answer = "NO";
                }
            }

            System.out.println(answer);
        }
    }
}
