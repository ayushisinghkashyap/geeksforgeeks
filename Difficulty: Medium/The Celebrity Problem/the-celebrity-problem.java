//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length, j = 0;
      // j= 0 , means assuming first person as celebrity
        for(int i=0;i<n;i++){
      // if j knows i , means that i might be the celebrity 
            if(knows(mat, j , i)) j = i;
        }
       // j is celebrity only if j does not know i or every other person know j
        for(int i=0;i<n;i++){
            if(j != i && (knows(mat, j, i) || !knows(mat, i, j))) return -1;
        }
        return j;
    }
   // to check whether a knows b or not
    private boolean knows(int[][] m, int a, int b){
        return m[a][b] == 1;
    }
}