package zbj;

import java.lang.reflect.Field;

public class Refilection02 {
    public static void main(String[]args) throws Exception{
        f1();
    }
    public static void f1()throws Exception{
        //获取Class的四种方法

        Class<?> aClass = Class.forName("zbj.Cat");

        Class<Cat> catClass = Cat.class;

        Cat cat = new Cat();
        Class<? extends Cat> aClass1 = cat.getClass();

        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("zbj.Cat");

        //打印四个Class类的hashcode,判断是否相等
        System.out.println(aClass.hashCode());
        System.out.println(catClass.hashCode());
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        //Class类的常用方法
        Package aPackage = aClass.getPackage();//得到包名
        System.out.println(aPackage);
        String name = aClass.getName();//得到全类名
        System.out.println(name);
        Object o = aClass.newInstance();//创建对象实例
        System.out.println(o.getClass());
        Field name1 = aClass.getField("name");//获取属性
        System.out.println(name1.get(o));
        name1.set(o,"破财毛");//更改属性
        System.out.println(name1.get(o));
        Field[] fields = aClass.getFields();
        for(Field f: fields){
            System.out.println(f.get(o));
        }



    }
}
