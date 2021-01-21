class Point <T> {
	 private <T>  x ;
	 private <T>  y ;

	 public void setX (T x ){
	 	this.x = x;
	 }
	 public void setY (T y ){
	 	this.y = y;
	 }

	 public T getX(){
	 	return this.x;
	 }

	 public T getY(){
	 	return this.y;
	 }
}

public class JavaDemo2{
	public static void main(String[] args) {
		Point point = new Point();
		//第一步根据需求设计内容
		point.setX(10); // 自动装箱
		point.setY("北纬20度"); // 自动装箱
		//第二步获取数据
		int x = (int)point.getX();
		int y = (int)point.getY();
		System.out.println("x的坐标为:"+ x + ",y的坐标:"+ y );
	}
}