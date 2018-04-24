import java.io.File;


public class AuditDepartment {
	private String company;
	private Employee[] arrEmp;
	private int nbEmp;
	public AuditDepartment(){
		
	}
	public AuditDepartment(String company,int size)throws NegativeArraySizeException{
		this.company=company;
		arrEmp=new Employee[size];
		nbEmp=0;
		
	}
	public int searchEmployee(int id){
		for(int i=0;i<nbEmp;i++){
			if(arrEmp[i].getId()==id){
				return i;
			}
		}
		return -1;
	}
	public boolean addEmployee(Employee e){
		int index=searchEmployee(e.getId());
		if(nbEmp<arrEmp.length&&index ==-1){
		if(e instanceof Programmer){
			arrEmp[nbEmp++]=new Programmer((Programmer)e);
			return true;
		}
		else{
			arrEmp[nbEmp++]=new ProjectManager((ProjectManager)e);
		return true;
		}
		}
		return false;
	}
	public boolean removeEmployee(Employee e){
		int index=searchEmployee(e.getId());
		if(index !=-1){
			arrEmp[index]=arrEmp[nbEmp-1];
			nbEmp--;
			return true;
		}
		return false;
	}
	public Employee getEmployeeAt(int i) throws ArrayIndexOutOfBoundsException{
		
		 if(arrEmp[i] !=null){
			return arrEmp[i];
		}
		else{
			throw new NullPointerException();
		}
	}
	public double calculateAvgSalary()throws ArithmeticException{
		double avg=0;
		 
			 for(int i=0;i<nbEmp;i++){
				 avg+=arrEmp[i].calculateSalary();
			 }
			 return avg/nbEmp;
		 
	}
	
	public Employee[] getEmployeesWithSalary(double lowerBound,double upperBound) {
		Employee[] between=new Employee[nbEmp];
		int nbBet=0;
		if(lowerBound>upperBound){
			throw new IllegalArgumentException();
		}
		else{
			for(int i=0;i<nbEmp;i++){
				if(lowerBound<arrEmp[i].calculateSalary()&&upperBound>arrEmp[i].calculateSalary()){
					between[nbBet]=arrEmp[i];
					nbBet++;
				}	
			}
			return between;
		}
	}
	public void display(){
		for(int i=0;i<nbEmp;i++){
			arrEmp[i].toString();
		}
	}
	public void saveEmployeeData(String filename){
		File f1=new File("tvt");
	}

}
