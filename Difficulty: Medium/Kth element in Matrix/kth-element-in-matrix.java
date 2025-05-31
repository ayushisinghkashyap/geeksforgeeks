class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                q.add(matrix[i][j]);
            }
        }
        int res = 0;
        for(int i=0;i<k;i++){
            res = q.remove();
        }
        return res;
    }
}