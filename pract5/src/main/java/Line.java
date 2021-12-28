/*
Создать класс Линия на экране. Поля – координаты начала и  конца. Функции-члены вычисляют длину, устанавливает поля
и возвращают значения, перемещают линию. Функции-члены установки полей класса должны проверять корректность задаваемых
параметров.
 */


/** A class that represents a line in space. Contains fields <b>start_x</b>, <b>start_y</b>, <b>finish_x</b>, <b>finish_y</b>
 * @author Vasiliy Pavliuk
 * @version 1.0
 * */
public class Line implements ILine{
    /** x start coordinate */
    private int start_x;
    /** y start coordinate */
    private int start_y;
    /** x finish coordinate */
    private int finish_x;
    /** y finish coordinate */
    private int finish_y;
    /** Constructor - create a new object
     * @param start_x - start x coordinate
     * @param start_y - start y coordinate
     * @param finish_x - finish x coordinate
     * @param finish_y - finish y coordinate
     * */
    public Line(int start_x, int start_y , int finish_x, int finish_y){
        this.start_x = start_x;
        this.start_y = start_y;
        this.finish_x = finish_x;
        this.finish_y = finish_y;
    }
    /** Function to get the value of the field {@link Line#start_x}
     * @return x start coordinate
     * */
    @Override
    public int get_start_x(){
        return this.start_x;
    }
    /** Function to get the value of the field {@link Line#start_y}
     * @return y start coordinate
     * */
    @Override
    public int get_start_y(){
        return this.start_y;
    }
    /** Function to get the value of the field {@link Line#finish_x}
     * @return x finish coordinate
     * */
    @Override
    public int get_finish_x(){
        return this.finish_x;
    }
    /** Function to get the value of the field {@link Line#finish_y}
     * @return y finish coordinate
     * */
    @Override
    public int get_finish_y(){
        return this.finish_y;
    }
    /** a function that calculates and returns the value of the Line length
     * @return double
     * */
    @Override
    public double get_len(){
        return Math.sqrt(Math.pow(this.start_x - this.finish_x, 2) + Math.pow(this.start_y - this.finish_y, 2));
    }
    /** function that sets the initial coordinate x */
    @Override
    public void set_start_x(int x){
        this.start_x = x;
    }
    /** function that sets the initial coordinate y */
    @Override
    public void set_start_y(int y){
        this.start_y = y;
    }
    /** function that sets the finish coordinate x */
    @Override
    public void set_finish_x(int x){
        this.finish_x = x;
    }
    /** function that sets the finish coordinate y */
    @Override
    public void set_finish_y(int y){
        this.finish_y = y;
    }
    /** A function that equalizes two lines
     * @return true or false
     * */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Line))
            return false;
        Line l = (Line) o;
        if(this.start_x == l.get_start_x() && this.start_y == l.get_start_y() && this.finish_x == l.get_finish_x() && this.finish_y == l.get_finish_y())
            return true;
        return false;
    }
    /** A function that returns a term representation of a coordinates
     * @return a string
     * */
    @Override
    public String toString(){
        return "X: " + this.start_x + " Y: " + this.start_y + " X: " + this.finish_x + " Y: " + this.finish_y + " L: " + this.get_len();
    }
}