class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n=mat1.length;

         int count =0;
         
         HashSet<Integer> set=new HashSet<>();
         
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 set.add(mat2[i][j]);
             }
         }
         
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 int val=mat1[i][j];
                 
                 int ans=x-val;
                 
                 if(set.contains(ans))
                 {
                     count ++;
                 }
             }
         }
         return count;
    }
}