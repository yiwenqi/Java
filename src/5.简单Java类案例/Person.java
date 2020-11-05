class Person{
	private String name;
	private String sex;
	private int age;
	
	public Person(String name,String){
		
	}
	public String getInfo(String name,String sex,int age){
		System.out.println("姓名: "+name+" ,年龄: "+age+" ,性别:"+sex);
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	public void setAge(int age ){
		this.age =age ;
	}
	public int getAge(){
		return this.age;
	}

}