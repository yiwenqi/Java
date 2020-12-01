class Message <T> {
	private T content;
	public void setContent(T content){
		this.content = content ;
	}
	public T getContent(){
		return this.content;
	}
}
public class JavaDemo3{
	public static void main(String[] args) {
		Message <String> msg = new Message<> ();
		msg.setContent("www.baidu.com");
		fun(msg);
	}
	public static void fun (Message <String> temp){
		System.out.println(temp.getContent());
	}
}	