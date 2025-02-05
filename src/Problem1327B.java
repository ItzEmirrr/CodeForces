import java.util.Scanner;

public class Problem1327B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean[] done = new boolean[n+1];
            int free_princess = 0;

            for (int i = 1; i <= n; i++) {
                int k = sc.nextInt();
                boolean princess_done = false;
                while (k-- > 0){
                    int prince = sc.nextInt();
                    if (princess_done){
                        continue;
                    }
                    if (done[prince]){
                        continue;
                    }

                    done[prince] = true;
                    princess_done = true;
                }
                if (princess_done == false){
                    free_princess = i;
                }
            }
            if (free_princess == 0){
                System.out.println("OPTIMAL");
            }
            else{
                System.out.println("IMPROVE");
                System.out.print(free_princess + " ");
                for (int i = 1; i <= n; i++){
                    if (!done[i]){
                        System.out.print(i);
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }
}

