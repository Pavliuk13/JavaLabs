/*Анализ типов аргументов, задаваемых при запуске программы. Если аргумент имеет вид "имя=значение", то он является
ключевым параметром (тип "Keyed"), если аргумент имеет вид "-значение" или "/значение", то он является опцией (тип "Optional")
 и если имеет вид "значение", то является непосредственным параметром (тип "Immediate"). Шаблон для значения: одна или несколько
 цифр и букв. Программа выводит количество заданных
аргументов и, для каждого аргумента, его тип и значение (для ключевых параметров дополнительно выводится имя параметра). */
import java.util.ArrayList;

public class Third {
    public static void main(String[] args) {
        ArrayList<String> array = Search(args);
        int index = 1;
        for(String s : array){
            System.out.println(index + " " + s);
            index++;
        }
    }
    public static ArrayList<String> Search(String[] str){
        String pattern1 = "(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+=(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+";
        String pattern2 = "[-/](?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+";
        String pattern3 = "(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+";

        ArrayList<String> result = new ArrayList<String>();
        for(String s : str){
            if(s.matches(pattern1)){
                Keyed k = new Keyed(s);
                result.add(k.get_str());
            }else if(s.matches(pattern2)){
                Optional opt = new Optional(s);
                result.add(opt.get_str());
            }else if(s.matches(pattern3)){
                Immediate im = new Immediate(s);
                result.add(im.get_str());
            }
        }
        return result;
    }
}

class Keyed{
    private String key;
    private  String value;
    private String type;
    public Keyed(String str){
        String[] arr = str.split("=");
        key = arr[0];
        value = arr[1];
        type = "Keyed";
    }
    public String get_str(){
        return "Type: " + type + " Key: " + key + " Value: " + value;
    }
}

class Optional{
    private String value;
    private String type;
    public Optional(String str){
        value = str.substring(1);
        type = "Optional";
    }
    public String get_str(){
        return "Type: " + type + " Value: " + value;
    }
}

class Immediate{
    private String value;
    private String type;
    public Immediate(String str){
        value = str;
        type = "Immediate";
    }
    public String get_str(){
        return "Type: " + type + " Value: " + value;
    }
}