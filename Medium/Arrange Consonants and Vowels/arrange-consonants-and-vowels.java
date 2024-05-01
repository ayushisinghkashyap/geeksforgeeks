//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        ArrayList<Character> a = new ArrayList<>();
        Node p = head;
        while (p != null) {
            a.add(p.data);
            p = p.next;
        }

        ArrayList<Character> vow = new ArrayList<>();
        ArrayList<Character> con = new ArrayList<>();

        int l = a.size();
        for (int i = 0; i < l; i++) {
            char c = a.get(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vow.add(c);
            } else {
                con.add(c);
            }
        }

        p = head;
        int o = vow.size();
        int temp = 0;
        int gemp = 0;
        while (p != null) {
            if (temp < o) {
                p.data = vow.get(temp++);
            } else {
                p.data = con.get(gemp++);
            }
            p = p.next;
        }
        return head;
    }
}