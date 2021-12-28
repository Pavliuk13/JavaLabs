import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println("FIRST task: ");
        First f = new First();
        int[] inArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] outArray = f.CreateArray(inArray);
        for(int i : outArray)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("SECOND task: ");
        Second s = new Second();
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 5, 5, 6};
        boolean b1 = s.checkArray(arr1);
        boolean b2 = s.checkArray(arr2);
        System.out.println(b1 + " " + b2);
        System.out.println();

        System.out.println("THIRD task: ");
        Third th = new Third();
        int[] a = {9, 19, 29, 39, 49, 59, 69, 109};
        int[] b = {15, 30, 50};
        int[] c = th.showIntervals(a, b);
        System.out.println();

        System.out.println("FOURTH task: ");
        Fourth fh = new Fourth();;
        int cur = fh.dayInTheYear(31, 12, true);
        System.out.println(cur);
        System.out.println();

        System.out.println("FIFTH task: ");
        Fifth fs = new Fifth();
        int[] p = {13, 22, 10, 1, 0, -13, 100, 23};
        int[] q = fs.createArray(90, 2, p);
        for(int i : q)
            System.out.print(i + " ");

    }
}
