using System;
using static System.Console;

class Program {

    static void Main(string[] args) {
        string S = ReadLine();
        char[] word = S.ToCharArray();
        int i = int.Parse(ReadLine());

        Write($"{word[i - 1]}");
    }
}
