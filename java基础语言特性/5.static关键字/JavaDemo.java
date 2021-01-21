class Book {
	private String title ;
	private static int count = 0;
	public Book (String title){
		this.title = title;
		count++;
		System.out.println("第" +count+"本新书创建出来了。")；
	}

}
public class JavaDemo{
	public static void main(String args[] ){
		new Book("java");
	}
}