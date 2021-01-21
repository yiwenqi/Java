enum Color{ //枚举类
	Red , Green ,Blue ; //实例化对象
}

public class JavaDemo3{
	public static void main(String[] args) {
		Color c = Color.Green ;
		switch(c) {
			    case Red : 
				System.out.println("红色");
				break ; 
				case Green : 
				System.out.println("绿色");
				break ;
				case Blue : 
				System.out.println("蓝色");
				break ; 

		}
	}
}