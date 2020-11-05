# java —— （object -oriented ）
java面向对象学习--  前提：已有基础
    
    ·引用与垃圾产生分析 
            经过分析后确认，所有的引用传递的本质就是一场堆内存的调戏游戏。但是如果对于引用的传递如果处理
        不当也会造成垃圾的产生
    
            所谓的垃圾空间指的就是没有任何栈内存所指向的堆内存空间，所有的垃圾将被GC（Garbage Collector）垃
        圾回收器定期进行回收并且释放无用空间，但是如果垃圾过多，一定将影响GC的处理性能，进而降低整体的程
        序性能，那么在实际的开发中，垃圾的产生一定要越少越好， 


    ·成员属性封装
            在类之中的组成就是属性和方法，一般而言方法是对外提供服务的，所以不会进行封装处理，而对于属性由
        于其需要较高的安全性，所以往往需要对其进行保护，这个时候就需要采用属性封装对属性进行保护

        属性不封装之下的问题:
            class Person {
                String name ; //个人姓名
                int age ; //年龄
                public void tell (){
                    System.out.println("姓名" + name + ",年龄" + age) 
                }
            }

            public class JavaDemo {//主类
                public Static void main (String args[]){
                    Person per = new Person();
                    per.name = "张三" ;  //在类外部修改属性
                    per.age = -18 ;     //在类外部修改属性
                    per.tell() ;
                }

            }
                    此时在person 类中提供的name与gae 两个属性并没有进行封装处理，这样外部就可以直接调
                用了，但是有可能所设置的数据是错误的数据。如果想解决这样的问题就可以利用 private 关键字
                对属性进行封装。 

            eg: 对属性进行封装
                     （而一旦封装之后外部将不能直接访问，注: 对外部不可见，但是对类的内部是可见的，那么
                    如果要想让外部的程序可以访问封装的属性，则在java开发中提供有如下要求:
                    ·【setter 与 getter 】设置或取得属性

                ）
                class Person {
                    private String name ; //个人姓名
                    private int age ; //年龄
                    public void tell (){
                        System.out.println("姓名" + name + ",年龄" + age) 
                    }

                    //以下省略属性的setter与getter方法
                    ...
                    //可在setter与getter中进行检测，来达到保护属性的效果
                }

                public class JavaDemo {//主类
                    public Static void main (String args[]){
                        Person per = new Person();
                        per.name = "张三" ;  //在类外部修改属性
                        per.age = -18 ;     //在类外部修改属性
                        per.tell() ;
                    }

                }


    ·构造方法与匿名对象
        现在程序在使用类的时候一般都按照了如下的步骤进行:
            ·声明并实例化对象，这个时候实例化对象中的属性并没有任何数据存在。
            ·需要通过一系列的setter方法为类中的属性赋值
        等于现在想要获取一个正真可以使用的实例化对象，必须经过两个步骤
        范例:传统调用
              public class JavaDemo {//主类
                    public Static void main (String args[]){
                        //1.对象的初始化准备
                        Person per = new Person();
                        per.name = "张三" ;  //在类外部修改属性
                        per.age = -18 ;     //在类外部修改属性
                        //对象的使用
                        per.tell() ; //方法调用
                    }
                } 
                    但是如果按照这样的方式来进行思考的化就会出现问题:假设说现在类中的属性有很多个（8），那么
                按照我们之前的做法，就需要调用8次setter方法进行内容设置，这样的调用实在是太过于繁琐。所以java
                中为了解决这类问题,专门提供有构造方法，即:  **可以通过构造方法实现属性初始化处理。只有在关键字
                new的时候使用构造方法，在Java程序里面构造方法的定义要求如下
                    ·构造方法名称必须与类名保持一致;
                    ·构造方法不允许设置任何的返回值类型; 即: 没有返回定义；
                    ·构造方法是在使用new时自动定义的;
                        eg: 
                        class Person {
                            private String name ; //个人姓名
                            private int age ; //年龄
                            public void tell (){
                                System.out.println("姓名" + name + ",年龄" + age) 
                            }
                            //构造方法
                            public Person(String n ,int a){ //有参构造
                                name = n;
                                age = a;
                            }

                            //以下省略属性的setter与getter方法
                            ...
                        }
                对比之前的实例化格式:
                            我们能够发现，在我们没有定于构造方法时  new Person（）我们依然调用无参构造方法。
                        由此我们可以得知，当我们不定义构造参数时，Java为了保证程序的完整性，所有的类都
                        会提供构造方法，也就是说当我们不定义构造参数时，Java会自动为我们定义一个默认的
                        无参构造方法，这个构造方法时在程序编译的时候自动创建的。如果我们定义了构造方法，
                        那么这个默认的构造方法将不会自动创建


                疑问: 为什么构造方法上不允许设置返回值类型？
                    public Person(String n ,int a){}
                    public void Person(String n ,int a){} 
                        既然构造方法是一个方法，那为什么不让他定义返回类型。
                        既然构造方法不会返回数据为什么不使用void定义呢？
                    分析: 程序编译器是根据代码结构来进行编译处理的，执行的时候也是根据代码结构来处理的。

                        如果在构造方法上使用 void 那么此结构就与普通方法的构造完全相同了，这样编译器会认为他是一个
                    普通方法。
                            普通方法与构造方法最大的区别: 构造方法是在类实例化时候调用的，而普通方法实在类对
                        象实例化产生之后调用的。
                    既然构造方法 本身是一个方法，那么方法就具有重载的特点。

                    范例: （构造参数重载）
                        class Person {
                            private String name ; //个人姓名
                            private int age ; //年龄
                            //构造方法重载
                            public Person(){}
                            public void tell (){
                                System.out.println("姓名" + name + ",年龄" + age) 
                            }
                            //构造方法
                            public Person(String n ,int a){ //有参构造
                                name = n;
                                age = a;
                            }

                            //以下省略属性的setter与getter方法
                            ...
                        }

                        在进行多个构造方法定义的时候强烈建议大家有一些定义的 顺序
                         例如:可以按照参数个数定义顺序

                         经过分析之后可以发现，利用构造方法可以传递属性数据，于是进一步分析对象产生格式:
                                    ·定义对象的名称: 类名称 对象名称 = null ；
                                    ·实例化对象: 对象名称 = new 类名称()。
                            如果这个时候我们只是通过实例化对象来进行类的操作也是可以的，而这种形式的对象由于没
                         有名字，我们称之为 匿名对象

                         范例: (观察匿名对象)
                            public class JavaDemo {
                                public static void main (String args[]){
                                    new Person("张三" , 10).tell();
                                }
                            }

                                此时依然通过了对象进行类中tell（）方法的调用，但是由于此对象没有任何的
                            引用，所以该对象在使用一次之后就将成为垃圾，而所有的垃圾将被 GC 进行回收与释放


    ·this调用本类属性
            this可以算是Java里面比较复杂的关键字，因为this的使用形式上决定了它的灵活性，在程序中可以
        实现以下三类结构的描述
                ·当前类中的属性: this.属性;
                `当前类中的方法（普通方法，构造方法）: this(), this.方法名称()
                ·描述当前对象;

        使用 this 调用当前类属性
            public Person(String n ,int a){ //有参构造             
                    name = n;               
                    age = a;
            }

            此时n 和 a 代表不明确  我们想将其换成name 和 age 那么此时 当我们想要调用当前类的属性时 需要用this

             public Person(String name ,int age){ //有参构造             
                    this.name = name;               
                    this.age = age; 
            }

            使用this调用方法
                除了调用属性之外，this也可以实现方法的调用，但是对于方法的调用就必须考虑构造与普通方法。
                        ·构造方法调用 （this()）:使用关键字 new 实例化对象的时候才会调用构造方法；
                        ·普通方法调用（ this.方法名称() ）:实例化对象产生之后就可以调用普通方法。
                    范例: （普通方法调用）

                        public Person (String name,int age){
                            this.setName(name); //加上this为标准写法
                            setName(name); //加与不加都表示本类方法 
                        }
                    范例: （构造方法调用）  
                            假设现在类中一共有三个构造方法，但是要求不管调用那个方法，都必须，都执行一句
                        输出语句“一个新的Person类方法”

                    传统做法实现:   
                        class Person {
                            private String name ; //个人姓名
                            private int age ; //年龄
                            //构造方法重载
                            public Person(){
                              System.out.println("*** 一个新的Person类对象实例化了");
                            }
                            //构造方法重载
                            public Person(String name){
                              System.out.println("*** 一个新的Person类对象实例化了");
                            }
                            //构造方法重载
                            public Person(String name , int age){
                                
                              System.out.println("*** 一个新的Person类对象实例化了");
                            }
                            public void tell (){
                                System.out.println("姓名" + name + ",年龄" + age) 
                            }

                            //以下省略属性的setter与getter方法
                                ...
                        }

                        public classs JavaDemo {
                            public static void main (String args[]){
                                Person per = new Person("王五",18);
                                per.tell();
                            }
                        }

                    优化后的代码:
                        class Person {
                            private String name ; //个人姓名
                            private int age ; //年龄
                            //构造方法重载
                            public Person(){
                              System.out.println("*** 一个新的Person类对象实例化了");
                            }
                            //构造方法重载
                            public Person(String name){
                              this(); //调用无参
                              this.name = name;
                            }
                            //构造方法重载
                            public Person(String name , int age){ 
                             this.(name)  //调用单参构造方法
                             this.age = age;
                            }
                            public void tell (){
                                System.out.println("姓名" + name + ",年龄" + age) 
                            }

                            //以下省略属性的setter与getter方法
                                ...
                        }

                对于本类构造方法的互相调用需要注意以下几点重要问题: 
                        ·构造方法必须在实例化新对象的时候调用 ，所以 this() 语句必须放在构造方法
                     的首行（也就是说 this() 只能也只允许放在构造方法首行）

                        ·构造方法互相调用时请保留程序的出口,别形成死循环;
                            错误示例:
                            public Person(){
                                //出现了死循环
                                this("name",age);
                              System.out.println("*** 一个新的Person类对象实例化了");
                            }
                            public Person(String name){
                              this(); //调用无参
                              this.name = name;
                            }
                            public Person(String name , int age){ 
                             this.(name)  //调用单参构造方法
                             this.age = age;
                            }

                    在上述代码中当参数达到4个甚至更多时，我们将会存在更多的构造方法（单参，无参，
                两参，三参，...），在这些构造方法里会存在大量的赋值操作，而我们可以使用 this(); 
                进行代码的优化;在前期的学习中我们将更加注重如何去消除代码的重复性;

                        eg:（三参 name age sex）
                            public Person(){
                              this("无名氏", 18 , "男");
                            }
                            public Person(String name){
                              this(name,18,"男"); 
                              
                            }
                            public Person(String name , int age){ 
                             this.(name ,age ,"男");  
                            }
                            public Person(String name , int age ,String sex){ 
                             this.(name ,age , sex);   
                            }


                关于this的一个案例：详情请到 src 文件夹中寻找;（JavaDemo.java）
                        在以后进行项目开发的过程中，简单java类都将作为一个重要的组成部分存在，简单的来
                    说简单java类无处不在，并且有可能组成一系列变化。
                        所谓的简单java类就是描述一类信息的程序类: 描述一本书 ，描述一个人 ，一辆车;并且在
                    这个类中没有什么特别复杂的逻辑操作，只是作为一种信息存储的媒介存在;
                         对于简单java类而言，其核心的开发结构如下:
                            ·类名一定要有意义，可以明确的描述某一类事务
                            ·类之中的属性都必须使用private进行封装，同时封装后的属性必须有getter setter 方法
                            ·类之中可以提供无数构造方法，但是必须要保留无参构造方法；
                            ·类之中不允许出现任何输出语句，所有内容必须返回;
                            ·【非必须】可以提供一个获取对象详细信息的方法，命名为 getinfo()
                            
                            
        ·static关键字
                声明static是一个关键字，这个关键字组要用来生成属性和方法。

             ·static定义属性
	     	  在一个类中实际上所有的内容都交由各自的堆内存保存； 假设当我们已经产生了500w个对象 ，而我们想
		要修改其中所有对象的一个属性时，那么此时你面对的将是一场灾难！！因为对象实在是太多了！！
		那么此时最好的方法就是将该属性 设置为 （公共属性）如:static String country = "中华人民共和国";
		当你再次修改时，只需要修改一个对象的country那么所有的country值都会改变。

		  但时对于static属性的访问需要注意的一点是由于其本身是一个公共的属性，所以理论上虽然是可以通过
		对象进行访问，但是最好的方法还是通过  类名  进行访问: Person.country = "中华人民共和国";

			*static属性可以通过类名进行调用
				eg: Person person = new person();
				    Person.country = "";
			*同时static属性虽然在类中但是，其并不受类实例化对象的控制，也就是说static属性可以在实
			例化类之前使用;
				eg: //实例化类之前就可以使用
				    Person.country = "";
				    Person person = new person();

		static也可以进行方法定义,其的特点是可以直接由 类名称在实例化之前调用;

	    eg:
		 public static void setCountry(String c){
			country = c;
		 }
		注意: 
			·static 方法只允许调用 属性或 static方法；
			·非static方法允许调用 属性或 static方法；

		原因:所有的static定义的方法和属性可以在实例化之前使用，而所有的非static方法和属性必须实例化之后
		使用。

		static定义的方法和属性不是编写代码之初所需要考虑的，只有在需要回避实例化对象和使用公共属性的情况
		之下才会考虑使用static定义方法或属性。
		
		
		·代码块
		        
		            代码块分为以下三类:
		                ·普通代码块
		                ·构造代码块
		                ·静态代码块
		                
		             
            普通代码块用  {}  包裹，它主要用来进行一个方法中的分界，也就是说 使用 {} 会将代码进行分界使里面
            的变量等与外界进行分隔。防止相同的变量名称所带来的互相影响
            
            
            构造块: 定义在一个类之中，构造块会优先于普通方法执行，并且每一次实例化都会调用构造块中的方法
                eg:
                    clas Person{
                        public Person(){
                            System.out.println("【构造方法】Person类的构造方法被执行了");
                        }
                        {
                            System.out.println("【构造块】Person类构造块被执行了");
                         }
                    }
            静态代码块: 静态代码块主要是指使用static关键字定义的代码块，主要考虑两种情况:①主类中定义静态代码块
                        ②非主类定义静态块
                         eg:
                              clas Person{
                                    public Person(){
                                          System.out.println("【构造方法】Person类的构造方法被执行了");
                                    }
                                    static{
                                        System.out.println("【非主类静态代码块】");
                                    }
                                    {
                                          System.out.println("【构造块】Person类构造块被执行了");
                                     }
                               }
                         此时可以发现静态代码块会优先于构造块执行，并且不管实例化多少次，静态代码块都只会
                         执行一次静态代码块的主要目的是为类中的静态属性进行初始化;（如登录数据库的密码 驱动等）
                        
                        在主类中定义:
                            public class JavaDemo{
                                static{
                                System.out.println("主类中的静态代码块");
                                }
                                public static void main (String args[] ){
                                    System.out.println("---主类123456---");
                                }
                            }
                         通过执行可知: 静态代码块优先于主类方法执行
                         
            ·数组的基本使用
                    ·数组的动态初始化:
                            -声明并初始化对象: 数据类型  数组名称 [] = new 数据类型[数据长度]
                                               数据类型  [] 数组名称 = new 数据类型[数据长度]
                    ·数组的额静态初始化 : 在数组定义的时候就为其赋值
                            -简化格式 : 数据类型 数组名称 [] = {数据1，数据2 ，数据3.....，数据n}；
                            -完整格式:  数据类型 数组名称 [] = new 数据类型 []{数据1，数据2 ，数据3.....，数据n};
                            （建议使用完整格式进行定义）
                     范例:
                         public class ArrayDemo{
                                public static void main(String arg[]){
                                //使用动态数组初始化
                                    int data [] = new int[3];
                                    
                                }
                         }
                         
                      注: 数组长度可以用   数组名称.length  进行访问
            

                    ·数组引用传递
                         public class ArrayDemo{
                                  public static void main(String arg[]){
                                            //使用动态数组初始化
                                            int data [] = new int[] {1，2，4};  //静态初始化
                                            int temp [] = data;  //引用传递
                                            temp[0] = 99;
                                            for(int i; i < data.length; i++ ){
                                                   System.out.println(data[x]);
                                            }              
                                  }
                         }
                         
                         ·通过上述代码进行数组内存分析
                            数组本身依然是属于引用数据类型: 那么既然是引用数据类型，就一定会发生引用传递
                            引用传递应该还是按照传统的方式一样（与类与对象的传递一模一样）: 一个堆内存可
                            以被多个栈内存所指向
                            
                            上述代码执行后可发现: 当temp语句执行后，data所指向的 堆内存数组的值也改变了，
                            所以他和我们正常的引用过程是一样的。
                            
                            由于数组属于引用类型，所以一定要为其开辟堆内存空间之后才能使用， 当我们没有为
                            其指定堆内存使用数组时，会报一个 NullPointException (空指针异常)的异常，所以必须
                            要提供实例化对象才可以使用数组的操作。
                                
                                
                    ·foreach迭代输出
                        传统做法:
                            public class ArrayDemo{
                                public static void main(String arg[]) {
                                    int data [] = new int []{1,2,3,4,5};
                                    for(int i ; i < data.length ; i++){
                                        System.out.println(data[i]);
                                    }
                                } 
                                
                        JDK1.5以后为了防止下标对程序的影响（如果下标处理不当会产生越界的异常） ，所以参考了NET
                        中的设计引用了一个增强 for 循环（foreach），利用foreach可以自动获取数组中的每一个元素
                        进行访问，避免下标处访问
                        
                        格式: for(数据类型 变量 : 数组 | 集合){}
                                最大的特点是将数组中的每一个元素取出保存在变量里面，这样就可以直接通过变量访问
                                public class ArrayDemo{
                                    public static void main(String args[]){
                                        int data [] = new int [] {1,2,3,4,5};
                                        for(int temp : data){
                                            System.out.println(temp);
                                        }
                                    }
                                }
                            这样的最大的好处就是没有下标的使用;
                            
                            
            ·二维数组
                    对于二维数组可以使用以下语法定义:
                        ·数组的动态定义:
                                -数据类型 数组名称 [][] = new 数据类型 [行个数][列个数];
                        ·数组的静态初始化:
                                -数据类型 数组名称 [][] = new 数据类型[][] {{数据1,数据2,....},{数据1,数据2,....}..} 
                            
                         
                    那么如何使用foreach来进行二维数组遍历呢?
                            public class ArrayDemo{
                                    public static void main(String args[]){
                                             int data [] = new int [] {
                                             {1,2,3},{4,5,6},{1,2,3}
                                                    };
                                             for(int temp[] : data){
                                                for(int num : temp){
                                                    System.out.println(temp);
                                                }
                                             }
                                     }
                            }
        ·数组的引用传递
                public class ArrayDemo{
                    int data [] = initArray();  //通过方法返回一个数组
                    printArry(data);  //传递数组
                    public static int [] initArray(){
                        int arr [] = new int []{1,2,3,4,5,6};
                        return arr ;
                    }
                    //要求接收一个int型的数组
                    public static void printArray(int temp[]){
                          for(int i; i < temp.length; i++){
                            System.out.println(temp[i]);
                          }
                    }
                }
                
        ·数组的相关操作方法
                即Java语言本身提供的相关支持原理;
                    1. 数组排序: java.util.Array.sort(数组名称)。
                    
                    
        ·方法的可变参数
                如果说现在要求定义一个方法，这个方法可以实现任意多个整型数据相加处理。
                    public static int sum (int ... data){//变种参数
                        
                    }
                    ArrayUtil.sum(1,2,3); //实现多参传入
                    
                    可变参数最大的作业在于，在以后进行一些程序类设计或者开发调用的时候，利用可变此种
                    形式就可以避免数组的传递操作。
                    但我们要清楚可变参数的本质依然是：数组
                    
        ·对象数组
            在之前所接触到的都是基本数据类型定义的数组，但是在Java程序本身各类数据类型都可以成为数组，
            所以类也可以成为数组类型，对象数组的格式如下:
                ·动态初始化: 类 对象数组名称 [] = new 类 [长度]，每一个元素都是null；
                ·静态初始化: 类 对象数组名称 [] = new 类 [长度]，{实例化对象，实例化对象，...}；
                使用动态初始化定义对象数组
                    Person per [] = new Person[3]  //此数组中的对象都是null,因为未给其指定堆内存
                    per[0] = new Person("01",02);
                    
                    





