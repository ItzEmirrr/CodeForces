import java.util.*;

public class Problem982C {
    static List<Integer>[] tree;
    static int[] subtreeSize;
    static int removableEdges = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n % 2 == 1) {
            System.out.println(-1);
            return;
        }

        tree = new ArrayList[n + 1];
        subtreeSize = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1, -1);

        System.out.println(removableEdges);
    }

    private static int dfs(int node, int parent) {
        subtreeSize[node] = 1;

        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                subtreeSize[node] += dfs(neighbor, node);
            }
        }

        if (subtreeSize[node] % 2 == 0 && parent != -1) {
            removableEdges++;
        }

        return subtreeSize[node];
    }
}
