@FunctionalInterface 
// p描述的是参数，r描述的是返回值
interface IFunction<P> {
	public P upper () ;
}

public class JavaDemo2{
	public static void main(String[] args) {
		IFunction< String > fun =  "www.baidu.com":: toUpperCase ;		
		System.out.println(fun.upper());
	}
}