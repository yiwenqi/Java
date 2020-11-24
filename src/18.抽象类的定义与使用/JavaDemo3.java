abstract class Action{
	public static final int EAT = 1;
	public static final int SLEEP = 5;
	public static final int WORK = 10;

	public void commd(int commd){
		switch (commd){
			case EAT:{
				this.eat();
				break;
			}
			case SLEEP:{
				this.sleep();
				break;
			}
			case WORK:{
				this.work();
				break;
			}
		}
	}

	public abstract void eat();
	public abstract void work();
	public abstract void sleep();
	
}

class Robot extends Action{
	public void eat(){
		System.out.println("机器人需要电");
	}
	public void sleep(){
	}
	public void work(){
		System.out.println("机器人进行无思想的工作");
	}



}
class Person extends Action{
	public void eat(){
		System.out.println("人需要食物");
	}
	public void sleep(){
		System.out.println("人需要睡觉");
	}
	public void work(){
		System.out.println("人进行有思想的工作");
	}

}

class pig extends Action{
	public void eat(){
		System.out.println("猪吃剩饭");
	}
	public void sleep(){
		System.out.println("猪倒地就睡");
	}
	public void work(){
	}

}

public class JavaDemo3{
	public static void main(String [] arg){
		Action robotAction = new Robot();
		Action personAction = new Person();
		Action pigAction = new pig();

		robotAction.commd(1);
	}
}