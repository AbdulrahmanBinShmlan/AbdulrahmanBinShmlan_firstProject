
public abstract class Employee {
	protected int id;
	protected String name;
	public Employee(int id,String name){
		this.name=name;
		this.id=id;
	}
	public Employee(Employee e){
		name=e.name;
		id=e.id;
	}
	public int getId() {
		return id;
	}
	public abstract double calculateSalary();
	public String toString(){
		return (id+" "+name);
	}

}
