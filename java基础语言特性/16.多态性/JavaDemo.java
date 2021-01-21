class Message {
	public void println(){
		System.out.println("父类方法");
	}
}

class DataBaseMessage extends Message{
	public void println(){
		System.out.println("Oracle数据库相关信息");
	}
}

public class JavaDemo{
	public static void main(String[] args) {
		DataBaseMessage msg = new DataBaseMessage();
		msg.println();
	}
}