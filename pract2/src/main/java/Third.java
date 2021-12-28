/*Выведите на дисплей  распределение значений элементов массива a по интервалам. Границы интервалов задаются в виде массива b, причем нулевой элемент определяет нижнюю границу первого интервала, а элементы с 1-го по n-ый - верхние границы интервалов. В результате работы программы
на дисплей должны быть выведены строки «Интервал nn – xx» и последняя строка «Вне интервалов – xx».
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Third {
    public int[] showIntervals(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> out_of_intervals = new ArrayList<Integer>();
        for(int i = 0; i < b.length - 1; i++){
            System.out.println("Interval " + b[i] + "-" + b[i+1]+ ": ");
            for(int j = 0; j < a.length; j++){
                if(a[j] >= b[i] && a[j] <= b[i + 1]) {
                    System.out.print(a[j] + " ");
                    nums.add(a[j]);
                }
            }
            System.out.println();
        }
        System.out.println("Out of intervals: ");
        for(int i = 0; i < a.length; i++)
            if(!nums.contains(a[i])){
                System.out.print(a[i] + " ");
                out_of_intervals.add(a[i]);
            }
        return out_of_intervals.stream().mapToInt(i -> i).toArray();
    }
}
