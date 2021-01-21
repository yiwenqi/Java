class Channel {
	private  void connect(){
		System.out.println("【Channel】");
	}
	void fun(){
		this.connect();
	}
}

class DatabaseChannel extends Channel {
	//此时父类connect方法对于子类来说是不可见，因此子类的connect方法是一个新的方法 
		public void connect(){
			System.out.println("【子类方法】");
		}

}
public class JavaDemo2{
	public static void main (String args []){
		DatabaseChannel channel = new DatabaseChannel();
		channel.fun(); //输出一个【channel】
	}
}