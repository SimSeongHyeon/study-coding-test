import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception	{
       		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++) {            
            		StringTokenizer st = new StringTokenizer(br.readLine());
            
            		int A = Integer.parseInt(st.nextToken());
            		int B = Integer.parseInt(st.nextToken());
           		int N = Integer.parseInt(st.nextToken());
            
            		int count = 0;
            
            		while (A <= N && B <= N) {
                		count++;
                
            			if (A > B) {
                    			B += A;
                		} else {
                    		A += B;
                		}
            		}
            
            		System.out.println(count);
		}
	}
}
