package Week08.java;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-08-01
 * @since 1.0.0
 */
public class Sort {
    /**
     * @param
     * @return void
     * @auther leichunhong
     * @desc 快速排序
     * 1.从数列中挑出一个元素，称为 “基准”（pivot）
     * 2.重新对数组排序把小于pivot放到pivot的左边，大于pivot放到右边。
     * 3.递归去排左边和右边
     * @date 2020-08-01 13:14
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        //找基准点
        int pivot = partition(array, begin, end);
        //递归排左边的
        quickSort(array, begin, pivot - 1);
        //递归排右边的
        quickSort(array, pivot + 1, end);

    }

    private static int partition(int[] array, int begin, int end) {

        // pivot: 标杆位置,counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        //交换array[counter]和array[i]
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }


        }
        //交换array[counter]和array[pivot]
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;

    }


    //--------->>>>>>归并排序----------->>>>>>>>

    /**
     * @param
     * @return void
     * @auther leichunhong
     * @desc 1.把长度为n的输入序列分成两个长度为n/2的子序列；
     * 2.对这两个子序列分别采用归并排序；
     * 3.将两个排序好的子序列合并成一个最终的排序序列。
     * @date 2020-08-01 15:59
     */
    public static void mergeSort(int[] array, int left, int right) {

        if (right <= left) {
            return;
        }
        //右移相当于/2^1
        int mid = left + ((right - left) >> 1);
        //左
        mergeSort(array, left, mid);
        //右
        mergeSort(array, mid + 1, right);

        merge(array, left, mid, right);

    }


    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        //合并1
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];

        }
        //合并2
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        //合并3
        while (j <= right) {

            temp[k++] = array[j++];
        }
        for (int n = 0; n < temp.length; n++) {
            array[left + n] = temp[n];

        }
        System.out.println(Arrays.toString(array));

    }



    //--------->>>>>>堆排序----------->>>>>>>>
    /**
    * @auther  leichunhong
    * @desc 需要搞懂这个代码不会
    * @date  2020-08-02 12:41  
    * @param
    * @return  void
    */
    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
            heapify(array, length, largest);
        }
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2-1; i >= 0; i--)
            heapify(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            heapify(array, i, 0);
        }
    }



    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        mergeSort(arrays, 0, arrays.length - 1);
    }


}
