//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        // code here
        boolean dp[]=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if((i>=1 && !dp[i-1]) || (i>=x && !dp[i-x]) || (i>=y && !dp[i-y])) dp[i]=true;
        }
        return dp[n]?1:0;
    }
}
