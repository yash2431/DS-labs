import java.util.HashMap;
import java.util.Map;

class Polynomial {
    private Map<Integer, Integer> terms;

    Polynomial() {
        terms = new HashMap<>();
    }

    
    void addTerm(int coefficient, int exponent) {
        if (coefficient == 0) return;
        terms.put(exponent, terms.getOrDefault(exponent, 0) + coefficient);
    }

    
    void addPolynomial(Polynomial other) {
        for (Map.Entry<Integer, Integer> entry : other.terms.entrySet()) {
            addTerm(entry.getValue(), entry.getKey());
        }
    }

    
    @Override
    public String toString() {
        if (terms.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {
            int coefficient = entry.getValue();
            int exponent = entry.getKey();

            if (coefficient != 0) {
                if (sb.length() > 0) {
                    sb.append(coefficient > 0 ? " + " : " - ");
                } else if (coefficient < 0) {
                    sb.append("-");
                }
                sb.append(Math.abs(coefficient));
                if (exponent > 0) {
                    sb.append("x");
                    if (exponent > 1) {
                        sb.append("^").append(exponent);
                    }
                }
            }
        }

        return sb.toString();
    }
}

public class PolynomialAddition {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        
        p1.addTerm(3, 2);
        p1.addTerm(2, 1);
        p1.addTerm(1, 0);

        p2.addTerm(4, 2);
        p2.addTerm(-3, 1);
        p2.addTerm(5, 0);

        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);

        
        p1.addPolynomial(p2);

        System.out.println("Sum of Polynomials: " + p1);
    }
}
