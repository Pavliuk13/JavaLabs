
/*
Построить программу для работы с классом Правильная дробь, который должен включать соответствующие поля: числитель,
знаменатель. Программа должна обеспечивать простейшие функции: сложение, вычитание, умножение, деление, вывод дроби в
удобной форме.
 */


public class MainFraction {
    public static void main(String[] args) {
        try {
            Fraction f1 = new Fraction(5, 55);
            Fraction f2 = new Fraction(9, 99);
            System.out.println("Start values");
            f1.print(); f2.print();
            System.out.println("Sum f1 + f2");
            f1 = f1.sum(f2); f1.print();
            System.out.println("Mul f1 * f2");
            f1 = f1.mul(f2); f1.print();
            System.out.println("Div f1 / f2");
            f1 = f1.div(f2); f1.print();
            System.out.println("Sub f1 - f2");
            f1 = f1.sub(f2); f1.print();
            System.out.println("Equals?");
            System.out.println(f1.equals(f2));
            System.out.println("Hash codes: ");
            System.out.println(f1.hashCode() + " | " + f2.hashCode());
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}

