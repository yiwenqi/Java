class Color {
	private static final Color colorA = new Color("绿色");
	private static final Color colorB = new Color("蓝色");
	private static final Color colorC = new Color("红色");
	private String title ;
	private Color(String title) {
		this.title = title;
	} 
	public static Color getIntance(String color){
		switch(color){
			case "绿色" : return colorA;
			case "蓝色" : return colorB;
			case "红色" : return colorC;
			default: return null;
		}
	}
}


public class JavaDemo2{
	public static void main(String[] args) {
		Color colorA = Color.getIntance("绿色");
		Color colorB = Color.getIntance("红色");
	}
}