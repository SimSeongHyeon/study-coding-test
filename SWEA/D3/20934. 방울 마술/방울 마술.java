import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)	{
            System.out.print("#" + test_case + " ");
            
			char[] cups = new char[3];
			
            StringTokenizer st;
           	
            st = new StringTokenizer(br.readLine());
            
            String cupLocation = st.nextToken();
            
            int K = Integer.parseInt(st.nextToken());
           	
            if (K == 0) {
                System.out.println(cupLocation.indexOf('o'));
             
                continue;
            }
            
            if (K % 2 == 0) {
            	System.out.println(isCenter(cupLocation) ? "1" : "0");
            } else {
                System.out.println(isCenter(cupLocation) ? "0" : "1");
            }
		}
	}
    
    static boolean isCenter (String cupLocation) {
        return cupLocation.indexOf('o') == 1;
    }
}