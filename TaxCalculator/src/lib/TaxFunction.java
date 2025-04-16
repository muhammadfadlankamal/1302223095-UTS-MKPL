package lib;

public class TaxFunction {

	public static int calculateTaxFor(Employee e) {
		return calculateTax(
				e.getMonthlySalary(),
				e.getOtherMonthlyIncome(),
				e.calculateWorkingMonthsThisYear(),
				e.getAnnualDeductible(),
				!e.hasSpouse(),
				e.getNumberOfChildren());
	}

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
			int deductible, boolean isSingle, int numberOfChildren) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}

		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}

		int nonTaxable = 54000000;
		if (!isSingle) {
			nonTaxable += 4500000 + (numberOfChildren * 1500000);
		}

		int netIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible - nonTaxable;
		int tax = (int) Math.round(0.05 * netIncome);

		return Math.max(tax, 0);
	}
}
