//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        // code here
        int ans = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            ans += map.getOrDefault(c, 0);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return ans;
    }
}