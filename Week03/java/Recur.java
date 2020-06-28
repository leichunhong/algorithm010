package Week03.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-06-23
 * @since 1.0.0
 */
public class Recur {

    private static int Max_LEVEL;

    public static void main(String[] args) {
        int level = 0;
        int parm = 0;
        recur(level, parm);
    }

    private static void recur(int level, int parm) {
        //terminator teminator
        if (level > Max_LEVEL) {
            return;
        }
        //process current logic
        process(level,parm);
        //drill down
        recur(level+1,parm+1);
        //restore current status

    }
     /**
     * @auther  leichunhong
     * @desc 处理逻辑
     * @date  2020-06-23 09:44
     * @param  [level, parm]
     * @return  void
     */
    private static void process(int level, int parm) {
    }

}
