package mortageplan.utils;

public class MathUtil {
	public double calculateMonthlyPayment(double totalLoan, double interest, int numberOfPayments) {
		double result1 = pow(1 + interest, numberOfPayments);
		double result2 = totalLoan * interest * result1;
		double result3 = pow(1 + interest, numberOfPayments) - 1;
		double monthlyPayment = result2 / result3;
		return monthlyPayment;
	}

	public double pow(double base, int powerOf) {
		if (powerOf == 0)
			return 1;
		else if (powerOf == 1)
			return base;
		else {
			double result = base;
			for (int i = 2; i <= powerOf; i++) {
				result = result * base;
			}
			return result;
		}
	}
}
