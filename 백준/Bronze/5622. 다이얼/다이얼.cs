using System;
using System.Text;
using static System.Console;

class Program {

    static int calculateTime(char[] chars) {
        string[] alphabets = {"ABC", "DEF", "GHI", "JKL", "MNO",
                             "PQRS", "TUV", "WXYZ"
                             };

        int time = 0;

        foreach (char c in chars) {
            for (int index = 0; index < alphabets.Length; index++) {
                if (alphabets[index].Contains(c)) {
                    time += index + 3;
                }
            }
        }

        return time;
    }

    static void Main(string[] args) {
        string word = ReadLine();
        char[] chars = word.ToCharArray();

        Write(calculateTime(chars));
    }
}