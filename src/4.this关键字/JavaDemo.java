class Dept {
    private int deptno;
    private String name;
    private String loc;


    public Dept(){};

    public Dept(int deptno,String name,String loc){
        this.deptno = deptno;
        this.loc = loc;
        this.name = name;
    }

    public String getinfo(){
        return ("deptno: "  + this.deptno + " ,name:  "+ this.name+"  ,loc:  "+ this.loc);
    }

    public void setDeptno(int deptno ){
        this.deptno =deptno;
    }

    public long getDepton (){
        return this.deptno;
    }

    public void setName (String name ){
        this.name = name;
    }

    public String getName(){
        return  this.name;
    }

    public void setLoc(String loc){
        this.loc = loc;
    }

    public String getLoc(){
        return this.loc;
    }

}

public class JavaDemo{
    public static void main(String[] args){
        Dept dept = new Dept(20,"wangwu","beijing");
        System.out.printf(dept.getinfo());
    }
}