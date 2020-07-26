package Week07.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 朋友圈 并查集
 *
 * @author leichunhong
 * @create 2020-07-23
 * @since 1.0.0
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    /**
     * @param
     * @auther leichunhong
     * @desc 模板
     * @date 2020-07-23 23:01
     * @return
     */
    class UnionFind {
        int[] path;
        int count;

        /**
         * @param
         * @return
         * @auther leichunhong
         * @desc 自我赋值：path[i] = i; 并且 让count=n;
         * @date 2020-07-23 23:02
         */
        public UnionFind(int n) {
            path = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                path[i] = i;
            }
        }

        public int find(int i) {
            while (i != path[i]) {
                i = path[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) return;
            path[rootI] = rootJ;
            count--;
        }

        public int count() {
            return count;
        }
    }


    /**
     * @param
     * @auther leichunhong
     * @desc 照着打一遍
     * @date 2020-07-23 23:05
     * @return
     */
    class UnionFindI {
        int[] path;
        int count;

        /**
         * @param
         * @return
         * @auther leichunhong
         * @desc 自我赋值：path[i] = i; 并且 让count=n;
         * @date 2020-07-23 23:02
         */
        public UnionFindI(int n) {
            path = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                path[i] = i;
            }

        }

        /**
         * @param
         * @return int
         * @auther leichunhong
         * @desc 查找
         * @date 2020-07-23 23:06
         */
        public int findI(int i) {
            //当i！=path[i] 把 path[i]赋值给i 返回i
            while (i != path[i]) {
                i = path[i];
            }
            return i;
        }

        /**
         * @param
         * @return void
         * @auther leichunhong
         * @desc 合并
         * @date 2020-07-23 23:08
         */
        public void union(int i, int j) {
            int rootI = findI(i);
            int rootJ = findI(j);
            if (rootI == rootJ) {
                return;
            }
            path[rootI] = rootJ;
            count--;
        }

        public int count() {
            return count;

        }
    }

    public static void main(String[] args) {
        System.out.println(10>>1);
        System.out.println(10<<1);
    }

}
