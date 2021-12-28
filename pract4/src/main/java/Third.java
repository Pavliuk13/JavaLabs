/*
Создайте приложение для просмотра списка элементов и изменения значений элементов списка. Список (5 элементов типа Integer)
создается в программе и является объектом класса ArrayList.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);

        boolean isContinue = true;
        Scanner in = new Scanner(System.in);
        int i, ind, val;
        while (isContinue){
            System.out.println("1 - watch all elements | 2 - change value of element | 3 - add element | 4 - exit");
            i = in.nextInt();
            switch (i){
                case 1:
                    ind = 0;
                    for(int k : list) {
                        System.out.println(ind + ": " + k);
                        ind++;
                    }
                    break;
                case 2:
                    System.out.print("Enter an index of element: ");
                    ind = in.nextInt();
                    if(list.get(ind) != null){
                        System.out.print("Enter new value: ");
                        val = in.nextInt();
                        list.set(ind, val);
                    }else
                        System.out.println("Element with index " + ind + " does not exist");
                    break;
                case 3:
                    System.out.print("Enter a value: ");
                    val = in.nextInt();
                    list.add(val);
                    break;
                case 4:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
