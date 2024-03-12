import java.util.ArrayList;

public class Graph {
    private ArrayList<MyList> adjacencyList;
    private int numOfNodes;
    private boolean[] visited;

    public Graph(int numOfNodes) {
        this.numOfNodes = numOfNodes;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i <= numOfNodes; i++) {
            this.adjacencyList.add(new MyList());
        }
        this.visited = new boolean[numOfNodes + 1];
    }

    public void add(int x, int y) {
        if (x > 0 && x <= numOfNodes && y > 0 && y <= numOfNodes) {
            adjacencyList.get(x).add(y);
        }
    }

    public void dfs(int start) {
        visited = new boolean[numOfNodes + 1];
        dfsRecursive(start);
    }

    private void dfsRecursive(int node) {
        visited[node] = true;
        System.out.println(node);

        MyList neighbors = adjacencyList.get(node);
        for (int i = 0; i < neighbors.size(); i++) {
            int neighborNode = (int) neighbors.get(i);
            if (!visited[neighborNode]) {
                dfsRecursive(neighborNode);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numOfNodes; i++) {
            result.append(i).append(": ").append(adjacencyList.get(i).toString()).append("\n");
        }
        return result.toString();
    }
}
