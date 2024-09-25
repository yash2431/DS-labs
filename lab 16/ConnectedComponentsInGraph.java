import java.util.*;

public class ConnectedComponentsInGraph {

    // Function to perform DFS and mark visited nodes
    static void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true; // Mark the current node as visited
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited); // Recur for unvisited neighbors
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Number of test cases
        int T = scanner.nextInt();

        // Loop through each test case
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of nodes
            int[] W = new int[N]; // Weights of nodes
            
            // Reading the weights of nodes
            for (int i = 0; i < N; i++) {
                W[i] = scanner.nextInt();
            }

            // HashMap to group nodes by the value of W[i] - i
            HashMap<Integer, List<Integer>> groupMap = new HashMap<>();
            
            for (int i = 0; i < N; i++) {
                int key = W[i] - i; // Calculate W[i] - i
                groupMap.putIfAbsent(key, new ArrayList<>());
                groupMap.get(key).add(i); // Group the nodes based on W[i] - i
            }

            // Create adjacency list for the graph
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }

            // Create edges between nodes in the same group
            for (List<Integer> group : groupMap.values()) {
                for (int i = 0; i < group.size(); i++) {
                    for (int j = i + 1; j < group.size(); j++) {
                        adjList.get(group.get(i)).add(group.get(j));
                        adjList.get(group.get(j)).add(group.get(i));
                    }
                }
            }

            // DFS to find the number of connected components
            boolean[] visited = new boolean[N];
            int connectedComponents = 0;

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    dfs(i, adjList, visited);
                    connectedComponents++; // Increment the number of components
                }
            }

            // Output the number of connected components for the current test case
            System.out.println(connectedComponents);
        }

        scanner.close();
    }
}
