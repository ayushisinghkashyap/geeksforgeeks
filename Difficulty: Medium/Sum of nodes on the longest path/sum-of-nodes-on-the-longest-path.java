/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    List<String> list = new ArrayList<>();
    public int sumOfLongRootToLeafPath(Node root) {
        list.clear(); // Important: clear list before use in case reused
        dfs(root, 0, 0);
        int maxDepth = 0;
        int maxSum = 0;
        for (String entry : list) {
            String[] parts = entry.split("=");
            int depth = Integer.parseInt(parts[0]);
            int sum = Integer.parseInt(parts[1]);
            if (depth > maxDepth) {
                maxDepth = depth;
                maxSum = sum;
            } else if (depth == maxDepth && sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
    void dfs(Node node, int depth, int sum) {
        if (node == null) return;
        sum += node.data;
        depth++;
        if (node.left == null && node.right == null) {
            list.add(depth + "=" + sum);
            return;
        }
        dfs(node.left, depth, sum);
        dfs(node.right, depth, sum);
    }
}