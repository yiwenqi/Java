interface IMessage<T> {
	public String echo(T t) ;
}

class MessageImpl<T> implements IMessage<T>{
	public String echo(T t){
		return "echo:" + t ;
	}
}

public class JavaDemo5 {
	public static void main(String[] args) {
		IMessage<String> mes = new MessageImpl<String>();
		System.out.println(mes.echo("www.gsdx.com"));
	}
}