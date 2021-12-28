/*
Создайте приложение для просмотра списка студентов и изменения значений элементов списка.
Список (5 элементов) создается в программе и является объектом класса ArrayList. Каждый элемент списка содержит фамилию,
имя и отчество (ФИО) студента (типа String), имя группы (типа String), дату рождения (типа BirthDate) и среднюю оценку за
прошедшую сессию (типа float). Объект класса BirthDate в свою очередь содержит три элемента типа int (год, номер месяца и
день рождения).
 */
import javax.management.BadAttributeValueExpException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        try {
            ArrayList<Student> group = new ArrayList<>();
            group.add(new Student("Ermakov Avakuum Gelasevich", "ti-01", (float) 70.5, new BirthDate(2003, 1, 1)));
            group.add(new Student("Isaev Timur Mikhailovich", "ti-01", (float) 80.5, new BirthDate(2003, 2, 2)));
            group.add(new Student("Panfilov Miron Vasiliovich", "ti-01", (float) 77.5, new BirthDate(2003, 3, 3)));
            group.add(new Student("Tsvetkov Valerii Glibovuch", "ti-01", (float) 90.5, new BirthDate(2003, 4, 4)));
            group.add(new Student("Grigoriev Askold Iakovich", "ti-01", (float) 50.5, new BirthDate(2003, 5, 5)));

            boolean isContinue = true, isFind = false;
            String name = "";
            Scanner in = new Scanner(System.in);
            int i;
            while (isContinue){
                System.out.println("1 - watch all students | 2 - change full name | 3 - change group | 4 - change rating | 5 - exit");
                i = in.nextInt();
                switch (i){
                    case 1:
                        for (Student s : group)
                            System.out.println(s.str());
                        break;
                    case 2:
                        System.out.print("Enter full name of student: ");
                        in.nextLine();
                        name = in.nextLine();
                        isFind = false;
                        for (int k = 0; k < group.size(); k++)
                            if (group.get(k).getFull_name().equals(name)) {
                                System.out.print("Enter new name for student: ");
                                name = in.nextLine();
                                group.get(k).setFull_name(name);
                                isFind = true;
                                break;
                            }
                        if(!isFind)
                            System.out.println("Student not found");
                        break;
                    case 3:
                        System.out.print("Enter full name of student: ");
                        in.nextLine();
                        name = in.nextLine();
                        isFind = false;
                        for (int k = 0; k < group.size(); k++)
                            if (group.get(k).getFull_name().equals(name)) {
                                System.out.print("Enter new group for student: ");
                                name = in.nextLine();
                                group.get(k).setGroup(name);
                                isFind = true;
                                break;
                            }
                        if(!isFind)
                            System.out.println("Student not found");
                        break;
                    case 4:
                        System.out.print("Enter full name of student: ");
                        in.nextLine();
                        name = in.nextLine();
                        isFind = false;
                        for (int k = 0; k < group.size(); k++)
                            if (group.get(k).getFull_name().equals(name)) {
                                System.out.print("Enter new rating for student: ");
                                float r = in.nextFloat();
                                group.get(k).setRating(r);
                                isFind = true;
                                break;
                            }
                        if(!isFind)
                            System.out.println("Student not found");
                        break;
                    case 5:
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

class Student{
    private String full_name;
    private String group;
    private float rating;
    public BirthDate date;
    public Student(String full_name, String group, float rating, BirthDate date)throws BadAttributeValueExpException {
        if(full_name == "" || full_name.split(" ").length != 3 || !full_name.matches("[A-Za-z ]+") || group == "" || !group.matches("[a-z0-9]{2}-[0-9]{2}") || rating <= 0 || rating > 100){
            throw new BadAttributeValueExpException("Not correct data");
        }
        this.full_name = full_name;
        this.group = group;
        this.rating = rating;
        this.date = date;
    }
    public String getFull_name(){
        return this.full_name;
    }
    public String getGroup(){
        return this.group;
    }
    public float getRating(){
        return this.rating;
    }
    public void setFull_name(String full_name)throws BadAttributeValueExpException{
        if(full_name == "" || full_name.split(" ").length != 3 || !full_name.matches("[A-Za-z ]+")){
            throw new BadAttributeValueExpException("Not correct data");
        }
        this.full_name = full_name;
    }
    public void setRating(float rating) throws BadAttributeValueExpException{
        if(rating <= 0 || rating > 100){
            throw new BadAttributeValueExpException("Not correct data");
        }
        this.rating = rating;
    }
    public void setGroup(String group)throws BadAttributeValueExpException{
        if(group == "" || !group.matches("[a-z0-9]{2}-[0-9]{2}")){
            throw new BadAttributeValueExpException("Not correct data");
        }
        this.group = group;
    }
    public String str(){
        return this.full_name + " " + this.group + " " + this.rating + " " + this.date.str();
    }
}

class BirthDate{
    private int year;
    private int month;
    private int day;
    private String date;
    public BirthDate(int year, int month, int day)throws BadAttributeValueExpException {
        if(year > 2004 || year < 1998 || month > 12 || month <= 0 || day <= 0 || day > 31){
            throw new BadAttributeValueExpException("Wrong data");
        }
        if(!isValidDate(year + "/" + month + "/" + day)){
            throw new BadAttributeValueExpException("Wrong data");
        }
        this.date = year + "/" + month + "/" + day;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public String str(){
        return this.date;
    }
    private boolean isValidDate(String input) {
        String formatString = "yyyy/MM/dd";

        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}