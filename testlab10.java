import java.util.InputMismatchException;
import java.util.Scanner;


public class testlab10 {

	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(System.in);
		int i;
		AuditDepartment a = new AuditDepartment();
		boolean created = false;
		while(!created) {
			System.out.println("enter name and size of department");
			try{
				a=new AuditDepartment(in.next(),in.nextInt());
				created = true;
			}
			catch(NegativeArraySizeException e){
				System.out.println("array size must be positive");
			}
			catch(InputMismatchException e) {
				in.next();
				System.out.println("invalid input");
			}
		}
		do{
			System.out.println("1.to addEmployee\n2.to print info of an Employee\n3.to print average salary\n4.to list the employees with certain salary rang\n5.to dis play the information of all employees\n-1.to exit");
			i=in.nextInt();
			switch(i){
			case 1:
				int j;
				System.out.println("enter 1 for a programmer or 2 for a projectmanager");
				j=in.nextInt();
				if(j==1){
					System.out.println("enter name and id and number of hours");
					try{
					Programmer p=new Programmer(in.nextInt(),in.next(),in.nextInt());
					a.addEmployee(p);
					}
					catch(InputMismatchException e) {
						in.next();
						System.out.println("invalid input");
					}
				}
				else if(j==2){
					System.out.println("enter name and id and number of projects");
					try{
					ProjectManager p=new ProjectManager(in.nextInt(),in.next(),in.nextInt());
					a.addEmployee(p);
					}
					catch(InputMismatchException e) {
						in.next();
						System.out.println("invalid input");
					}
				}
				else
					System.out.println("wrong choise");
				break;
			case 2:
				int s;
				System.out.println("enter the index of the employee");
				s=in.nextInt();
				try{
					a.getEmployeeAt(s);
				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println(e.getMessage());
				}
				catch(NullPointerException e){
					System.out.println(e.getMessage());
				}
				catch(InputMismatchException e) {
					in.next();
					System.out.println("invalid input");
				}
				break;
			case 3:
				try{
					a.calculateAvgSalary();
				}
				catch(ArithmeticException e){
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				double low,up;
				System.out.println("enter the lower and upper bounds");
				try{
					low=in.nextDouble();
					up=in.nextDouble();
					a.getEmployeesWithSalary(low, up);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				catch(InputMismatchException e) {
					in.next();
					System.out.println("invalid input");
				}
				break;
			case 5:
				a.display();

			}

		}while(i==-1);

	}

}
