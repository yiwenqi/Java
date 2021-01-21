class Person {
	public void println(){
		System.out.println("我是person类");
	}
}

class SupperMan extends Person{
	public void fly(){
		System.out.println("我是SupperMan：我可以飞");
	}

	public void fir(){
		System.out.println("我是person类：我可以喷火");
	} 
}
 
public class JavaDemo3{
	public static void main(String[] args) {
		Person per = new SupperMan();
		System.out.println("我是person类：我可以喷火");
		per.println();
		SupperMan sup = (SupperMan)per;
		sup.fly();
		sup.fir();
	}
}