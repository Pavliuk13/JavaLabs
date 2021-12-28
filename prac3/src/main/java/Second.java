/*
Создайте программу, которая осуществляет шифрование / расшифровка модифицированным методом Цезаря.
В нем ключом является лозунг, который многократно повторяется до тех пор, чтобы достичь длины открытого текста,
а шифрование / расшифровка заключается в суммировании / вычитании кодов символов открытого текста / криптотексте с
соответствующими кодами символов лозунга.
 */

import java.util.Scanner;

public class Second{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cesar c = new Cesar();
        System.out.print("Enter a text: ");
        String words = in.nextLine();
        System.out.print("Enter a key: ");
        String key = in.nextLine();
        String kode = c.encrypt(words, key);
        System.out.println("Encrypted: " + kode);
        String str = c.decrypt(kode, key);
        System.out.println("Decrypted: " + str);

    }
}


class Cesar {
    public String encrypt(String words, String key){
        String result = "";
        char[] w = words.toCharArray();
        char[] k = key.toCharArray();
        char ch;
        int ind = 0, max = key.length() - 1;
        for(int i = 0; i < words.length(); i++){
            if(w[i] >= 65 && w[i] <= 90){
                ch = Character.toUpperCase(k[ind]);
                int x = ch - 65;
                x = x + (int) w[i] + 1;
                if(x > 90)
                    x -= 26;
                ch = (char) x;
                result += ch;
                ind++;
                if(ind > max)
                    ind = 0;
            }else if(w[i] >= 97 && w[i] <= 122){
                ch = Character.toLowerCase(k[ind]);
                int x = ch - 97;
                x = x + (int) w[i] + 1;
                if(x > 122)
                    x -= 26;
                ch = (char) x;
                result += ch;
                ind++;
                if(ind > max)
                    ind = 0;
            }else
                result += w[i];
        }
        return result;
    }
    public String decrypt(String words, String key){
        String result = "";
        char[] w = words.toCharArray();
        char[] k = key.toCharArray();
        char ch;
        int ind = 0, max = key.length() - 1;
        for(int i = 0; i < words.length(); i++){
            if(w[i] >= 65 && w[i] <= 90){
                ch = Character.toUpperCase(k[ind]);
                int x = ch - 65;
                x = (int) w[i] - x - 1;
                if(x < 65)
                    x += 26;
                ch = (char) x;
                result += ch;
                ind++;
                if(ind > max)
                    ind = 0;
            }else if(w[i] >= 97 && w[i] <= 122){
                ch = Character.toLowerCase(k[ind]);
                int x = ch - 97;
                x = (int) w[i] - x - 1;
                if(x < 97)
                    x += 26;
                ch = (char) x;
                result += ch;
                ind++;
                if(ind > max)
                    ind = 0;
            }else
                result += w[i];
        }
        return result;
    }
}
