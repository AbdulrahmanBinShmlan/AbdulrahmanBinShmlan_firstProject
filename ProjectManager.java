
public class ProjectManager extends Employee{
	private int nbProject;
	public ProjectManager(int id,String name,int nbProject){
		super(id,name);
		this.nbProject=nbProject;
	}
	public ProjectManager(ProjectManager p){
		super(p);
		nbProject=p.nbProject;
	}
	public int getNbProject() {
		return nbProject;
	}
	public double calculateSalary(){
		return 30000+(1000*nbProject);
	}

}
