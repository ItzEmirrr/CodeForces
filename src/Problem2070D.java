import java.util.*;

public class Main {
    static final int MOD = 998244353;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        while (TC-- > 0) {
            main1(scanner);
        }
        scanner.close();
    }
    
    public static void main1(Scanner scanner) {
        int n = scanner.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] p = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            p[i] = scanner.nextInt();
        }
        
        for (int i = 2; i <= n; i++) {
            adj.get(p[i - 2]).add(i);
        }
        
        int D = 0;
        List<List<Integer>> a = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while (!q.isEmpty()) {
            a.add(new ArrayList<>());
            Queue<Integer> newQ = new LinkedList<>();
            
            for (int u : q) {
                a.get(D).add(u);
                newQ.addAll(adj.get(u));
            }
            q = newQ;
            D++;
        }
        
        int[] F = new int[D + 2];
        int[] f = new int[n + 1];
        
        for (int d = D - 1; d > 0; d--) {
            for (int u : a.get(d)) {
                f[u] = (1 + F[d + 1]) % MOD;
                for (int v : adj.get(u)) {
                    f[u] = (f[u] - f[v] + MOD) % MOD;
                }
                F[d] = (F[d] + f[u]) % MOD;
            }
        }
        F[1] = (F[1] + 1 + MOD) % MOD;
        System.out.println(F[1]);
    }
}
