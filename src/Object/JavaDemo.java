class Person {
	private String name;
	private int age;

	public boolean equals(Object obj){
		if(obj instanceof Person){
			return false;
		}
		if(obj == null){
			return false;
		}
		if(this == obj){
			return true;
		}
		Person per = (Person) obj; 
		return this.name.equals(per.name) && this.age == per.age ;
	}
}

public class JavaDemo{
	public static void main(String[] args) {
		Person perA = new Person("wangwu" ,15);
		Person perB = new Person("wangwu" ,15);
		
		System.Out.println(perA.equals(perB));
	}
}