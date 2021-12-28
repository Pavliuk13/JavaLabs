import javax.management.BadAttributeValueExpException;
/*
Построить программу для работы с классом Правильная дробь, который должен включать соответствующие поля: числитель,
знаменатель. Программа должна обеспечивать простейшие функции: сложение, вычитание, умножение, деление, вывод дроби в
удобной форме.
 */

/**
 * Class for working with correct fractions. Contains fields <b>denominator</b>, <b>numerator</b> і <b>expression</b>
 * @author Vasiliy Pavliuk
 * @version 1.0
 */
public class Fraction implements IFraction{
    /** Denominator field */
    private int denominator;
    /** Field numerator */
    private int numerator;
    /** A field that stores a term representation of a fraction */
    private String expression;
    /** Constructor - create a new object
     * @param numerator - numerator of fraction
     * @param denominator - denominator of fraction
     * */
    public Fraction(int numerator, int denominator) throws BadAttributeValueExpException {
        if(denominator < numerator || denominator == 0){
            throw new BadAttributeValueExpException("Wrong attributes value");
        }
        int d = gcd(numerator, denominator);
        this.numerator = (int)(numerator / d);
        this.denominator = (int)(denominator / d);
        this.expression = this.numerator + "/" + this.denominator;
    }
    /** Function to get the value of the field {@link Fraction#denominator}
     * @return returns the value of the denominator
     * */
    @Override
    public int get_denominator(){
        return this.denominator;
    }
    /** Function to get the value of the field {@link Fraction#numerator}
     * @return returns the value of the numerator
     * */
    @Override
    public int get_numerator(){
        return this.numerator;
    }
    /** A function that adds two fractions
     * @return new fraction
     * */
    @Override
    public Fraction sum(Fraction f2){
        try{
            int first_num = this.get_numerator() * f2.get_denominator();
            int second_num = f2.get_numerator() * this.get_denominator();
            int den = this.get_denominator() * f2.get_denominator();
            return new Fraction(first_num + second_num, den);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    /** A function that subtracts two fractions
     * @return new fraction
     * */
    @Override
    public Fraction sub(Fraction f2){
        try{
            int first_num = this.get_numerator() * f2.get_denominator();
            int second_num = f2.get_numerator() * this.get_denominator();
            int den = this.get_denominator() * f2.get_denominator();
            return new Fraction(first_num - second_num, den);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    /** A function that multiplies two fractions
     * @return new fraction
     * */
    @Override
    public Fraction mul(Fraction f2){
        try{
            return new Fraction(this.get_numerator() * f2.get_numerator(), this.get_denominator() * f2.get_denominator());
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    /** A function that divides two fractions
     * @return new fraction
     * */
    @Override
    public Fraction div(Fraction f2){
        try{
            return new Fraction(this.get_numerator() * f2.get_denominator(), this.get_denominator() + f2.get_numerator());
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    /** Function for determining the greatest common divisor of two numbers
     * @return a number
     * */
    public int gcd(int i, int k){
        if (k == 0) {
            return i;
        }
        return gcd(k, i % k);
    }
    /** A function that outputs a fraction to a standard output stream */
    @Override
    public void print(){
        System.out.println(this.expression);
    }
    /** A function that equalizes two fractions
     * @return true or false
     * */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Fraction)) return false;
        Fraction f1 = (Fraction) o;
        int first_num = this.get_numerator() * f1.get_denominator();
        int second_num = f1.get_numerator() * this.get_denominator();
        if(first_num == second_num)
            return true;
        return false;
    }
    /** Function for obtaining the hash code of a fraction
     * @return a number
     * */
    @Override
    public int hashCode(){
        return 3 * expression.hashCode();
    }
    /** A function that returns a term representation of a fraction
     * @return a string
     * */
    @Override
    public String toString(){
        return expression;
    }
}
