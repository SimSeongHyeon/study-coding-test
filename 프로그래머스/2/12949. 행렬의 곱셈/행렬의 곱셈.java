class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] resultMatrix = new int[arr1.length][arr2[0].length];
        
        int length = arr1[0].length;
        
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                
                resultMatrix[i][j] = sum;
            }
        }
        
        return resultMatrix;
    }
}