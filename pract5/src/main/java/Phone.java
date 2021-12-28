import javax.management.BadAttributeValueExpException;

/*
Создать базовый класс Мобильный телефон (название, вес, диагональ экрана, количество встроенной памяти, наличие камеры).
Производный класс – Смартфон (частота процессора, количество ядер, объем ОП).
 */

/***
 * A class that describes the phone and contains the following fields <b>name</b>, <b>weight</b>, <b>diagonal</b>,
 * <b>memory</b>, <b>isCamera</b>
 * @author Vasiliy Pavliuk
 * @version 1.0
 */
public class Phone implements IPhone{
    /**Field with full name of phone*/
    private String name;
    /**Field with weight of phone*/
    private double weight;
    /**Field with diagonal of screen of phone*/
    private double diagonal;
    /**Field with number of memory of phone*/
    private int memory;
    /**A field that contains information about the presence of a camera in the phone*/
    private boolean isCamera;
    /**Constructor with certain values - create a new object
     * @param name - full name of phone
     * @param weight - weight of phone
     * @param diagonal - diagonal of screen of phone
     * @param memory - number of memory of phone
     * @param isCamera - information about the presence of a camera in the phone
     * */
    public Phone(String name, double weight, double diagonal, int memory, boolean isCamera)throws BadAttributeValueExpException {
        if(name == "" || weight <= 0 || diagonal <= 0 || memory <= 0)
            throw new BadAttributeValueExpException("Wrong data");
        this.name = name;
        this.weight = weight;
        this.diagonal = diagonal;
        this.memory = memory;
        this.isCamera = isCamera;
    }
    /**Function to obtain the value of the field {@link Phone#name}
     * @return name of phone
     * */
    @Override
    public String getName(){
        return this.name;
    }
    /**Function to obtain the value of the field {@link Phone#weight}
     * @return weight of phone
     * */
    @Override
    public double getWeight(){
        return this.weight;
    }
    /**Function to obtain the value of the field {@link Phone#diagonal}
     * @return diagonal of screen of phone
     * */
    @Override
    public double getDiagonal(){
        return this.diagonal;
    }
    /**Function to obtain the value of the field {@link Phone#memory}
     * @return number of memory of phone
     * */
    @Override
    public int getMemory(){
        return this.memory;
    }
    /**Function to obtain the value of the field {@link Phone#isCamera}
     * @return true or false
     * */
    @Override
    public boolean isCamera(){
        return this.isCamera;
    }
    /**Function to set the value of the field {@link Phone#name}
     * @param name - name of phone
     * */
    @Override
    public void setName(String name)throws BadAttributeValueExpException{
        if(name == "")
            throw new BadAttributeValueExpException("Wrong name");
        this.name = name;
    }
    /**Function to set the value of the field {@link Phone#weight}
     * @param weight - weight of phone
     * */
    @Override
    public void setWeight(double weight)throws BadAttributeValueExpException{
        if(weight <= 0)
            throw new BadAttributeValueExpException("Wrong name");
        this.weight = weight;
    }
    /**Function to set the value of the field {@link Phone#diagonal}
     * @param diagonal - diagonal of screen of phone
     * */
    @Override
    public void setDiagonal(double diagonal)throws BadAttributeValueExpException{
        if(diagonal <= 0)
            throw new BadAttributeValueExpException("Wrong name");
        this.diagonal = diagonal;
    }
    /**Function to set the value of the field {@link Phone#memory}
     * @param memory - number of memory of phone
     * */
    @Override
    public void setMemory(int memory)throws BadAttributeValueExpException{
        if(memory <= 0)
            throw new BadAttributeValueExpException("Wrong name");
        this.memory = memory;
    }
    /**Function to set the value of the field {@link Phone#isCamera}
     * @param isCamera - information about the presence of a camera in the phone
     * */
    @Override
    public void setCamera(boolean isCamera){
        this.isCamera = isCamera;
    }
}