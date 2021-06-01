package tax;

import java.util.Scanner;

public class input_class {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// get the data of the person
		Person person = getData(s);
		// calculate tax
		double tax = taxAmount(person);
		// print tax
		System.out.println(tax);

	}
	// function to calculate the tax
	public static double taxAmount(Person person) {
		double income = person.income;
		double tax;
		// calulating taxable income
		double taxable_income = income;
		double pension_money = income * person.percent_contibuttion_to_pension / 100.0;
		if (person.isMarried) {
			taxable_income -= 7000;
			if (person.Number_of_children!=0) {
				taxable_income -= 1500*person.Number_of_children;
			} else {
				taxable_income -= 2 * 1500;
			}
		} else {
			taxable_income -= 4000;
			taxable_income -= 1500;
		}
		taxable_income -= pension_money;
		
		// calculating tax according to money slab
		if (income >= 0 && income <= 15000) {
			tax = (15.0) * income / 100.0;
		} else if (taxable_income >= 15001 && taxable_income <= 40000) {
			tax = 2250 + (taxable_income - 15000) * 25 / 100.0;
		} else {
			tax = 8640 + (taxable_income - 40000) * 35 / 100.0;
		}

		return tax;
	}

	// function to get the data
	public static Person getData(Scanner s) {
		double income = 0;
		System.out.println("Enter whether he/she is married?");
		boolean isMarried = s.next().equals("married") ? true : false;
		int number_of_children = 0;
		if (isMarried) {
			System.out.println("Enter the net income of the both partners.");
			income = s.nextDouble();
			System.out.println("Enter the number of children under the age of 14");
			number_of_children = s.nextInt();

		} else {
			System.out.println("Enter the income of the person.");
			income = s.nextDouble();
		}
		System.out.println("Enter the percentage of gross income contributed to pension fund");
		int percent = s.nextInt();
		return new Person(income, isMarried, number_of_children, percent);
	}

}
