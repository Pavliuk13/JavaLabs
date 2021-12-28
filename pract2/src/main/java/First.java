/*Сформировать массив b из    исходного одномерного массива a
по следующему алгоритму: сначала идут элементы массива a с четными значениями
в порядке их возрастания, затем элементы    с нечетными значениями в порядке их убывания. Д
ля определения количества четных элементов используйте оператор взятия модуля “%”.*/


import java.util.ArrayList;
import java.util.Collections;

public class First {
    public int[] CreateArray(int[] array){
        if(array.length == 0)
            return null;
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        for(int i : array)
            if(i % 2 == 0)
                even.add(i);
            else
                odd.add(i);
        Collections.sort(even);
        Collections.sort(odd);
        Collections.reverse(odd);
        even.addAll(odd);
        int[] resultArray = even.stream().mapToInt(i -> i).toArray();
        return  resultArray;
    }
}
