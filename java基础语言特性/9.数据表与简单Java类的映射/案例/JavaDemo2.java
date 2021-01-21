class Member {
	private String mid ; 
	private String name ;	
	private Role role ;

	public void setRole(Role role ){
		this.role = role ;
	}
	public Role getRole(){
		return this.role ;
	}
	public Member(String mid , String name){
		this.name = name ;
		this.mid = mid ;
	}
	public getInfo(){
		return ("【用户信息】id: "+this.mid+" ， 用户名："+this.name);
	}
}
class Role{
	private long rid ;
	private String title ;	
	private Member members []; 
	private Privilege privileges []; 
	public void setMember(Member  members []){
		this.member = member ; 
	}
	public Member [] getMembers(){
		return this.members = members ;	
	}
	public Role (long rid , String title){
		this.rid = rid ;
		this.title = title ;
	}
	public void setPrivilege(Privilege privileges []){
		this.privileges = privileges ;
	}
	
	public Privilege [] getPrivileges(){
		return this.privileges;
	}
	public getInfo(){
		return ("【角色信息】角色id: "+this.rid+" , title :" +this.title);
	}
}
class Privlege{
	private long pid ;
	private String  title ;	
	private Role role ;
	
	public Privilege (long pid ,String title ){
		this.pid = pid ;
		this.title =title ;
	}

	public void setRole (Role role ){
		this.role = role ;
	}
	public Role getRole (){
		return this.role ;
	}
	public String getInfo(){
		return ("【权限信息】权限id: "+this.pid+" , title :" +this.title);
	}
}

public class JavaDemo{
	public static void main(String args[]){
		 Member memA = new Member (10 ,"壹号") ;
		Member menB = new Member (20 ,"贰号") ;
		Member memC =new Member (30, "叁号") ;
		Role roleA = new Role (1L ,"系统服务") ;
		Role roleB = new Role (2L ,"备份服务") ;
		Role roleC = new Role (3L ,"人事服务") ;
		Privilege priA =new Privilege (100L,"系统初始化");
		Privilege priB =new Privilege (200L,"系统还原初始化");
		Privilege priC =new Privilege (300L,"系统备份初始化");
		Privilege priD =new Privilege (400L,"系统公文初始化");
		Privilege priE =new Privilege (500L,"系统论文初始化");
		Privilege priF =new Privilege (600L,"增加初始化");	
		
		roleA.setPrivilege(new Privilege [] {priA ,priB });
		roleB.setPrivilege(new Privilege [] {priC ,priD });
		roleC.setPrivilege(new Privilege [] {priE ,priF });
			
		priA.setRole(roleA) ;	
		priB.setRole(roleA) ;
		priC.setRole(roleB) ;
		priD.setRole(roleB) ;
		priE.setRole(roleC) ;
		priF.setRole(roleC) ;

		memA.setRoles(new Role [] {roleA,roleB});
		memB.setRole(new Role [] {roleB,roleC});
		memC.setrole(new Role [] {roleC,roleA
		
		roleA.setMember(new Member [] { memA ,memB}) ;
		roleB.setMember(new Member [] { memB ,memC}) ;
		roleC.setMember(new Member [] { memC ,memA}) ;

		System.out.println("----------通过用户查询信息 -----------");
		System.out.println(roleB.getInfo());
		for(int x = 0; x < memB.getRole().length ; x ++);
			System.out.println("\t-"+memB.getRoles()[x].getInfo());
			for(int y =0; y < memB.getRole().length ; y++) {
				System.out.println("\t\t-" +memB.getRoles()[x].getPrivileges()[y].getInfo());
			}
		
})



	}
}