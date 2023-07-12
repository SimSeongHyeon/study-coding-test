import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[5];
        int[] correct = {1, 2, 3, 4, 5};

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        while (nums[0] != 1 || nums[1] != 2 || nums [2] != 3 || nums[3] != 4 || nums[4] != 5) {
            int temp = 0;

            if (nums[0] > nums[1]) {
               temp = nums[1];
               nums[1] = nums[0];
               nums[0] = temp;

               StringBuilder sb = new StringBuilder();

                for (int num : nums) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }

            if (nums[1] > nums[2]) {
                temp = nums[2];
                nums[2] = nums[1];
                nums[1] = temp;

                StringBuilder sb = new StringBuilder();

                for (int num : nums) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }

            if (nums[2] > nums[3]) {
                temp = nums[3];
                nums[3] = nums[2];
                nums[2] = temp;

                StringBuilder sb = new StringBuilder();

                for (int num : nums) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }

            if (nums[3] > nums[4]){
                temp = nums[4];
                nums[4] = nums[3];
                nums[3] = temp;

                StringBuilder sb = new StringBuilder();

                for (int num : nums) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }
        }
    }
}