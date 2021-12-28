public interface IFraction {
    Fraction sum(Fraction f2);
    Fraction div(Fraction f2);
    Fraction mul(Fraction f2);
    Fraction sub(Fraction f2);
    int get_denominator();
    int get_numerator();
    int gcd(int i, int k);
    void print();
}
