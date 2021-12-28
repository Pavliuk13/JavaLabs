import javax.management.BadAttributeValueExpException;

/*
Создать базовый класс Мобильный телефон (название, вес, диагональ экрана, количество встроенной памяти, наличие камеры).
Производный класс – Смартфон (частота процессора, количество ядер, объем ОП).
 */

/***
 * A class that describes the phone and contains the following fields <b>frequency</b>, <b>number_of_cores</b>, <b>amount_of_rma</b>
 * @author Vasiliy Pavliuk
 * @version 1.0
 */
public class SmartPhone extends Phone implements ISmartPhone{
    /**Field with frequency of phone*/
    private double frequency;
    /**Field with number of cores of phone*/
    private int number_of_cores;
    /**Field with amount of RAM of phone*/
    private int amount_of_ram;
    /**Constructor with certain values - create a new object
     * @param name - full name of phone
     * @param weight - weight of phone
     * @param diagonal - diagonal of screen of phone
     * @param memory - number of memory of phone
     * @param isCamera - information about the presence of a camera in the phone
     * @param frequency - frequency of phone
     * @param number_of_cores - number of cores of phone
     * @param amount_of_ram - amount of RAM of phone
     * */
    public SmartPhone(double frequency, int number_of_cores, int amount_of_ram, String name, double weight, double diagonal, int memory, boolean isCamera) throws  BadAttributeValueExpException{
        super(name, weight, diagonal, memory, isCamera);
        if(frequency <= 0 || number_of_cores <= 0 || amount_of_ram <= 0)
            throw new BadAttributeValueExpException("Wrong data");
        this.frequency = frequency;
        this.number_of_cores = number_of_cores;
        this.amount_of_ram = amount_of_ram;
    }
    /**Function to obtain the value of the field {@link SmartPhone#frequency}
     * @return frequency of phone
     * */
    @Override
    public double getFrequency(){
        return this.frequency;
    }
    /**Function to obtain the value of the field {@link SmartPhone#number_of_cores}
     * @return number of cores of phone
     * */
    @Override
    public int getNumber_of_cores(){
        return this.number_of_cores;
    }
    /**Function to obtain the value of the field {@link SmartPhone#amount_of_ram}
     * @return amount of RAM of phone
     * */
    @Override
    public int getAmount_of_ram(){
        return this.amount_of_ram;
    }
    /**Function to set the value of the field {@link SmartPhone#frequency}
     * @param frequency - frequency of phone
     * */
    @Override
    public void setFrequency(double frequency)throws BadAttributeValueExpException{
        if(frequency <= 0)
            throw new BadAttributeValueExpException("Wrong frequency");
        this.frequency = frequency;
    }
    /**Function to set the value of the field {@link SmartPhone#amount_of_ram}
     * @param amount_of_ram - amount of RAM of phone
     * */
    @Override
    public void setAmount_of_ram(int amount_of_ram)throws BadAttributeValueExpException{
        if(amount_of_ram <= 0)
            throw new BadAttributeValueExpException("Wrong frequency");
        this.amount_of_ram = amount_of_ram;
    }
    /**Function to set the value of the field {@link SmartPhone#number_of_cores}
     * @param number_of_cores - number of cores of phone
     * */
    @Override
    public void setNumber_of_cores(int number_of_cores)throws BadAttributeValueExpException{
        if(number_of_cores <= 0)
            throw new BadAttributeValueExpException("Wrong frequency");
        this.number_of_cores = number_of_cores;
    }
    /** A function that returns an information about phone
     * @return a string
     * */
    @Override
    public String toString(){
        return getName() + " " + "Weight: " + getWeight() + " Diagonal: " + getDiagonal() + " Memory: " + getMemory() + " Camera: " + isCamera() + " Frequency: " + this.frequency + " Number of cores: " + this.number_of_cores + " Amount of RAM: " + this.amount_of_ram;
    }
    /** A function that equalizes two phones
     * @return true or false
     * */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof SmartPhone))
            return false;
        SmartPhone p = (SmartPhone) o;
        if(getName() == p.getName() && getWeight() == p.getWeight() && getDiagonal() == p.getDiagonal() && getMemory() == p.getMemory() && isCamera() == p.isCamera() && this.frequency == p.getFrequency() && this.number_of_cores == p.getNumber_of_cores() && this.amount_of_ram == p.getAmount_of_ram())
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
