class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        HashSet<Integer> hs=new HashSet<>();
        int sum=0;
        
        for(int i:arr){
            int sq=(i*i);
            hs.add(sq);
        }
        int i,j;
        for(i=0;i<arr.length;i++){
            for(j=i+1;j<arr.length;j++){
                sum=((arr[i]*arr[i])+(arr[j]*arr[j]));
                if(hs.contains(sum)){
                    return true;
                }
                sum=0;
            }
        }
        return false;
    }
}