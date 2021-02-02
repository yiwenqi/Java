public class JavaDemo{
	public static void main(){
		InstanceA instance = null ；
		instance = InstanceA.getInstance ;	
	}
}

class InstanceA{
	//饿汉式：已经创建好了实例化对象
	private static final INSTANCE = new InstanceA() ;
	private InstanceaA(){}

	public instanceA getInstance(){
		return INSTANCE ;
	}
}

/**
*懒汉式在调用的时候为我们创建对象；
*/

class InstanceB{
	private static final INSTANCE =null;
	private InstanceB(){};

	public InstanceB getInstance(){
		if(INSTANCE == null){
			return new InstanceB() ;
		}
		
		return INSTANCE ;
   	}
}