//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    boolean[] visited;
    int nodesCount;
    int neighborsCount;
    HashMap<Integer, Integer> map;
    
    public void solve(int node, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        ArrayList<Integer> neighbors = adj.get(node);
        neighborsCount = neighbors.size();
        map.put(node, neighborsCount);
        nodesCount++;
        
        for(Integer neighbor : neighbors){
            if(!visited[neighbor]){
                solve(neighbor, adj);
            }
        }
    }
    
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        Solution sol = new Solution();
        sol.visited = new boolean[v+1];
        sol.nodesCount = 0;
        sol.neighborsCount = 0;
        sol.map = new HashMap<>();
        int res = 0;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=v; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int u = edges[i][0];
            int v1 = edges[i][1];
            adj.get(u).add(v1);
            adj.get(v1).add(u);
        }
        
        for(int i=1; i<=v; i++){
            if(!sol.visited[i]){
                sol.nodesCount = 0;
                sol.neighborsCount = 0;
                sol.map.clear();
                sol.solve(i, adj);
                
                int flag = 0;
                for(Integer count : sol.map.values()){
                    if(count != sol.nodesCount - 1){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0)
                    res++;
            }
        }
        
        return res;
    }
}
