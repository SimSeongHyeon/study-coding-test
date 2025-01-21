using System;

class Program {
    
    static void Main(string[] args) {
        string[] numbers = Console.ReadLine().Split(" ");
        
        int result = 0;
        
        foreach (string number in numbers) {
            result += int.Parse(number);    
        }
        
        Console.Write(result);
    }
}