package main.java.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalPath {
    // Key points:
    // A path or point which when removed divides graph into two part is its critical path.
    ArrayList<Integer>[] graph;
    List<List<Integer>> criticalPaths;
    int[] visitedTimes;
    int[] lowTimes;
    int time;

    /**
     * <H1>CriticalPath using modified DFS</H1>
     * <H2>Time Complexity: TBC</H2>
     * <H2>Space Complexity: TBC</H2>
     * @param length - of connections
     * @param connections - list containing a list of int
     * @return list containing a list of critical path
     */
    public List<List<Integer>> findCriticalPath(int length, List<List<Integer>> connections){
        graph = new ArrayList[length];
        criticalPaths = new ArrayList<>();
        visitedTimes = new int[length];
        lowTimes = new int[length];
        time = 0;

        // create adjacency list for graph
        renderGraph(connections);
        boolean[] visited = new boolean[length];
        // stating at node 0, -1 for parent
        dfs(visited, 0,-1 );
        return criticalPaths;
    }
    // dfs approach
    private void dfs(boolean[] visited, int currNode, int parentNode){
        visited[currNode] = true;
        visitedTimes[currNode] = lowTimes[currNode] = time++;

        for(int neighbor: graph[currNode]){
            if (neighbor == parentNode) continue;
            if (!visited[neighbor]){
                dfs(visited, neighbor, currNode);
                lowTimes[currNode] = Math.min(lowTimes[currNode], lowTimes[neighbor]);
                if (visitedTimes[currNode]< lowTimes[neighbor]){
                    criticalPaths.add(Arrays.asList(currNode, neighbor));
                }
            } else {
                lowTimes[currNode] = Math.min(lowTimes[currNode], visitedTimes[neighbor]);
            }
        }
    }
    // create adjacency list for graph
    private void renderGraph(List<List<Integer>> connections){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections){
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}
