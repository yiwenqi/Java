class Channel {
	public void connect(){
		System.out.println("【Channel】");
	}
}

class DatabaseChannel extends Channel {
	

}
public class JavaDemo{
	public static void main (String args []){
		DatabaseChannel channel = new DatabaseChannel();
		channel.connect();
	}
}