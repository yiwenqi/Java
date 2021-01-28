enum Color{ //枚举类
	Red , Green ,Blue ; //实例化对象
}

public class JavaDemo4{
	public static void main(String[] args) {
		for (Color c : Color.values() ) {
			System.out.println(c.ordinal()+"--"+c.name());
		}
	}
}