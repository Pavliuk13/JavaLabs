/*Проверьте, являются ли элементы массива a множеством
(для этого среди элементов массива не должно быть двух элементов с одинаковым значением).
 */

import java.util.TreeSet;

public class Second {
    public boolean checkArray(int[] array){
        if(array.length == 0)
            return false;
        for(int i = 0; i < array.length; i++){
            int a = array[i];
            for(int j = 0; j < array.length; j++){
                if(j == i)
                    continue;
                if(array[j] == a)
                    return false;
            }
        }
        return true;
    }
}
