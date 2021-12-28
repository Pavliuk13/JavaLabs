import javax.management.BadAttributeValueExpException;

public interface IPhone {
    String getName();
    double getWeight();
    double getDiagonal();
    int getMemory();
    boolean isCamera();
    void setName(String name)throws BadAttributeValueExpException;
    void setWeight(double weight)throws BadAttributeValueExpException;
    void setDiagonal(double diagonal)throws BadAttributeValueExpException;
    void setMemory(int memory)throws BadAttributeValueExpException;
    void setCamera(boolean isCamera);
}
