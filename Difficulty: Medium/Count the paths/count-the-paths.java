class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        
        Integer[] memo = new Integer[V];
        
        return dfs(graph, src, dest, memo);
    }
    
    private int dfs(List<List<Integer>> graph, int node, int dest, Integer[] memo){
        if(node == dest) return 1;
        
        if(memo[node] != null) return memo[node];
        
        int totalPaths = 0;
        
        for(int neighbor : graph.get(node)){
            totalPaths += dfs(graph, neighbor, dest, memo);
        }
        
        memo[node] = totalPaths;
        
        return totalPaths;
    }
}