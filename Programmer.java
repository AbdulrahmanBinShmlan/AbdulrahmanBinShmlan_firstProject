
public class Programmer extends Employee{
	private int nbHours;
	public Programmer(int id,String name,int nbHours){
		super(id,name);
		this.nbHours=nbHours;
	}
	public Programmer(Programmer p){
		super(p);
		nbHours=p.nbHours;
	}
	public int getNbHours() {
		return nbHours;
	}
	public double calculateSalary(){
		return nbHours*160;
	}

}
