
public class OverloadedMethods {

    //string methods
    //-length() - int return - number of chars in the string
    //-equals(String other) - boolean return -
    // whether two strings are the same

    //-substring(int beginning) - String return -
    // return the part of the string starting at index beginning
    //until the end
    //-substring(int beginning, int end) - String return -
    //return the part of the string starting at index beginning,
    //to (exclusive) index end

    //indexOf(String s) - return an int representing the first
    //occurrence of where s appears in the larger string, or -1
    //if s doesn't exist in the larger string

    //compareTo(String b) - return an int indicating whether
    //-b comes sequentially before the other string (positive)
    //-b comes sequentially after the other string (negative)
    //-b is the same as the other string (0)

    public static void main(String [] args) {

        print("index of first n in banana is " + "banana".indexOf("n"));

        //the substring to search for can be multiple letters and the
        //returned value will be the starting position
        print("index of first na in banana is "  + "banana".indexOf("na"));

        //-1 is returned when the substring doesn't exist in the string
        print("index of first c in banana is " + "banana".indexOf("c"));


        //if the first string and second string are already in alphabetical
        //order, you get a negative
        print("apple compared to banana: " + "apple".compareTo("banana") );

        //if the order is reversed, you get positive
        print("banana compared to apple: " +"banana".compareTo("apple"));

        //if the strings are the same, you get 0
        print("apple compared to apple: " +"apple".compareTo("apple"));

        //the magnitude of the value doesn't matter - just look at the
        //positive or negative sign
        print("apple compared to absolute: " + "apple".compareTo("absolute"));

        //not tested: All capital letters come sequentially before all
        //lowercase letters
        print("ZEBRA compared to apple: " + "ZEBRA".compareTo("apple"));

        //compareTo() is used for sorting to decide the sequence of two strings

        //calls the version with 2 int params bc we're passing in two int args
        print("max of 4 and 7 is " + max(4, 7) );

        //calls the version with 3 params bc we're passing 3 args
        print("max of 4, 9, and 2 is " + max (4, 9, 2));

        //data type is accounted for to decide which overloaded method to run
        print("max of 4.3 and 7.9 is " + max(4.3, 7.9) );

        print(9);
    }
    public static void print(String s) {
        System.out.println(s);
    }

    //overloads print() to have an int param instead of a string
    public static void print(int i) {
        //you can call a different overloaded version of the method
        print("" + i);
    }

    //substring() is considered an overloaded method - multiple methods
    //with the same name as long as the signature (set of parameters)
    //is different between each version
    //2 versions: substring(int b) and substring(int b, int e)
    //-the program will decide which one to run based off of how many
    //arguments you pass to the method call

    public static int max(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > a && b > c )
            return b;
        return c;
    }

    //the data type can change to have a valid overloaded method
    public static double max(double a, double b) {
        if (a > b)
            return a;
        return b;
    }

    //has the same method signature (set of params) as the prev
//    public static double max(double c, double d) {
//        if (c > d)
//            return c;
//        return d;
//    }
}
