class Dept {
	private long deptno ;  //部门编号
	private String dname;  //部门名称
	private String loc ;  //部门地址
	private Emp emps [] ; //一个部门有多个领导
	
	public void setEmps(Emp [] emps ){
		this.emps = emps ;
	}

	public Emp [] getEmps(){
		return this.emps ;
	}
	
	public Dept(long depton ,String dname  , String loc){
		this.deptno = deptno ;
		this.dname = dname ;
		this.loc = loc ;   
	}

	//省略setter ， getter方法  无参构造
	public String getinfo(){
		return ("【部门信息】部门编号: " +this.deptno+ "  , 部门名称: " +this.dname+ "  , 部门地址: " +this.loc) ;
	}
}

class Emp{
	private long empno ;
	private String ename ;
	private String job ;
	private double sal ;
	private double comm ;
	//配置关联字段
	private Dept dept ;  //所属部门
	private Emp mgr ;	//所属领导
	
	public void setDept(Dept dept){
		this.dept = dept ;
	}
	public void setMgr(Emp mgr){
		this.mgr  = mgr ;
	}

	public Dept getDept(){
		return this.dept ;
	}
	public Emp getMgr(){
		return this.mgr ;
	}

	public Emp(long empno , String ename , String job , double sal , double comm ){
		this.empno = empno;
		this.ename = ename;
		this.job = job ;
		this.sal =sal ;
		this.comm = comm ; 
	}
	
	//省略setter ， getter方法  无参构造
	public String getinfo(){
		return ("【雇员信息】雇员编号：" +this.empno+" , 雇员姓名："+this.ename+" , 雇员职位："+this.job+"雇员工资：" +this.sal +" , 佣金："+this.comm) ;
	}
}

public class JavaDemo{
	public static void main(String args[] ){
		//第一步: 根据关系进行的定义
		Dept dept = new Dept(10 , "Java开发岗位" , "北京"  ) ;
		Emp empA = new Emp(7892L, "Smte", "SDA",5000.00,8000.00) ;
		Emp empB= new Emp(7792L, "DEMD", "YUI",4500.00,7000.00) ;
		Emp empC = new Emp(7692L, "RTYU", "OTR",3000.00,6500.00) ;
		//根据需求进行关联
		empA.setDept(dept)  ;
		empB.setDept(dept)  ;
		empC.setDept(dept) ;
		empA.setMgr(empB) ;
		empB.setMgr(empC) ;
		dept.setEmps(new Emp [] {empA , empB , empC} ) ; 
		for(int i = 0; i< 3 ; i++) {
			System.out.println("\t-" + dept.getEmps()[i].getinfo() );
		}
	}
}
