package Week01.leichunhong.test;

/**
 * 〈功能简述〉<br>
 * 〈〉 单线程 单例
 *
 * @author leichunhong
 * @create 2020-06-29
 * @since 1.0.0
 */
public class Singleton {
    private  static  Singleton singleton;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton==null){

            singleton= new Singleton();
        }
        return singleton;
    }
}
