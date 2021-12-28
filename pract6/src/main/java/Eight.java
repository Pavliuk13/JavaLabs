import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/*
* 8. Вывод фигур в графическом окне. В окне определена строка меню (JMenuBar), в которой определены два меню (JMenu)
* – "Цвет и "Вывод". В меню "Цвет" определены четыре пункта меню (JRadioButtonMenuItem): "Черный" (цвет по умолчанию),
* "Красный", "Зеленый" и "Синий".  В меню "Вывод" определены три пункта меню (JCheckBoxMenuItem): "Квадрат",  "Круг",
* и "Треугольник". В верней панели окна панели (JPanel) окна выводятся в графическом контексте (с помощью методов
* drawRect(), drawOval() и drawPolygon()) три фигуры: прямоугольник, круг и треугольник. В нижней панели (JPanel)
* "Управление выводом" задается надпись (JLabel) "Цвет:", раскрывающееся меню (JComboBox), в котором определены четыре
* пункта: "Черный" (цвет по умолчанию),  "Красный", "Зеленый" и "Синий", надпись (JLabel) "Вывод:" и три переключателя
* (JCheckBox): "Квадрат",  "Круг",  и "Треугольник". При выборе пункта раскрывающегося меню все фигуры заполняются
* заданным цветом. На экран выводятся только те фигуры, переключатели которых включены.
 * */


/**
 * The class is used to store objects with the property
 * <b>square</b> <b>circle</b> <b>rectangle</b> <b>comboBox</b> <b>buttonGroup</b>
 *
 * @author Vasiliy Pavliuk
 * @version 1.0
 */
public class Eight{
    public static JCheckBox square;
    public static JCheckBox circle;
    public static JCheckBox rectangle;
    public static JComboBox comboBox;
    public static ButtonGroup buttonGroup;

    /**
     * Method for starting program and create an app with panels and painting part
     *
     * @param args - that we can give with console usage
     */
    public static void main(String[] args){
        JFrame frame = CreateFrame("Menu");

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu color = CreateRadioButtonMenu("Color");
        menuBar.add(color);

        JMenu output = CreateCheckBoxMenu("Output");
        menuBar.add(output);

        JPanel panel = new draw();
        frame.add(panel);

        String[] values = {"Black", "Red", "Green", "Blue"};
        AddComboBox(frame, values);

        frame.add(AddCheckBoxPanel());
    }

    /**
     * Method adding ComboBox in app window
     *
     * @param frame - frame of app
     * @param  values - names of categories
     */
    public static void AddComboBox(JFrame frame, String[] values){
        Container content = frame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        comboBox = new JComboBox(values);
        content.add(comboBox);
    }

    /**
     * Method adding CheckBox panel in app window
     */
    public static JPanel AddCheckBoxPanel(){
        square = new JCheckBox("Square", true);
        circle = new JCheckBox("Circle", true);
        rectangle = new JCheckBox("Rectangle", true);
        JLabel label = new JLabel("Output");
        JPanel panel1 = new JPanel();
        panel1.add(label);
        panel1.add(circle);
        panel1.add(square);
        panel1.add(rectangle);
        return panel1;
    }

    /**
     * Method adding RadioButtonMenu in app window
     * @param name - name of tab
     */
    public static JMenu CreateRadioButtonMenu(String name){
        JMenu jMenu = new JMenu(name);
        JRadioButtonMenuItem black = new JRadioButtonMenuItem("Black", true);
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem green = new JRadioButtonMenuItem("Green");
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Blue");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(black);
        buttonGroup.add(red);
        buttonGroup.add(green);
        buttonGroup.add(blue);

        jMenu.add(black);
        jMenu.add(red);
        jMenu.add(green);
        jMenu.add(blue);

        return jMenu;
    }

    /**
     * Method for creating Menu
     * @param name - name of Menu
     */
    public static JMenu CreateCheckBoxMenu(String name){
        JMenu jMenu = new JMenu(name);

        JCheckBoxMenuItem square = new JCheckBoxMenuItem("Square", true);
        JCheckBoxMenuItem circle = new JCheckBoxMenuItem("Circle", true);
        JCheckBoxMenuItem rectangle = new JCheckBoxMenuItem("Rectangle", true);

        jMenu.add(square);
        jMenu.add(circle);
        jMenu.add(rectangle);

        return jMenu;
    }

    /**
     * Method for creating frame of app
     */
    public static JFrame CreateFrame(String title) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle(title);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        return jFrame;
    }

    /**
     * The class is used to paint a figure with some parameters (color, size and position)
     */
    static class draw extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int [] x = {50,100,0};
            int [] y = {0,100,100};
            String color = (String) comboBox.getSelectedItem();
            switch (color){
                case "Black":
                    g.setColor(Color.BLACK);
                    break;
                case "Red":
                    g.setColor(Color.RED);
                    break;
                case "Blue":
                    g.setColor(Color.BLUE);
                    break;
                case "Green":
                    g.setColor(Color.GREEN);
                    break;
            }


            if(circle.isSelected())
                g.fillOval(100, 0, 50, 50);
            if(square.isSelected())
                g.fillRect(200, 0, 100, 100);
            if(rectangle.isSelected())
                g.fillPolygon(x, y, 3);
            repaint();
        }
    }
}
