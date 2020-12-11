enum Sex{
	MALE("男"), FEMALE("女");
	private String title ;
	private Sex(Strng title ){
		this.title = title ;
	}
	public String toString(){
		return this.title ;
	}
}

class Person{
	private String name ;
	private int age ;
	private Sex sex ;
	public Person(String name ,int age ,Sex sex){
		this.age = age ;
		this.name = name ;
		this.sex = sex ;
	}

	public String toString(){
		return "姓名："+this.name +"、年龄"+this.age+"、性别："+this.sex ;
	}
}

public class JavaDemo{
	public static void main(String[] args) {
		System.out.println(new Person("张三",15,Sex.MALE));
	}
}