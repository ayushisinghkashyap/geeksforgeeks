//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isAdditiveSequence(String n) {
        // code here
         int size = n.length();
        
        for (int j = 0; j < Math.min(10, size - 2); j++) {
            long prev1 = Long.parseLong(n.substring(0, j + 1));
            
            for (int k = j + 1; k < Math.min(10, size - 1); k++) {
                long prev2 = Long.parseLong(n.substring(j + 1, k + 1));
                
                int f = 0;
                for (int i = k + 1; i < size;) {
                    long sum = prev1 + prev2;
                    int sumSize = String.valueOf(sum).length();
                    if (i + sumSize - 1 >= size) {
                        f = 1;
                        break;
                    }
                    long num = Long.parseLong(n.substring(i, i + sumSize));
                    if (num != sum) {
                        f = 1;
                        break;
                    }
                    prev1 = prev2;
                    prev2 = num;
                    i += sumSize;
                }
                
                if (f == 0) return true;
            }
        }
        
        return false;
    }
}
