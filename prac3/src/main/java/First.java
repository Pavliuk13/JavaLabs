/*
Создайте программу, которая принимает произвольный текстовую строку, а возвращает другой, в котором символы
располагаются в обратном порядке.
*/
import java.util.Scanner;

public class First{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.nextLine();
        Revers r = new Revers(input);
        System.out.println(r.reverseStr());
    }
}

class Revers{
    private String words;
    public Revers(String words){
        this.words = words;
    }
    public String reverseStr(){
        return new StringBuffer(this.words).reverse().toString();
    }
}
