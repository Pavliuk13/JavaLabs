/*
Анализ аргументов, задаваемых при запуске программы. Программа переставляет введенные аргументы в порядке возрастания
их длины. Шаблон аргумента: строка либо цифр, либо латинских букв. Программа выводит количество
заданных аргументов, их значения, а также список значений аргументов в порядке возрастания  их длины.
 */


import java.util.ArrayList;
import java.util.Arrays;

public class Fourth {
    public static void main(String[] args) {
        Analyzing analyzing = new Analyzing(args);
        String[] list = analyzing.check();
        for(String s : list)
            System.out.println(s.length() + " " + s);
    }
}

class Analyzing{
    private String[] array;
    public  Analyzing(String[] array){
        this.array = array;
    }
    public String[] check(){
        String expression = "[A-Za-z0-9]+";

        ArrayList<String> result = new ArrayList<String>();
        for (String s : array){
            if (s.matches(expression))
                result.add(s);
        }
        String[] arr = new String[result.size()];
        arr = result.toArray(arr);
        Arrays.sort(arr, new SortByLength());
        return arr;
    }
}
