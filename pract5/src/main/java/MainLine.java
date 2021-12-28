import java.util.Scanner;


/** A class that represents a line in space. Contains fields <b>start_x</b>, <b>start_y</b>, <b>finish_x</b>, <b>finish_y</b>
 * @author Vasiliy Pavliuk
 * @version 1.0
 * */

public class MainLine {
    public static void main(String[] args) {
        Line l = new Line(0, 0, 0, 0);
        boolean isContinue = true;
        int i;
        Scanner in = new Scanner(System.in);
        while (isContinue){
            System.out.println("1 - length | 2 - change coordinates | 3- coordinates && length | 4 - exit");
            i = in.nextInt();
            switch (i){
                case 1:
                    System.out.println(l.get_len());
                    break;
                case 2:
                    int x1, y1, x2, y2;
                    System.out.print("X1: ");
                    x1 = in.nextInt();
                    System.out.print("Y1: ");
                    y1 = in.nextInt();
                    System.out.print("X2: ");
                    x2 = in.nextInt();
                    System.out.print("Y2: ");
                    y2 = in.nextInt();
                    l.set_start_x(x1); l.set_start_y(y1); l.set_finish_x(x2); l.set_finish_y(y2);
                    break;
                case 3:
                    System.out.println(l.toString());
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
