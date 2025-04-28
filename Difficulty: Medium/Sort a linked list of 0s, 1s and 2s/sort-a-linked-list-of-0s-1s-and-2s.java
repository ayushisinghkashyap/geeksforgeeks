//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // code here
        Node dum0 = new Node(0);
        Node dum1 = new Node(0);
        Node dum2 = new Node(0);
        
        Node d0 = dum0;
        Node d1 = dum1;
        Node d2 = dum2;
        
        Node curr = head;
        while(curr != null)
        {
            if(curr.data == 0)
            {
                d0.next = curr;
                d0 = d0.next;
            }
            else if(curr.data == 1)
            {
                d1.next = curr;
                d1 = d1.next;
            }
            else if(curr.data == 2)
            {
                d2.next = curr;
                d2 = d2.next;
            }
            curr = curr.next;
        }
        
    //   connecting 0,1,2 lists
        d0.next = (dum1.next != null) ? dum1.next : dum2.next;
        d1.next = dum2.next;
        d2.next = null;
        
        return dum0.next;
        
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends