class Singleton {
	private static final Singleton INSTANCE = new Singleton() ;
	public static Singleton getInstance(){
		return INSTANCE ; 
	}
	public void print (){
		System.out.println("www.gsdx.com");
	}
}

public class JavaDemo{
	public static void main(String[] args) {
		Singleton instance = null ;  //声明对象
		instance = Singleton.getInstance() ; //实例化对象
		instance.print() ;
	}
}