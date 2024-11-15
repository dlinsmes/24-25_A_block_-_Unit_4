public class Methods {

    public static void main(String [] args) {

        //write code that will calculate the sum of values
        //between 2 provided numbers:
        //ex: 4 and 8 --> 4 + 5 + 6 + 7 + 8
        int small = 4;
        int big = 8;
        int sum = 0;
        for (int i = small; i<big+1; i++) {
            sum += i;
        }
        System.out.println("sum of numbers between " + small
        + " and " + big + " is " + sum);

        //methods (aka functions) let you define code that can be
        //reused multiple times throughout the program

        //call the method with values for each of the defined
        //parameters (term for values passed is arguments)
        sumBetween(3, 10);
        //this calls the method, but since the return value isn't
        //used or saved, it gets thrown out

        //save the returned value to a variable then print
        //-save as the same data type as the return type of the method
        int s = sumBetween(1, 5);
        System.out.println(s);

        //the var type doesn't match the method return type
//        boolean b = sumBetween(0, 2);

        //can directly print the returned value of the method call
        System.out.println(sumBetween(10, 15));

        //make sure the argument quantity and data types match
        //sumBetween();
        //sumBetween(1, 2, 3);

        //sumBetween("blah", false);

        //can pass variables that have matching data types
        int sm = 4;
        int b = 20;
        System.out.println(sumBetween(sm, b));

        //since sumBetween returns an int, a method call can be used directly as
        //an argument
        System.out.println(sumBetween(  sumBetween(1, 4), 20  ));

        //write a factorial() method that takes one int param and returns an int

        System.out.println("5 factorial is " + factorial(5));

        print("10 factorial is " + factorial(10));

        //not a string
        //print(8);

        //workaround: append int to an empty string
        print(""+8);

        //void methods cannot be passed to print statement or other methods
        //System.out.println(print("something"));


        printFact(4);

        boolean good = isGood();
        print("good? " + good);

        //since isGood() returns a boolean, you can use it
        //directly in an if-statement or while loop
        if( isGood() ) {
            print("Good");
        }
        else{
            print("bad");
        }
    }

    //for now, all methods start with public static
    //int is the return type - the method needs to produce data
    //of this type
    //-void is a valid return type which means the method won't
    //produce any data
    //small and big are parameters - like variables that get used
    //in the method code that can modify the output of the method
    //sumBetween is the method name
    public static int sumBetween(int small, int big) {

        //treat the parameters like variables that already have
        //values

        //the sum variable in this method only exists here and
        //the sum variable in main() is not seen in other methods
        int sum = 0;
        for (int i = small; i<big+1; i++) {
            sum += i;
        }

        //sum is the int value that will be produced by this method
        return sum;

        //without the return statement, there will be a red squiggle for the method
        //bc data of the defined return type has not yet been returned
    }

    public static int factorial(int n) {

        int total = 1;
        for (int i = n; i > 0; i--) {
            total = total * i;
        }

        //mismatch of return value and defined return type
        //return false;

        return total;
    }

    //void means no return
    public static void print(String s) {
        System.out.println(s);
    }

    //if you want data from the method to be used elsewhere in the program,
    //return it - otherwise a method can be void if no data from it needs to be used

    public static void printFact(int f) {

        //can call methods in other methods
        print( factorial(f) + "" );
    }

    //a method call can only return one value
    public static boolean isGood() {
        double r = Math.random();
        if (r < 0.5) {
            //once a return statement is reached, the method stops
            return true;
        }

        //else is not necessary bc when the if condition is satisfied, true is
        //returned and the method will stop there
        return false;
    }
}
