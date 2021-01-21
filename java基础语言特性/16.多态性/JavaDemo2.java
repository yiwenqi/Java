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

class WebService extends Message{
	public void println(){
		System.out.println("WebService服务启动");
	}
}

public class JavaDemo2{
	public static void main(String[] args) {
		fun(new DataBaseMessage());
		fun(new WebService());
	}
	public static void fun(Message msg){
		msg.println();
	}
}