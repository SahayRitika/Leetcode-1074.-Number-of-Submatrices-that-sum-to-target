class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        for(int i=0; i<matrix[0].length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int preSum=0; 
                 Map<Integer, Integer> map= new HashMap<>();
                map.put(0,1);
                for(int row=0; row<matrix.length; row++){
                preSum+=matrix[row][j] - ((i>0)?matrix[row][i-1]:0);
                count+=map.getOrDefault(preSum-target, 0);
                map.put(preSum, map.getOrDefault(preSum, 0)+1);
                }
            }
        }
        return count;
    }
}
