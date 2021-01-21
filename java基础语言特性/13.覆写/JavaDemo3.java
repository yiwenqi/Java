class Channel {
	private String info = "ww.baid.com" ;
	public getInfo(){
		return this.info ;	
	}
}

class DatabaseChannel extends Channel {
	String info = "www.xinlang.com" ;
	public void fun (){
		System.out,println(this.info);
		System.out.println(super.getInfo);
	}

}
public class JavaDemo2{
	public static void main (String args []){
		DatabaseChannel channel = new DatabaseChannel();
		channel.fun(); 
	}
}