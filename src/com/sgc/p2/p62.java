package com.sgc.p2;

import java.util.ArrayList;
import java.util.Collections;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
// 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
// 那么中位数就是所有数值排序之后中间两个数的平均值。
// 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
public class p62 {
    ArrayList<Double> arrayList = new ArrayList<>();
    public void Insert(Integer num) {
        arrayList.add((double)num);
        Collections.sort(arrayList);
    }

    public Double GetMedian() {
        if(arrayList.size()%2==0){
            return (arrayList.get(arrayList.size()/2)+arrayList.get(arrayList.size()/2-1))/2;
        }else{
            return arrayList.get(arrayList.size()/2);
        }
    }
}
