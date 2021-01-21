abstract class Person{
	private String type;
	public abstract String getName();

	public Message (String typr) {
		this.type = type ;
	}
}

class son extends Person{

	public son (String type){
		super(type);
	}

	public String getName(){
		return "我是李四";
	}
}
public class JavaDemo{
	public static void main(String [] arg){
		Person per = new son();
		System.out.println(per.getName()); 
	}
}