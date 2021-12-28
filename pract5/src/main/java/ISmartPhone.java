import javax.management.BadAttributeValueExpException;

public interface ISmartPhone {
    double getFrequency();
    int getNumber_of_cores();
    int getAmount_of_ram();
    void setFrequency(double frequency)throws BadAttributeValueExpException;
    void setAmount_of_ram(int amount_of_ram)throws BadAttributeValueExpException;
    void setNumber_of_cores(int number_of_cores)throws BadAttributeValueExpException;
}
