/**
 * Write a description of class Complex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complex
{

    private final Rational real;

    private final Rational imaginary;

    public Complex(Rational real, Rational imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Rational real) {
        this(real, new Rational(0));
    }

    public Rational getReal() {
        return real;
    }

    public Rational getImaginary() {
        return imaginary;
    }

    public String toString() {
        if (imaginary.equals(new Rational(0)))
        {
            return real + "";
        }
        else if (imaginary.lessThan(new Rational(0)))
        {
            return real + " - " + imaginary.multiply(new Rational(-1)) + "i";
        }
        else
        {
            return real + " + " + imaginary + "i";
        }

    }

    public Complex conjugate() {
        return new Complex(real, imaginary.multiply(new Rational(-1)));
    }

    public Complex add(Complex rhs) {
        return new Complex(this.real.add(rhs.real), this.imaginary.add(rhs.imaginary));
    }

    public Complex add(Rational x) {
        return new Complex(this.real.add(x), this.imaginary);
    }

    public Complex subtract(Complex rhs) {
        return new Complex(this.real.subtract(rhs.real), this.imaginary.subtract(rhs.imaginary));
    }

    public Complex subtract(Rational x) {
        return new Complex(this.real.subtract(x), this.imaginary);
    }

    public Complex multiply(Complex rhs) {
        return new Complex(this.real.multiply(rhs.real).add((this.imaginary.multiply(rhs.imaginary)).multiply(new Rational(-1))), this.real.multiply(rhs.imaginary).add(this.imaginary.multiply(rhs.real)));
    }

    public Complex multiply(Rational x) {
        return new Complex(this.real.multiply(x), this.imaginary.multiply(x));
    }

    public Complex divide(Complex rhs) {
        Complex denominator = rhs.multiply(rhs.conjugate());
        Complex numerator = this.multiply(rhs.conjugate());
        return new Complex(numerator.real.divide(denominator.real), numerator.imaginary.divide(denominator.real));
    }

    public Complex divide(Rational x) {
        return new Complex(this.real.divide(x), this.imaginary.divide(x));
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(new Rational(4), new Rational(9));
        Complex c2 = new Complex(new Rational(3), new Rational(5));
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);


        Complex c1Conjagate = c1.conjugate();
        System.out.println("Conjugate of " + c1 + ": " + c1Conjagate);

        Complex c1Add = c1.add(c2);
        System.out.println(c1 + " + " + c2 + ": " + c1Add);

        Complex c2Add =  c1.add(new Rational(4));
        System.out.println(c1 + " + 4: " + c2Add);

        Complex c1Subtract = c1.subtract(c2);
        System.out.println(c1 + " - " + c2 + ": " + c1Subtract);

        Complex c2Subtract =  c1.subtract( new Rational(4));
        System.out.println(c1 + " - 4: " + c2Subtract);

        Complex c1Multiply = c1.multiply(c2);
        System.out.println(c1 + " * " + c2 + ": " + c1Multiply);

        Complex c2Multiply = c1.multiply(new Rational(4));
        System.out.println(c1 + " * 4: " + c2Multiply);

        Complex c1Divide = c1.divide(c2);
        System.out.println(c1 + " / " + c2 + ": " + c1Divide);

        Complex c2Divide = c1.divide(new Rational(4));
        System.out.println(c1 + " / 4: " + c2Divide);
    }
}
