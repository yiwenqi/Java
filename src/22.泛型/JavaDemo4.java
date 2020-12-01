class Message <T> {
	private T content;
	public void setContent(T content){
		this.content = content ;
	}
	public T getContent(){
		return this.content;
	}
}
public class JavaDemo4{
	public static void main(String[] args) {
		Message <String> msg = new Message<> ();
		msg.setContent("www.baidu.com");
		fun(msg);
	}
	public static void fun (Message <?>  temp){
		// temp.setContent("woshinibaba");
		System.out.println(temp.getContent());
	}
}	