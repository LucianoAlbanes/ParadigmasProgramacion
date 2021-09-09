package CAP6;
/*
(Variable-Length Argument List) Write an application that calculates the average of a series
of integers that are passed to method average using a variable-length argument list. Test your meth-
od with several calls, each with a different number of arguments.
*/

public class E14_AverageValue {
    public static void main(String[] args) {
        System.out.println(average(1,2,3,4,5));
        System.out.println(average(1,2,3));
        System.out.println(average(1));
        System.out.println(average());
    }
    public static double average(double... args) {
        double total = 0;
        for (double value:args) {
            total += value;
        }
        return total / args.length;
    }
}
