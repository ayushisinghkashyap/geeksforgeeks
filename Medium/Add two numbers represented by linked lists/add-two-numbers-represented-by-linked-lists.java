//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverseList(Node head)
    {
        // code here
        if((head == null) || (head.next == null))
        return head ;
        // return head of reversed list
        Node curr = head , prev = null ;
        
        while(curr != null )
        {
             Node next  = curr.next  ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        
        return prev ;
        
    }
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        first = reverseList(first)   ;
        second = reverseList(second) ;
        Node ans = new Node(0) ;
        Node p = first ;
        Node q = second ;
        Node curr = ans ;
        int carry = 0 ;
        
        while( p!= null || q!= null)
        {
            int x = (p != null) ? p.data : 0 ;
            int y = (q != null) ? q.data : 0 ;
            
            int sum = carry + x +y ;
            carry = sum/10 ;
            curr.next  = new Node(sum%10) ;
            curr = curr.next ;
            
            if (p != null) p = p.next ;
            if (q != null) q = q.next ;
        }
        
        if(carry>0)
        {
            curr.next = new Node(carry) ;
        }
        
        ans = reverseList(ans.next) ;
        
        while( ans.next != null && ans.data == 0 ) ans = ans.next ;
        
        
        return ans ;
    }
}