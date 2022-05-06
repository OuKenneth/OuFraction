package ou.kenneth;
// No need to change this driver

public class Driver {

	public static void main(String[] args) {
		try {
			Fraction f1 = new Fraction(1, 2);
			Fraction f2 = new Fraction(12, 3);

			System.out.println("Fraction 1: \n" + f1);
			System.out.println("Fraction 2: \n" + f2);

			Fraction f3 = f1.add(f2);
			System.out.println("Fraction 1 + Fraction 2: \n" + f3);
			if (f3.isReduced()) {
				System.out.println("Fraction is reduced already.");
			} else {
				System.out.println("Fraction could be reduced.");
			}

			f3.reduce();
			System.out.println("Reduced Fraction is: \n" + f3);

			if (f3.isReduced()) {
				System.out.println("Fraction is reduced already.");
			} else {
				System.out.println("Fraction could be reduced.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
