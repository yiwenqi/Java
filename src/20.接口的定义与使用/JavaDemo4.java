
interface  IFood{
	abstract void eat();
}

class Bread implements IFood{
	public void eat(){
		System.out.println("吃面包");
	}
}

class milk implements IFood{
	public void eat (){
		System.out.println("喝牛奶");
	}
}

public class JavaDemo4 {
	public static void main(String[] args) {
		IFood ifood = new Bread();
		ifood.eat();
	}
}