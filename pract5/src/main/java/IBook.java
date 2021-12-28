import javax.management.BadAttributeValueExpException;

public interface IBook {
    String getFull_name();
    String getPhone_number();
    String getBirthdate();
    void setFull_name(String name) throws BadAttributeValueExpException;
    void setPhone_number(String phone) throws BadAttributeValueExpException;
    void changeDate(int day, int month, int year);
    int getDaysToBirthday(int day, int month, int year) throws BadAttributeValueExpException;
}