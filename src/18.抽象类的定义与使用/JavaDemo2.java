abstract class Person{
	private String type;
	public abstract String getName();

	public static Person getInfo(){
		return new son();
	}
	
}

class son extends Person{

	public String getName(){
		return "我是李四";
	}
}
public class JavaDemo2{
	public static void main(String [] arg){
		Person per = Person.getInfo();
		System.out.println(per.getName()); 
	}
}