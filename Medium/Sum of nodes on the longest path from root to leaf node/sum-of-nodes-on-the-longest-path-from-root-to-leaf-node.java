//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.sumOfLongRootToLeafPath(root);
		    System.out.println(res);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    private int calH(Node root) {

        if (root == null)

            return 0;

        int left = calH(root.left);

        int right = calH(root.right);

        return 1 + Math.max(left, right);

    }

 

    private void solve(Node root, int cnt, List<Integer> arr, int sum, int[] maxi) {

        if (root == null && cnt == 0) {

            maxi[0] = Math.max(maxi[0], sum);

            return;

        }

        if (root == null)

            return;

        arr.add(root.data);

        cnt--;

        sum += root.data;

 

        solve(root.left, cnt, arr, sum, maxi);

        solve(root.right, cnt, arr, sum, maxi);

 

        // Backtrack: Remove the last element when returning from recursion

        arr.remove(arr.size() - 1);

    }

 

    public int sumOfLongRootToLeafPath(Node root) {

        int cnt = calH(root);

        int sum = 0;

        int[] maxi = {Integer.MIN_VALUE};

        List<Integer> arr = new ArrayList<>();

        solve(root, cnt, arr, sum, maxi);

        return maxi[0];
    }
}