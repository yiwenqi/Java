
interface  IFood{
	abstract void eat();
}

class Bread implements IFood{
	public void eat(){
		System.out.println("吃面包");
	}
}

class Milk implements IFood{
	public void eat (){
		System.out.println("喝牛奶");
	}
}

class FactorFood {
	public static IFood getInstance(String ifoodname){
		if ("Bread".equals(ifoodname)) {
			return new Bread();
		}
		if("Milk".equals(ifoodname)){
			return new Milk();
		}
		else{
			return null;
		}
	}
}

public class JavaDemo5 {
	public static void main(String[] args) {
		IFood ifood =  FactorFood.getInstance(args[0]);
		ifood.eat();
	}
}