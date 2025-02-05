import java.util.*;

public class Problem1857D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            ArrayList<Integer> answer = new ArrayList<>();
            ArrayList<Integer> peaks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                answer.add(a[i] - b[i]);
            }
            int max = answer.stream().max(Integer::compareTo).get();

            for (int i = 0; i < n; i++) {
                if (answer.get(i) == max){
                    peaks.add(i+1);
                }
            }

            System.out.print(peaks.size()+"\n");
            for (int i = 0; i < peaks.size(); i++) {
                System.out.print(peaks.get(i)+" ");
            }
            System.out.println();
        }


    }
}
