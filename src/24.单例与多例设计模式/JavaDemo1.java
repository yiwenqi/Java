class Singleton {
	private static  Singleton instance  ;
	public static Singleton getInstance(){
		if (instance == null ) {
			instance = new Singleton(); 
		}
		return instance ; 
	}
	public void print (){
		System.out.println("www.gsdx.com");
	}
}

public class JavaDemo1{
	public static void main(String[] args) {
		Singleton instance = null ;  //声明对象
		instance = Singleton.getInstance() ; //实例化对象
		instance.print() ;
	}
}