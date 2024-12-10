import java.util.Arrays;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int graph[][], int start) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            // Tìm đỉnh chưa được thăm có khoảng cách ngắn nhất
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            // Nếu không tìm thấy đỉnh nào chưa thăm, thoát vòng lặp
            if (dist[u] == INF) {
                break;
            }

            visited[u] = true;

            // Cập nhật khoảng cách cho các đỉnh kề
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // In ra kết quả
        System.out.println("Shortest paths from node " + start + ":");
        for (int i = 0; i < n; i++) {
            String result = (dist[i] == INF) ? "INF" : String.valueOf(dist[i]);
            System.out.println("To node " + i + ": " + result);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 0, 0, 0, 0},
                {10, 0, 5, 0, 0, 0},
                {0, 5, 0, 20, 1, 0},
                {0, 0, 20, 0, 0, 1},
                {0, 0, 1, 0, 0, 10},
                {0, 0, 0, 1, 10, 0}
        };
        dijkstra(graph, 0); // Bắt đầu từ node 0 (Lớp học A)
    }
}