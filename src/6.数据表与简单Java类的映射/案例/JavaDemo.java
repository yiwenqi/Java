class Dept {
	private long deptno ;  //���ű��
	private String dname;  //��������
	private String loc ;  //���ŵ�ַ
	private Emp emps [] ; //һ�������ж���쵼
	
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

	//ʡ��setter �� getter����  �޲ι���
	public String getinfo(){
		return ("��������Ϣ�����ű��: " +this.deptno+ "  , ��������: " +this.dname+ "  , ���ŵ�ַ: " +this.loc) ;
	}
}

class Emp{
	private long empno ;
	private String ename ;
	private String job ;
	private double sal ;
	private double comm ;
	//���ù����ֶ�
	private Dept dept ;  //��������
	private Emp mgr ;	//�����쵼
	
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
	
	//ʡ��setter �� getter����  �޲ι���
	public String getinfo(){
		return ("����Ա��Ϣ����Ա��ţ�" +this.empno+" , ��Ա������"+this.ename+" , ��Աְλ��"+this.job+"��Ա���ʣ�" +this.sal +" , Ӷ��"+this.comm) ;
	}
}

public class JavaDemo{
	public static void main(String args[] ){
		//��һ��: ���ݹ�ϵ���еĶ���
		Dept dept = new Dept(10 , "Java������λ" , "����"  ) ;
		Emp empA = new Emp(7892L, "Smte", "SDA",5000.00,8000.00) ;
		Emp empB= new Emp(7792L, "DEMD", "YUI",4500.00,7000.00) ;
		Emp empC = new Emp(7692L, "RTYU", "OTR",3000.00,6500.00) ;
		//����������й���
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
