class Point {
	 private Object x ;
	 private Object y ;

	 public void setX (Object x ){
	 	this.x = x;
	 }
	 public void setY (Object y ){
	 	this.y = y;
	 }

	 public Object getX(){
	 	return this.x;
	 }

	 public Object getY(){
	 	return this.y;
	 }
}

public class JavaDemo{
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