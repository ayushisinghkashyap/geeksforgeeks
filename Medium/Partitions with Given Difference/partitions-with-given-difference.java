//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static int mod = 1000000007;
    public static int countPartitions(int n, int d, int[] arr) {
        
        Arrays.sort(arr);//For when array also contain 0
        descending(arr);
        int total = 0;
		for(int i=0;i<arr.length;i++) {
			total += arr[i];
		}
		int sum = (d+total);
		if(sum%2==0){//if sum is odd then it is never possible to partition into 2 subset.
		    sum = sum/2;
		}else{
		    return 0;
		}
        
		int dp[][] = new int[arr.length+1][sum+1];
		for(int row[] : dp) {
			Arrays.fill(row,-1);
		}
		
		int ans = solve(arr,dp,sum,arr.length-1);
		return ans;
    }
    private static int solve(int[] arr,int[][] dp,int sum, int pos) {
		
		if(pos<0) {
		    return (sum==0)?1:0;
		}
		if(dp[pos][sum]!=-1) {
			return dp[pos][sum];
		}
		if(arr[pos]>sum) {//exclude
			dp[pos][sum] = solve(arr,dp,sum,pos-1);
		}else {
			dp[pos][sum] = (solve(arr,dp,sum-arr[pos],pos-1) 
			                        + 
			                     solve(arr, dp, sum, pos-1))%mod;
									
		}
		return dp[pos][sum]%mod;
	}
	public static void descending(int arr[]){
	    for(int i=0;i<arr.length/2;i++){
	        int temp = arr[i];
	        arr[i] = arr[arr.length-i-1];
	        arr[arr.length-i-1] = temp;
	    }
	}
}
        
