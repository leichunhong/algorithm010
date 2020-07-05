package Week04.java;

/**
 * 〈功能简述〉<br>
 * 〈〉860. 柠檬水找零
 *   步骤：1.主要是思路问题，定义变量five 和ten 代表钱，有人来就++或者--代表钱数的张数，因为20的来多少都没用找不开不计算
 *        2.当来5元是 five++
 *        3.当来十元时：five--，ten++
 *        4.来二十元时，不加只算five个ten的消耗 ten>0和没有ten元的减少方式
 *        5.最后判断five的张数如果five<0 就是false 不能等于0 等于0可能刚好找完！
 *
 * @author leichunhong
 * @create 2020-07-02
 * @since 1.0.0
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;
        for (int i : bills) {
            if(i==5){
                five++;

            }else if(i==10){
                five--;
                ten++;
            }else if(i==20){
                if(ten>0){
                    ten--;
                    five--;
                }else{
                    five-=3;
                }

            }
            //为啥是小于0 就说把所有5块都找出去了但是没有下次人来买了也是对的
            if(five<0){
                return false;
            }

        }
        return true;
    }




}



