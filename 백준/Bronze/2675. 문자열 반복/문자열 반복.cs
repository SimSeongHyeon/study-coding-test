using System;
using System.Text;
using static System.Console;

class Program {

    static string MakeP(int R, string S) {
        StringBuilder result = new StringBuilder();

        foreach(char c in S) {
            result.Append(c, R);
        }

        return result.ToString();
    }

    static void Main(string[] args) {
        int T = int.Parse(ReadLine());

        for (int testCase = 0; testCase < T; testCase++) {
            string[] input = ReadLine().Split(" ");
            int R = int.Parse(input[0]);
            string S = input[1];

            WriteLine(MakeP(R, S));
        }
    }
}
