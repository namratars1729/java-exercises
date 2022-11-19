/*
Polynomial represents a polynomial from algebra.
ax3 + bx2 + cx + d.

It contains:
- An instance variable named coeffs, which stores the coefficients of the n-degree
polynomial in a double array of size n+1, where coefficient of d is kept at index 0.

e.g. 4x^3 + 3x^2 - 5x + 2 would be represented as  [2, 5, 3, 3, 4]
e.7x^3 - 2x^2 + 3 would be represented as  [3, 0, -2, 7]

- A constructor Polynomial(coeffs:double...) that takes a variable number of doubles
to initialize the coeffs array, where the first argument corresponds to c0.
The three dots is known as varargs (variable number of arguments).
It accepts an array or a sequence of comma-separated arguments.
The compiler automatically packs the comma-separated arguments in an array.
The three dots can only be used for the last argument of the method.

e.g. Polynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
     Polynomial p1 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);

- A method getDegree() that returns the degree of this polynomial.
The degree is the size of the coeffs array - 1.

- A method toString() that returns "cnx^n + cn-1x^(n-1)+...+c1x+c0".

- A method evaluate(double x) that evaluate the polynomial for the given x, by substituting
the given x into the polynomial expression.

- Methods add() and multiply() that adds and multiplies this polynomial with the given
Polynomial instance another, and returns this instance that contains the result.

 */

public class Polynomial {
    private double[] coeffs;

    // ----- constructor
    public Polynomial( double ... varargsCoeffs ) { // double[] of varargs (variable number of arguments)
        this.coeffs = varargsCoeffs;
    }

    // ------ toString()
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length-1; i >= 0; i--) {
            sb.append(coeffs[i] + ( i != 0 ? "*x^"+i+" + " : "" ));
        }
        return sb.toString();
    }

    // ------- methods
    public int getDegree(){
        // The degree is the size of the coeffs array - 1
        return this.coeffs.length - 1;
    }

    public double evaluate( double x ) {
        // Evaluates the polynomial for the given x, by substituting
        // the given x into the polynomial expression.
        // 4x^3 + 3x^2 - 5x + 2 would be represented as  [2, -5, 3, 3, 4]
        // Math.pow( x, i) * coeffs[i]

        double sum = 0.0;
        for (int i = 0; i < coeffs.length; i++) {   // Math.pow(base, exponent)
            sum += ( this.coeffs[i] * Math.pow( x, i ) );
        }
        return sum;
    }

    public Polynomial add(Polynomial another)
    {
        Polynomial result = this;
        if (result.getDegree() < another.getDegree()) {
            result  = another;
            another = this;
        }

        double[] resultCoeffs  = result.coeffs ;
        double[] anotherCoeffs = another.coeffs ;
        for (int i = 0; i < resultCoeffs.length; i++)
        {
            if (i > anotherCoeffs.length-1) {
                continue;
            }
            resultCoeffs[i] += anotherCoeffs[i];
        }
        return new Polynomial(resultCoeffs);
    }

    public Polynomial multiply(Polynomial another)
    {
        double[] resultCoeffs  = new double[this.getDegree() + another.getDegree()+1];
        double[] anotherCoeffs = another.coeffs ;
        for (int i =0; i < resultCoeffs.length; i++)
        {
            double tmp = 0.0;
            for (int j = 0; j <= i; j++)
            {
                if (j > coeffs.length-1) {
                    continue;
                }
                if (i-j > anotherCoeffs.length-1) {
                    continue;
                }
                tmp += coeffs[j] * anotherCoeffs[i-j];
            }
            resultCoeffs[i] = tmp;
        }
        return new Polynomial(resultCoeffs);
    }

}
