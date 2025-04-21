//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().missingNum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    int missingNum(int arr[]) {
        // code here
       long sum=0,max=0;
       for(long i : arr){
           if(i>max) max=i;
           sum+=i;
       }
       if(sum==max*(max+1)/2) return (int)max+1;
       return (int)(max*(max+1)/2 - sum);
    }
}