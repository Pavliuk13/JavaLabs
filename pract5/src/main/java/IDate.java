import javax.management.BadAttributeValueExpException;
import java.text.ParseException;

public interface IDate {
    boolean isValidDate(String date) throws ParseException;
    void set_date(int day, int month, int year) throws BadAttributeValueExpException;
    int getDay();
    int getMonth();
    int getYear();
}