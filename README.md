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
                    
    ·引用传递实际应用
                
         ·类关联结构
         
             class Car{
                private Person person;
             }
             class  Person{
                private Car car;
             }
         
         ·自身关联
            class Person {
                private Person Children [] ;
            }
            public class ArrayDemo{
                 public static void main(String args[]){
                    Person person = new Person("王五",18);
                    Person childA = new Person("child",17);
                    Person childB = new Person("child",17); 
                    childA.setCar(new Car ("BMW"))
                    
                    person.setChildren(new Person [] {childB,childA,...})
                    System.out.println(person.getChild().get );
                  }
            }
         ·合成设计模式
                人类的任何产品都可以进行拆分，而后进行重新组合，所以这样的设计在java中被称为合成设计模式
                例如电脑:可以拆分为许多部件，而后将这些部件设计为一个个的类，在进行各类组合可以组成一个电脑或电脑中
                的某个模块
                
                
    ·数据表与简单Java类映射转换
            ·在java的开发中简单Java类中的属性都与数据库中的数据相映射，由数据库的结构来实现简单java类
            程序类的定义实际上和这些实体类的差别并不大，所以在实际的开发中数据表与简单Java类的关系如下:
                    ·数据表实体的设计就等于类的定义
                    ·表中的字段  = 类的成员属性
                    ·表的外键关联  = 类的引用关联
                    ·表中的一行数据 = 类的实例化
                    ·表的多行数据  = 对象数组
                    
            在以后的实际开发项目中一定是分为以下两个步骤实现:
                    ·第一步: 根据表的结构关系进行对象配置;
                    ·第二步: 根据要求通过结构获取数据;
                    
                    eg:
                    public
                    
    · 一对多的映射关系
    ·多对多映射
    ·复杂多对多映射
    
    ·String 比较
           “ == ”：进行的数值上的比较，当用于对象时比较的是两个内存地址的数值比较 ;
           “equals():”是提供的比较方法，可以直接判断字符串内容 ;
           
    ·字符串常量是String类的匿名对象
            任何使用 "" 定义的String 类都是一个String类的匿名对象
            eg: 
                String str = "Str";
                    str是一个引用名字；
            关于对象相等判断的小技巧:
                在以后的开发中，如果某些时候数据是由用户输入，并且要求这些数据为一个指定内容的情况下建议将字符串的一个
                常量写在前面；
                    eg:
                        当用户不进行输入时
                        String str = null ;
                        此时进行判断
                            str.equals("mld");
                        会出现空指针异常
                            而如果将常量放前面则可以避免这样的情况
                            "mld".equals(str);
                            equals()方法里面有一个自动回避空的判断，那么如果将字符串变量放前面则可以自动避免用户输入为空
                            的情况。
                            
    ·String 类的两种实例化的区别；
            1、分析直接赋值的对象实例化模式
                在程序中只需要将一个字符串赋值给String 类对象就可以实现对象的实例化处理
                        String str = "mld";
                        这种情况下肯定是只会开辟一块堆内存空间;
                        除了这种内存模式以外，利用直接赋值实例化String 对象还可以实现同一个字符串对象数据的共享操作
                        
                        范例:
                             String strA = "mld";
                             String strB = "mld";       
                            System.out.println(strA == strB);  //比较的是两个引用名称的地址空间
                            此时strB 是不会开辟新的内存空间 也就是说 strA == strB 为true；
                            出现这样的原因主要是因为在Java程序底层中提供一个专门的字符串池（字符串数组）
                            当我们想要创建 strB 所指向的字符串内容 的时候会先到字符串池 中进行查找如果有会直接指向字符串
                            池中的地址，所strA 与 strB 所指向的地址相同  因此strB == strA
                            

    ·分析构造方法实例化
                构造方法进行对象实例化可以说是在进行对象定义时的一种常见方法，因此Java中也提供String 类的构造方法实例化
              的方法
                    String str  = new String( "mld" );
                    此时  "mld" 匿名对象会创建一个堆空间 ，而new 也会创建一个堆空间 ，str 指向的便时new 关键字创建的空间
                    由此可见 使用 new 构造方法进行 对象的实例化会导致 "mld" 匿名对象创建一个垃圾空间（浪费空间）
                    
                范例: 更换一种形式
                    String strA = "mld" ;
                    String strB = new String( "mld" );
                    
                    这样在 strB 中的 匿名对象创建堆空间时 会先在Java字符串池中进行查找。
                    而构造方法 new 关键实例化对象时不会出现自动保存到字符串池中的处理。
                    
                    String strA = "mld" ;
                    String strB = new String( "mld" );
                    System.out.println(strA == strB);  //false;
                    可以发现构造方法实例化对象时会开辟一个专属的空间，而不会保存到字符串池中，但是Java中有帮助开发中手动
                    入池的方法: public String intern() ;
                        eg: 
                         String strA = "mld" ;      
                         String strB = new String( "mld" ).intern();                   
                         System.out.println(strA == strB);  //true;
                         
    ·请解释String 类两种对象实例化方式的区别？
            ·直接赋值: 只会产生一个实例化对象，并且可以自动保存到字符串池当中，以实现该字符串实例的重用
            ·构造方法：会产生两个实例化对象，并且不会自动入池，无法实现对象重用，但是可以使用intern（）方法进行手动入池
            
    ·String对象（常量）池
            对象池的主要目地时实现数据共享处理。以String 对象池为例，里面的内容主要是为了重用，而重用实际上就属于共享设
            计，但是在Java中对象（常量）池实际上分为两种:
                ·静态常量池：指的时程序（*.class） 在加载的时候会自动将此程序中保存的字符串、普通的常量、类和方法的信息
                等待全部进行分配；
                ·运行时常量池: 当一个程序（*.class） 加载之后，里面可能会有一些变量，这个时候提供的一个常量池我们管他叫
                运行时常量池；
                
                范例:（静态常量池）
                    public class StringDemo {
                        public static void main(String args[]){
                            String strA = "www.mld.cn";
                            String strB = "www." + "mld" +".cn";
                            System.out.println(strA == strB);  //true
                        }
                    }
                     本程序中所给出的内容全部都是静态常量数据（字符串的常量都是匿名对象），所以最终在程序加载的时候会自
                     动帮助开发者处理好相应的连接；
                     
                范例:(运行时常量池)
                    public class StringDemo {
                         public static void main(String args[]){
                              String info = "mld";
                              String strA = "www.mld.cn";
                              String strB = "www." + info +".cn";
                              System.out.println(strA == strB);  //false;
                         }
                    }
                        这个时候之所以是一个false ， 是因为程序在加载的时候不确定info 是什么内容。因为我们在字符串连接的
                        时候info 采用的是一个变量。那么变量的内容是可以修改的 ，所以他不认为最终strB 的最终结果就是一个
                        所需要的最终的结果。所以 strB 存在运行时常量池中  因此在这个范例中strB != strA
    ·字符串内容不可修改  
        在String类之中包含的是一个数组，而数组最大的一个缺点就是长度不可改变。也就是说我们设置了一个字符串之后，会自动
        进行一个数组空间的开辟，开辟的内容长度是固定的。
            范例:
                 public class StringDemo{
                    public static void main(String args[]){
                        String str = "www.";
                        str += "mld";
                        str += ".cn";
                        System.out.println(str); 
                    }
                 }
                分析以上案例：
                    首先我们创建了一个堆空间 "www." ,而在 str += "mld" 时 会先创建一个 "mld" 的新空间，但新空间并不是我
                    们所需要的，我们需要的是"www.mld" 因此会再创建一个 "www.mld" 的新空间，此时str 指向改变，指向了新的
                    空间 "www.mld" ,而后面的 str += ".cn"; 和前面的也是一样的;
                    
                    通过上面的分析我们可以知道，字符串常量的内容并没有发生任何改变，改变的只是一个String类对象的引用，
                    并且这样的引用会带来大量的垃圾空间;
                    
                    分析下面的程序:
                    public class StringDemo{
                        public static void main(String args[]){
                            String str ="www.";
                            for(int x = 0; x < 1000 ; x ++){
                                str += x;
                            }
                        }
                    }
                    像这样的程序如果真的执行的,那么将会产生 1000 多个垃圾空间，并且String 对象的指向会修改 1000多次，
                    所以再以后的开发中， 我们应该尽量避免修改字符串
                    
                    
    ·Java中的主方法
        Java中的主方法组成是非常复杂的，并且单词也很多: public static void main(String args[])
            ·public :  描述的是一种访问权限，主方法是一切的开始点，一定是公共的；
            ·static :   程序的执行是通过类名称完成的，所以表示此方法是由类直接调用;
            ·void :     主方法是一切的起点，一旦开始就没有返回的可能，所以是void；
            · main :    是一个系统定义好的方法名称；
            ·String args[] : 字符串的数组，可以实现程序启动参数的接收。
            
            范例:(输出启动参数)
                public class StringDemo{
                    public static void main(String args[]){
                        for(String arg : args){
                            system.out.println(arg);
                        }
                    }
                }
            在程序执行的时候可以设置参数，每一个参数之间使用空格分隔;
                    javac StringDemo.java
                    java StringDemo first second 
               此时就会输出
               first
               second
                  
                    java StringDemo "first second" "hello world"
               此时就会输出
               first second 
               hello world  
             以后可以通过这种启动参数实现数据输入的的模拟。
             
    ·String 类常用方法
        
        2、具体内容
            在实际的项目开发过程中，只要是我们的项目就一定会存在String类的定义。所以掌握String类的常用开发方法对于我们
            开发责者是非常重要的。
            
            JavaDoc简介  
                在以后进行开发的过程中肯定要大量的使用Java的Api文档（JavDoc）
                这个文档可以通过oracle在线浏览https://docs.oracle.com/javase/9/docs/api/overview-summary.html
                
                
                在JDK 1.9之前，所有的Java中的常用类库都会在JVM启动的时候进行全部的加载，这样会影响性能，而在1.9以后开始
                提供有模块化的设计，将一些程序放在不同的模块
                
                
                在模块中包含大量的程序开发包，而如果想去看String 类的相关定义，则可以通过打开java.long这个包
                    
                
                