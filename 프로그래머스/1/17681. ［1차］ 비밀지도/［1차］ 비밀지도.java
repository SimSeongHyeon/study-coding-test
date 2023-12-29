class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] binaryArr1 = new String[n];
        String[] binaryArr2 = new String[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = "";
            binaryArr1[i] = "";
            binaryArr2[i] = "";
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - Integer.toBinaryString(arr1[i]).length(); j++) {
                binaryArr1[i] += "0";
            }
            binaryArr1[i] += Integer.toBinaryString(arr1[i]);
            
            for (int j = 0; j < n - Integer.toBinaryString(arr2[i]).length(); j++) {
                binaryArr2[i] += "0";
            }
            binaryArr2[i] += Integer.toBinaryString(arr2[i]);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (binaryArr1[i].charAt(j) == '1' || binaryArr2[i].charAt(j) == '1') {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }
        
        return answer;
    }
}