//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        int array[]= new int[n+1];
        int n1 =0;
        int n2 = 1;
        //array[0]=0;
        //array[1]=1;
        for(int i=0;i<n+1;i++){
            array[i]=n1;
            int n3 = (n1 + n2)%1000000007;
            
            n1=n2;
            n2=n3;
            
        }
        return array[n];
    }
}