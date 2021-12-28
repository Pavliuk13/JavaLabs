import javax.swing.*;
import java.awt.*;

/*
* 15. Изменение фигуры в графическом окне. В центре верхней панели (JPanel) "Вывод прямоугольника" в графическом контексте
* рисуется (с помощью метода drawRoundRect()) прямоугольник со скругленными вершинами.  В нижней панели (JPanel)
* "Параметры прямоугольника" задаются следующие компоненты: надпись (JLabel) "Цвет:", вращающийся список (JSpinner)
* со значениями: "Черный" (цвет по умолчанию),  "Красный", "Зеленый" и "Синий", надпись (JLabel) "Ширина закругления",
* текстовое поле (JTextField), надпись (JLabel) "Высота закругления:", текстовое поле (JTextField) и кнопка
* (JButton) "Изменить прямоугольник". При наборе данных во вращающихся списках, вводе данных в текстовых полях
* (в пикселях) и при нажатии кнопки "Изменить прямоугольник" прямоугольник перерисовывается заданным цветом и с
* заданным новыми значениями ширины и высоты закруглений. Перед выводом фигуры выполняется проверка, введены ли в
* текстовых полях все данные и являются ли они целыми числами.
 * */


/**
 * The class is used to store objects with the property
 * <b>color</b> <b>x</b> <b>y</b>
 *
 * @author Vasiliy Pavliuk
 * @version 1.0
 */
public class Fifteen extends JPanel {
    public static Color color;
    public static Integer x = 0;
    public static Integer y = 0;

    /**
     * Method for starting program and create an app with panels and painting part
     *
     * @param args - that we can give with console usage
     */
    public static void main(String[] args) {
        JFrame jFrame = add_frame("Task 15");
        JPanel output = new draw();
        output.setBorder(BorderFactory.createTitledBorder("Outputting a rectangle:"));
        JPanel parameters = set_panel();
        parameters.setBorder(BorderFactory.createTitledBorder("Parameters a rectangle:"));

        jFrame.add(output);
        jFrame.add(parameters, BorderLayout.SOUTH);

        jFrame.revalidate();
    }

    /**
     * Method for making the app and positioning it on the screen
     *
     * @param title - that set a title of the app
     */
    public static JFrame add_frame(String title) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle(title);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 250, 1000, 500);
        return jFrame;
    }

    /**
     * Method that set a panel with components (with validating)
     *
     * @return parameters
     */
    public static JPanel set_panel() {
        JPanel parameters = new JPanel();
        JLabel col = new JLabel("Color: ");
        JSpinner choose_col = get_spinner();
        JLabel width_ = new JLabel("Rounding width: ");
        JTextField wid = new JTextField(5);
        JLabel height_ = new JLabel("Rounding height: ");
        JTextField heig = new JTextField(5);
        JButton submit = new JButton("Change");

        submit.addActionListener(e -> {
            String wid_ = wid.getText();
            String heig_ = heig.getText();
            String regexp = "^[0-9]+$";
            if (wid_.matches(regexp) && heig_.matches(regexp)) {
                x = Integer.parseInt(wid.getText());
                y = Integer.parseInt(heig.getText());
            } else {
                JOptionPane.showMessageDialog(parameters, "Wrong input data");
            }

        });

        parameters.add(col);
        parameters.add(choose_col);
        parameters.add(width_);
        parameters.add(wid);
        parameters.add(height_);
        parameters.add(heig);
        parameters.add(submit);

        return parameters;
    }

    /**
     * Method that set a value of choosing color
     *
     * @return choose color
     */
    public static JSpinner get_spinner() {
        JSpinner choose_col = new JSpinner();
        String[] Colors = {"Black", "Red", "Green", "Blue"};
        choose_col.setModel(new SpinnerListModel(Colors));
        choose_col.setValue("Black");
        choose_col.addChangeListener(e -> {
            String value = (String) choose_col.getValue();
            switch (value) {
                case "Black":
                    color = Color.BLACK;
                    break;
                case "Red":
                    color = Color.RED;
                    break;
                case "Green":
                    color = Color.GREEN;
                    break;
                case "Blue":
                    color = Color.BLUE;
                    break;
            }
        });
        return choose_col;
    }

    /**
     * The class is used to paint a figure with some parameters (color, size and position)
     */
    static class draw extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.drawRoundRect(350, 100, 300, 200, x, y);
            repaint();
        }
    }
}