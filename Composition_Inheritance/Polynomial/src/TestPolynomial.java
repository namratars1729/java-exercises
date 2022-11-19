public class TestPolynomial {
    public static void main(String[] args)
    {

        // Can invoke with a variable number of arguments
        Polynomial p1 = new Polynomial(1.1, 2.2, 3.3);
        Polynomial p2 = new Polynomial(1.1, 2.2, 3.3, 4.4, 5.5);

        System.out.println("Polynomial p1: "+p1);
        System.out.println("Polynomial p2: "+p2);

        // Can also invoke with an array
        double[] coeffs = {1.2, 3.4, 5.6, 7.8};
        Polynomial p3 = new Polynomial(coeffs);
        System.out.println("Polynomial p3: "+p3);

        Polynomial p4 = new Polynomial(1, 0, 3);
        System.out.println("Polynomial p4: "+ p4);
        System.out.println("Polynomial evaluated with x = 3: " + p4.evaluate(3));

        System.out.println("Sum of polynomials p1 and p2: "+p1.add(p2));

        p1 = new Polynomial(1.1, 2.2, 3.3);
        p2 = new Polynomial(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("Sum of polynomials p2 and p1: "+p2.add(p1));

        p1 = new Polynomial(1.1, 2.2, 3.3);
        p2 = new Polynomial(1.1, 2.2, 3.3);
        System.out.println("Multiply polynomials p1 and p2: "+p1.multiply(p2));
    }
}
