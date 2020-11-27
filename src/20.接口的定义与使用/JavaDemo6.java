interface IEat {
	abstract void get ();
}

class EatReal implements IEat{
	public void get(){
		System.out.println("【真实主题】:得到一份真实的美食，开始美美的吃上一顿");		
	}
}

class EatProxy implements IEat{
	private IEat eat;
	public EatProxy(IEat eat){
		this.eat = eat;
	}
	public void get(){
		this.perpare();
		this.cooking();
		this.eat.get();
		this.clear();
	}
	public void perpare(){
		System.out.println("【代理主题】开始准备食材");
	}
	public void cooking(){
		System.out.println("【代理主题】开始烹饪");
	}
	public void clear(){
		System.out.println("【代理主题】收拾碗筷");
	}
}


public class JavaDemo6{
	public static void main(String[] args) {
		IEat eat = new EatProxy(new EatReal());
		eat.get();
	}
}