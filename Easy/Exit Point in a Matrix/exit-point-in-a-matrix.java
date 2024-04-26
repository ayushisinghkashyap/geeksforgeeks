//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int[] dx = {+1, 0, -1, 0};
        int[] dy = {0, -1, 0, +1};
        
        int i = 0, j = 0, idx = -1;
        boolean flag = true;
        while(i >= 0 && j >= 0 && i < n && j < m) {
            if(matrix[i][j] == 0 && flag) {
                j++;
            } else if(matrix[i][j] == 0) {
                i = i + dx[idx];
                j = j + dy[idx];
            } else {
                matrix[i][j] = 0;
                flag = false;
                idx = (idx + 1) % 4;
                i = i + dx[idx];
                j = j + dy[idx];
            }
        }
        if(i < 0) i++;
        if(i >= n) i--;
        if(j < 0) j++;
        if(j >= m) j--;
        
        return new int[] {i, j};
    }
    
}