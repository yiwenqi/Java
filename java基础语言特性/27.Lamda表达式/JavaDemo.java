interface IMessage {
	public void send (String str ) ;
}

public class JavaDemo {
	public static void main(String[] args) {
		IMessage msg = ( str ) ->{
			System.out.println("发送消息："+ str);
		} ;
		msg.send("我很好");
	}
}