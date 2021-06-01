package tax;

// class for person's information
public class Person {
	double income;
	boolean isMarried;
	int Number_of_children;
	int percent_contibuttion_to_pension;
	
	public Person(double income, boolean ismarried, int num_children,int percent) {
		this.income=income;
		this.isMarried=ismarried;
		this.Number_of_children=num_children;
		this.percent_contibuttion_to_pension=percent;
	}
	

}
