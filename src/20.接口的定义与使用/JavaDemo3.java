
//由于类名称与接口名称的定义要求相同，往往我们会在接口名称前面加一个I
interface IMessage{
	public static final String INFO="www.gsdx.com";
	public abstract String getInfo (); //抽象方法
}
interface IChannel{
	public abstract boolean connect();
}
abstract class DatabaseAbstract {
	public abstract  boolean getDatabaseConnection();
}

class MessageImpl extends DatabaseAbstract implements IMessage,IChannel{
	public String getInfo(){
		if(this.connect()){
			if (this.DatabaseAbstract) {
				return "得到一个消息";
			}
			else{
				return "数据库连接失败";
			}
		}
		else{
			return "获取失败";
		}
	}

	public boolean connect(){
		System.out.println("通道已经建立");
		return true;
	}

	public  boolean getDatabaseConnection(){
		return false;
	}
}

public class JavaDemo2 {
	public static void main(String [] args){
		IMessage msg = new MessageImpl();
		Object obj = msg ; //向上转型
		IChannel chl = (IChannel)obj;
		System.out.println(chl.connect());
	}
}