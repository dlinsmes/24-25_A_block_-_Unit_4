public class InsertionSort {

    public static void main(String [] args) {
        int [] nums = {5, 2, 1, 4, 3, 8, 6};

        insertionSort(nums);

        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i]);
        System.out.println();

        String s = "dinosaur";
        int i = 9;
        double d = 1000.7;
        boolean b = false;

        doSomething(s, i, d, b);

        System.out.println(s + " " + i + " " + d + " " + b);
        //these are the same values as before the method call
        //these data types (int, double, boolean, String) don't get
        //changed by methods (primitive data types)


        //passing arrays as arguments to a method call will allow
        //the method to change the array
        doSomethingElse(nums);

        for (int j = 0; j < nums.length; j++)
            System.out.print(nums[j]);
        System.out.println();

    }

    public static void doSomething(String s, int i, double d, boolean b) {
        s = "blahhhhh";
        i = -1;
        d = -.99999999;
        b = true;
        //for these data types, any changes made to the param values are not
        //seen outside of this method
        System.out.println("inside doSomething(): " + s + " " + i + " " + d + " " + b);

    }

    public static void doSomethingElse( int [] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = -1;
    }


    //**probably** what you do with cards in your hand:
    //moving from left to right, take the next value
    //and put it into sorted position to the left;
    //if needed, move higher values up by one position
    public static void insertionSort(int [] numbers) {

        for (int i = 0; i < numbers.length; i++) {

            int current = numbers[i];

            //look to the left of i (which is sorted) to see
            //where current should be placed

            int j = i - 1;

            while (j >= 0 && numbers[j] > current) {
                numbers[j+1] = numbers [j];
                j--;
            }

            numbers[j+1] = current;


            //print after each iteration of the loop to see progress
            for (int num: numbers)
                System.out.print(num);
            System.out.println();
        }


    }
}
