import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution
{
    static int emptyIndex;
    static int[] storage;
    static ArrayList<Integer> swapLog;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder;
        
        int T = Integer.parseInt(bufferedReader.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{	
            int K = 0;
 			int N = Integer.parseInt(bufferedReader.readLine());
            
            swapLog = new ArrayList<>();
    		storage = new int[N + 2];     
            stringBuilder = new StringBuilder();   
            
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            
            emptyIndex = N + 1;
            
            for (int i = 1; i < N + 1; i++) {
                storage[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            
            for (int i = 1; i < N + 1; i++) {
                if (storage[i] != i && storage[i] != 0) {
                	swap(i);
                    K++;
                    stringBuilder.append(i).append(" ");
                    
                    int index = findIndex(i);
                    swap(index);
                    K++;
                    stringBuilder.append(index).append(" ");
                } else if (storage[i] != i && storage[i] == 0) {
                	int index = findIndex(i);
                    swap(index);
                    K++;
                    stringBuilder.append(index).append(" ");
                }
                
            }
            
            System.out.println(K);
            System.out.println(stringBuilder.toString().trim());          
		}
	}
    
    static void swap(int index) {
        int temp = storage[index];
        storage[index] = storage[emptyIndex];
        storage[emptyIndex] = temp;
        emptyIndex = index;
    }
    
    static int findIndex(int target) {
        for (int i = 1; i < storage.length; i++) {
            if (target == storage[i]) {
                return i;
            }
        }
        
        return -1;
    }
    
    static void print() {
        for (int a = 0; a < storage.length; a++) {
            System.out.print(storage[a] + " ");
        }                
        System.out.println();
    }
    
}