import java.util.Scanner;

public class Problem1526B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean found = false;

            if (n >= 1111) {
                found = true;
            } else {
                for (int j = 0; j <= 10; j++) {
                    if (n >= 111 * j && (n - 111 * j) % 11 == 0) {
                        found = true;
                        break;
                    }
                }
            }

            System.out.println(found ? "YES" : "NO");
        }
        sc.close();
    }
}
