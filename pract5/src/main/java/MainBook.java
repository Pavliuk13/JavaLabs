import java.util.ArrayList;
import java.util.Scanner;

/*
Создать класс «Дата» и класс - «Записная книжка», включающий ФИО, телефон, дату рождения и функцию вычисления количества
дней до дня рождения.
 */


public class MainBook {
    public static void main(String[] args) {
        try {
            ArrayList<Book> list = new ArrayList<>();
            Book il1 = new Book("Stepanenko Taras Myk", "380639746909", 8, 8, 1989);
            Book il2 = new Book("Mudryk Mykailo Pet", "380639746009", 5, 1, 2001);
            list.add(il1); list.add(il2);

            boolean isContinue = true;
            int i;
            Scanner in = new Scanner(System.in);
            while (isContinue){
                System.out.println("1 - show list | 2 - add person | 3 - days to birthday | 4 - exit");
                i = in.nextInt();
                switch (i){
                    case 1:
                        for (Book item : list){
                            System.out.println(item.toString());
                        }
                        break;
                    case 2:
                        list.add(new Book());
                        break;
                    case 3:
                        int d, m, y;
                        System.out.print("Enter a day: ");
                        d = in.nextInt();
                        System.out.print("Enter a month: ");
                        m = in.nextInt();
                        System.out.print("Enter a year: ");
                        y = in.nextInt();
                        for (Book item : list){
                            System.out.print(item.getFull_name() + ": ");
                            System.out.println(item.getDaysToBirthday(d, m, y));
                        }
                        break;
                    case 4:
                        isContinue = false;
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
