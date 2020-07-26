package Week01.leichunhong.test;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-06-29
 * @since 1.0.0
 */
public class SingletonSys {
    private static volatile SingletonSys singletonSys = null;

    private SingletonSys() {
    }

    public static SingletonSys getSingletonSys() {
        //double check
        if (singletonSys == null) {

            synchronized (SingletonSys.class) {
                if (singletonSys == null) {
                    singletonSys = new SingletonSys();
                }
            }
        }
        return singletonSys;

    }

}
