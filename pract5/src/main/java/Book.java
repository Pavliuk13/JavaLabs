import javax.management.BadAttributeValueExpException;
import java.text.ParseException;
import java.util.Scanner;

/*
Создать класс «Дата» и класс - «Записная книжка», включающий ФИО, телефон, дату рождения и функцию вычисления количества
дней до дня рождения.
 */

/***
 * A class that describes the book and contains the following fields <b>full_name</b>, <b>phone_number</b>, <b>birthdate</b> and array <b>days</b>
 * @author Vasiliy Pavliuk
 * @version 1.0
 */
public class Book implements IBook{
    /**Field with full name of person*/
    private String full_name;
    /**Field with phone number of person*/
    private String phone_number;
    /**Field with date of birth of person*/
    private Date birthdate;
    /**An array that contains the numeric value of the beginning of the month in the year*/
    private int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 314, 334};
    /**Constructor with certain values - create a new object
     * @param full_name - full name of person
     * @param phone_number - phone number of person
     * @param day - day of birth of person
     * @param month - month of birth of person
     * @param year - year of birth of person
     * @see Book#Book()
     * */
    public Book(String full_name, String phone_number, int day, int month, int year) throws BadAttributeValueExpException {
        if(full_name == "" || full_name.split(" ").length != 3 || !full_name.matches("[A-Za-z ]+") || phone_number == "" || !phone_number.matches("380[0-9]{9}"))
            throw new BadAttributeValueExpException("Wrong data");
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.birthdate = new Date(day, month, year);
    }
    /**
     * Constructor with indeterminate values - create a new object
     * @see Book#Book(String, String, int, int, int)
     * */
    public Book() throws BadAttributeValueExpException{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter full_name: ");
//        in.nextLine();
        String full_name = in.nextLine();
        if(full_name == "" || full_name.split(" ").length != 3 || !full_name.matches("[A-Za-z ]+")){
            throw new BadAttributeValueExpException("Wrong full name");
        }
        System.out.print("Enter phone number: ");
        String phone = in.nextLine();
        if(!phone.matches("380[0-9]{9}")){
            throw new BadAttributeValueExpException("Wrong phone number format");
        }
        System.out.print("Enter a day of birth: ");
        int day = in.nextInt();
        System.out.print("Enter a month of birth: ");
        int month = in.nextInt();
        System.out.print("Enter a year of birth: ");
        int year = in.nextInt();
        this.full_name = full_name;
        this.phone_number = phone;
        this.birthdate = new Date(day, month, year);
    }
    /**Function to obtain the value of the field {@link Book#full_name}
     * @return full name of person
     * */
    @Override
    public String getFull_name(){
        return this.full_name;
    }
    /**Function to obtain the value of the field {@link Book#phone_number}
     * @return phone number of person
     * */
    @Override
    public String getPhone_number(){
        return this.phone_number;
    }
    /**Function to obtain the value of the field {@link Book#birthdate}
     * @return birthday of person
     * */
    @Override
    public String getBirthdate(){
        return this.birthdate.toString();
    }
    /**Function to set the value of the field {@link Book#full_name}
     * @param name - full name of person
     * */
    @Override
    public void setFull_name(String name) throws BadAttributeValueExpException{
        if(name == "" || name.split(" ").length != 3 || !name.matches("[A-Za-z ]+")){
            throw new BadAttributeValueExpException("Wrong full name");
        }
        this.full_name = name;
    }
    /**Function to set the value of the field {@link Book#phone_number}
     * @param phone - phone number of person
     * */
    @Override
    public void setPhone_number(String phone) throws BadAttributeValueExpException{
        if(!phone.matches("380[0-9]{9}")){
            throw new BadAttributeValueExpException("Wrong phone number format");
        }
        this.phone_number = phone;
    }
    /**Function to set the value of the field {@link Book#birthdate}
     * @param day - day of birth of person
     * @param month - month of birth of person
     * @param year - year of birth of person
     * */
    @Override
    public void changeDate(int day, int month, int year){
        try {
            this.birthdate.set_date(day, month, year);
        }catch (BadAttributeValueExpException ex){
            System.out.println("Wrong data");
        }
    }
    /**A function that calculates the number of days before a person's birthday
     * @return number of days
     * */
    @Override
    public int getDaysToBirthday(int day, int month, int year) throws BadAttributeValueExpException{
        try {
            boolean isCorrect = this.birthdate.isValidDate(day + "/" + month + "/" + year);
            if(!isCorrect || year > 2021)
                throw new BadAttributeValueExpException("Wrong data");
            int d1 = this.days[this.birthdate.getMonth() - 1] + this.birthdate.getDay();
            int d2 = this.days[month - 1] + day;
            int result;
            boolean isLeap = false;
            if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
                isLeap = true;
            if(isLeap && month > 2)
                d2++;
            else if(isLeap && this.birthdate.getMonth() > 2)
                d1++;
            if(this.birthdate.getMonth() > month || ((this.birthdate.getMonth() == month && this.birthdate.getDay() > day)))
                result = d1 - d2;
            else if(this.birthdate.getMonth() < month || (this.birthdate.getMonth() == month && this.birthdate.getDay() < day)) {
                result = 365 - (d2 - d1);
                if(isLeap)
                    result++;
            }
            else
                result = 0;
            return result;
        }catch (ParseException ex){
            System.out.println(ex);
        }
        return 0;
    }
    /** A function that returns an information about person
     * @return a string
     * */
    @Override
    public String toString(){
        return this.full_name + " " + this.phone_number + " " + this.birthdate.toString();
    }
    /** A function that equalizes two persons
     * @return true or false
     * */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Book))
            return false;
        Book b = (Book) o;
        if(this.full_name == b.getFull_name() && this.getBirthdate() == b.getBirthdate())
            return true;
        return false;
    }
    /** A function that return hash code of object
     * @return number
     * */
    @Override
    public int hashCode(){
        return this.full_name.hashCode();
    }
}