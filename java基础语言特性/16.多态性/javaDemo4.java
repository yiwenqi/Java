class Person {
	public void println(){
		System.out.println("我是person类");
	}
}

public class JavaDemo4{
	public static void main(String[] args) {
		Person per = new SupperMan();
		System.out.println(per instanceof Person);
		if (per instanceof Person) {
			SupperMan sup = (SupperMan)per;
			sup.fly();
			sup.fir();
		}
	}
}