import javax.management.BadAttributeValueExpException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
Создать класс «Дата» и класс - «Записная книжка», включающий ФИО, телефон, дату рождения и функцию вычисления количества
дней до дня рождения.
 */


/***
 * A class that describes the book and contains the following fields <b>day</b>, <b>month</b>, <b>year</b> and const <b>DATE_FORMAT</b>
 * @author Vasiliy Pavliuk
 * @version 1.0
 */
public class Date implements IDate{
    /**A constant that stores the date format*/
    private String DATE_FORMAT = "dd/MM/yyyy";
    /**Field for storing the day of the month*/
    private int day;
    /**Field for storing the month of the year*/
    private int month;
    /**Year storage field*/
    private int year;
    /**A function that checks the correctness of the date
     * @return true or false
     * */
    @Override
    public boolean isValidDate(String date) throws ParseException {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**Constructor with certain values - create a new object
     * @param day - day of the month
     * @param month - month of the year
     * @param year - year
     * */
    public Date(int day, int month, int year) throws BadAttributeValueExpException {
        try{
            if(!isValidDate(day + "/" + month + "/" + year) || year < 1899 || year > 2021){
                throw new BadAttributeValueExpException("Wrong date format");
            }
            this.day = day;
            this.month = month;
            this.year = year;
        }catch (ParseException ex){
            System.out.println(ex);
        }
    }
    /**Function to set the value of the field {@link Date#day}
     * {@link Date#month}
     * {@link Date#year}
     * @param day - day of the month
     * @param month - month of the year
     * @param year - year
     * */
    @Override
    public void set_date(int day, int month, int year) throws BadAttributeValueExpException{
        try{
            if(!isValidDate(day + "/" + month + "/" + year) || year < 1899 || year > 2021){
                throw new BadAttributeValueExpException("Wrong date format");
            }
            this.day = day;
            this.month = month;
            this.year = year;
        }catch (ParseException ex){
            System.out.println(ex);
        }
    }
    /**Function to obtain the value of the field {@link Date#day}
     * @return day of the month
     * */
    @Override
    public int getDay(){
        return this.day;
    }
    /**Function to obtain the value of the field {@link Date#month}
     * @return month of the year
     * */
    @Override
    public int getMonth(){
        return this.month;
    }
    /**Function to obtain the value of the field {@link Date#year}
     * @return year
     * */
    @Override
    public int getYear(){
        return this.year;
    }
    /** A function that returns full date
     * @return a string
     * */
    @Override
    public String toString(){
        return this.day + "/" + this.month + "/" + this.year;
    }
    /** A function that equalizes two dates
     * @return true or false
     * */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Date))
            return false;
        Date d = (Date) o;
        if(d.toString() == this.toString())
            return true;
        return false;
    }
    /** A function that return hash code of object
     * @return number
     * */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }
}