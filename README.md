# java —— （object -oriented ）
java面向对象学习--  前提：已有基础
    ·引用与垃圾产生分析 
        经过分析后确认，所有的引用传递的本质就是一场堆内存的调戏游戏。但是如果对于引用的传递如果处理不当也会造成垃圾的产生

        所谓的垃圾空间指的就是没有任何栈内存所指向的堆内存空间，所有的垃圾将被GC（Garbage Collector）垃圾回收器定期进行回收并且释放无用空间，但是如果垃圾过多，一定将影响GC的处理性能，进而降低整体的程序性能，那么在实际的开发中，垃圾的产生一定要越少越好， 


    ·成员属性封装
        在类之中的组成就是属性和方法，一般而言方法是对外提供服务的，所以不会进行封装处理，而对于属性由于其需要较高的安全性，所以往往需要对其进行保护，这个时候就需要采用属性封装对属性进行保护

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
            此时在person 类中提供的name与gae 两个属性并没有进行封装处理，这样外部就可以直接调用了，但是有可能所设置的数据是错误的数据。如果想解决这样的问题就可以利用 private 关键字对属性进行封装。 

            eg: 对属性进行封装
                （而一旦封装之后外部将不能直接访问，注: 对外部不可见，但是对类的内部是可见的，那么如果要想让外部的程序可以访问封装的属性，则在java开发中提供有如下要求:
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
                但是如果按照这样的方式来进行思考的化就会出现问题:假设说现在类中的属性有很多个（8），那么按照我们之前的做法，就需要调用8次setter方法进行内容设置，这样的调用实在是太过于繁琐。所以java中为了解决这类问题,专门提供有构造方法，即:  **可以通过构造方法实现属性初始化处理。只有在关键字new的时候使用构造方法，在Java程序里面构造方法的定义要求如下
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
                    我们能够发现，在我们没有定于构造方法时  new Person（）我们依然调用无参构造方法。由此我们可以得知，当我们不定义构造参数时，Java为了保证程序的完整性，所有的类都会提供构造方法，也就是说当我们不定义构造参数时，Java会自动为我们定义一个默认的无参构造方法，这个构造方法时在程序编译的时候自动创建的。如果我们定义了构造方法，那么这个默认的构造方法将不会自动创建

                疑问: 为什么构造方法上不允许设置返回值类型？
                    public Person(String n ,int a){}
                    public void Person(String n ,int a){} 
                        既然构造方法是一个方法，那为什么不让他定义返回类型。
                        既然构造方法不会返回数据为什么不使用void定义呢？
                    分析: 程序编译器是根据代码结构来进行编译处理的，执行的时候也是根据代码结构来处理的。

                    如果在构造方法上使用 void 那么此结构就与普通方法的构造完全相同了，这样编译器会认为他是一个普通方法。
                        普通方法与构造方法最大的区别: 构造方法是在类实例化时候调用的，而普通方法实在类对象实例化产生之后调用的。
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
                         如果这个时候我们只是通过实例化对象来进行类的操作也是可以的，而这种形式的对象由于没有名字，我们称之为 匿名对象

                         范例: (观察匿名对象)
                            public class JavaDemo {
                                public static void main (String args[]){
                                    new Person("张三" , 10).tell();
                                }
                            }

                            此时依然通过了对象进行类中tell（）方法的调用，但是由于此对象没有任何的引用，所以该对象在使用一次之后就将成为垃圾，而所有的垃圾将被 GC 进行回收与释放


    ·this调用本类属性
        this可以算是Java里面比较复杂的关键字，因为this的使用形式上决定了它的灵活性，在程序中可以实现以下三类结构的描述
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
                    范例: 
            













