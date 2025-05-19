//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    private static void findParents(Node root, Map<Node, Node> map) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    private static Node findNode(Node root, int start) {
        if (root == null) return null;
        if (root.data == start) return root;
        Node left = findNode(root.left, start);
        if (left != null) return left;
        return findNode(root.right, start);
    }

    public static int minTime(Node root, int start) {
        Map<Node, Node> parentMap = new HashMap<>();
        findParents(root, parentMap);
        
        Node startNode = findNode(root, start);
        if (startNode == null) return 0;

        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        visited.add(startNode);

        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && visited.add(curr.left)) {
                    q.offer(curr.left);
                }

                if (curr.right != null && visited.add(curr.right)) {
                    q.offer(curr.right);
                }

                Node parent = parentMap.get(curr);
                if (parent != null && visited.add(parent)) {
                    q.offer(parent);
                }
            }
        }

        return time;
    }
}