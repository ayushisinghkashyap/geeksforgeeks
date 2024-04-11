//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        
        // Your code here
         String bin = Integer.toBinaryString(n);
        String gray = ""+bin.charAt(0);
        for(int i=1; i<bin.length(); i++){
            char ch = bin.charAt(i);
            char end = gray.charAt(gray.length()-1);
            if((ch=='0' && end == '1') || (ch == '1' && end == '0'))
                gray += '1';
            else
                gray += '0';
        }
        int ans = Integer.parseInt(gray, 2);
        return ans;
        
    }
       
}



//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends