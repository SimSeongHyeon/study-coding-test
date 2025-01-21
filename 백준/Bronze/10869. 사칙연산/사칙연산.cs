using System;

class Program {
    
    static void Main(string[] args) {
        string[] numbers = Console.ReadLine().Split(" ");
        
        int A = int.Parse(numbers[0]);
        int B = int.Parse(numbers[1]);
        
        Console.WriteLine(A + B);
        Console.WriteLine(A - B);
        Console.WriteLine(A * B);
        Console.WriteLine(A / B);
        Console.WriteLine(A % B);
    }
}