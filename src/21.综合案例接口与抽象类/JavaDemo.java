
interface IClassName{
	abstract void getClassName();
}

class Company implements IClassName{
	public void getClassName(){
		System.out.println("ClassName");
	}
}

public class JavaDemo{
	public static void main(String[] args) {
		ClassName cn =  new Company();
		cn.getClassName();
	}
}