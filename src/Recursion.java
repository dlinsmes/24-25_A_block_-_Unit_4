public class Recursion {

    public static void main(String [] args) {
        System.out.println("2^ 5 is " + exponent(2, 5));

        System.out.println("2^ 5 is " + expRecursive(2, 5));

        sayHi();

        countDownFrom(5);
        System.out.println();

        countUpTo(10);

        System.out.println();

        // 1 1 2 3 5 8 13 21 34
        for (int i = 1; i < 10; i++) {
            System.out.print( fib(i)  + " ");
        }

        System.out.println();

        for (int i = 1; i < 10; i++) {
            System.out.print( fibLoop(i)  + " ");
        }


        System.out.println();
        System.out.println("60 fib numbers:");
        for (int i = 1; i < 60; i++) {
            System.out.print( fib(i)  + " ");
        }
        System.out.println();
        System.out.println("done");

        //recursive code might be shorter in length, but the number of
        //recursive method calls can make execution time a lot longer

        //fib(50) needs fib(49) and fib(48)
        //fib(49) needs fib(48) and fib(47), but then the prev lines needs a separate call to fib(48)
    }

    //warm up
    //write a method, exponent(int base, int pow), that
    //calculates the exponent of base raised to pow and
    //returns that value
    public static int exponent(int base, int pow) {
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= base;
        }
        return result;
    }

    public static void sayHi() {
        System.out.println("hi");
        //sayHi();
    }

    //recursion - when a method calls itself


    //2^5 = 2 * 2 * 2 * 2 * 2
    //    = 2 * 2^4
    //2^4 = 2 * 2^3
    //2^3 = 2 * 2^2
    //2^2 = 2 * 2^1
    //2^1 = 2 * 2^0
    //2^0 = 1

    //in recursion - need a base case - the simplest form
    //of the problem where the solution is obvious
    //with exponents, the base case is when the power is 0
    //bc the solution to anything raised to the 0th is 1

    public static int expRecursive(int b, int p) {
        //the method will keep calling itself with a lower value for p
        //until p is 0

        //base case - power is 0
        if (p == 0) {
            return 1;
        }

        //recursive case - where the method calls itself
        else {
            //ex: when the orig params are 3 and 2
            //the else case runs and returns 3 * (3^1)
            //then 3^1 returns 3 * 3^0
            //then 3^0 is the base case (if part) and returns 1
            return b * expRecursive(b, p-1);
        }
    }

    //any method that can be written recursively can also be written
    //with a loop
    //-on tests, recursion will only be on MC. FRQs can be written however
    //you'd like

    //countDownFrom(5) - prints 5 4 3 2 1
    public static void countDownFrom(int n) {
        //base case - n is 1, print 1
        if (n == 1){
            System.out.print(1 + " ");
        }
        else {
            //when n is any number besides 1,
            //print that number first, then call the method again with
            //the next smallest number

            System.out.print(n + " ");
            countDownFrom(n-1);
        }
    }

    //countUpto(5) - print 1 2 3 4 5
    public static void countUpTo(int n) {
        if (n == 1)
            System.out.print(1 + " ");
        else {
            countUpTo(n-1);

            //the recursive call needs to finish before the
            //original n value is printed
            //when n is 10, need to call and complete countUpTo(9)
            //before 10 can print

            //-like having code after a loop - can't run the next
            //line until the loop finishes
            System.out.print(n + " ");
        }
    }

    //fibonacci numbers:
    // 1 1 2 3 5 8 13 21
    //the first two numbers in the sequence are 1 and 1
    //after that, each following number is the sum of the previous 2
    //f(1) --> 1 //base case
    //f(2) --> 1 //base case
    //f(3) --> 2
    //       = f(2) + f(1)
    //in general:
    //f(n) --> f(n-2) + f(n-1)

    //return the nth fib number in the sequence
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            //two recursive calls:
            return fib(n-2) + fib(n-1);
        }
    }

    //same thing using loop - no recursion
    public static int fibLoop(int n) {
        int prev2 = 0;
        int prev1 = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            prev2 = prev1;
            prev1 = current;
            current = prev2+prev1;
        }
        return current;
    }



}
