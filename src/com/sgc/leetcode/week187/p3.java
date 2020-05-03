package com.sgc.leetcode.week187;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
//
//如果不存在满足条件的子数组，则返回 0 。
//示例 1：
//
//输入：nums = [8,2,4,7], limit = 4
//输出：2
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4.
//因此，满足题意的最长子数组的长度为 2 。
//示例 2：
//
//输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
//示例 3：
//
//输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
//
//
//提示：
//
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9
//0 <= limit <= 10^9
public class p3 {

    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        int[] nums1 = {10,1,2,4,7,2};
        int[] nums2 = {4,2,2,2,4,4,2,2};
        int[] nums3 = {4,8,5,1,7,9};
        System.out.println(longestSubarray(nums3, 6));
        System.out.println(longestSubarray(nums, limit));
        System.out.println(longestSubarray(nums1, 5));
        System.out.println(longestSubarray(nums2, 0));


    }

    public static int longestSubarray(int[] nums, int limit) {
        if(nums.length==0){
            return 0;
        }
        int min = nums[0],max = nums[0];
        int maxSize = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nums[0]);

        for(int i = 1;i<nums.length;i++){
            if(nums[i]>max){
                queue.add(nums[i]);
                max = nums[i];
                if(nums[i]-min<=limit){
                    if(maxSize<queue.size()){
                        maxSize = queue.size();
                    }
                }else{
                    while (max-min>limit){
                        queue.poll();
                        int[] temp = calMaxMin(queue,max,min);
                        max = temp[0];
                        min = temp[1];
                    }
                }
            }else if(nums[i]<min){
                queue.add(nums[i]);
                min = nums[i];
                if(max-nums[i]<=limit){
                    if(maxSize<queue.size()){
                        maxSize = queue.size();
                    }
                }else{
                    while (max-min>limit){
                        queue.poll();
                        int[] temp = calMaxMin(queue,max,min);
                        max = temp[0];
                        min = temp[1];
                    }
                }
            }else{
                queue.add(nums[i]);
                if(maxSize<queue.size()){
                    maxSize = queue.size();
                }
            }
        }
        return maxSize;
    }

    public static int[] calMaxMin(Queue<Integer> queue, int max, int min){
        if(queue.isEmpty()){
            return null;
        }
        Iterator<Integer> iterator = queue.iterator();
        max = iterator.next();
        min = max;
        while(iterator.hasNext()){
            int temp = iterator.next();
            if(temp>max){
                max = temp;
            }else if(temp<min){
                min = temp;
            }
        }
        int[] temp = {max,min};
        return temp;
    }

}
