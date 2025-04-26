//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int ele=-1,count=0;
        for(int a:arr){
            if(count>0 && ele!=a) count--;
            else if(ele!=a){
                ele=a;
                count=1;
            }
            else count++;
        }
        count=0;
        for(int a:arr)count+=(ele==a)?1:0;
        return (count>arr.length/2)?ele:-1;
    }
}