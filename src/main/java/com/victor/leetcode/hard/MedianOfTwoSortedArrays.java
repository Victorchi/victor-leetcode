package com.victor.leetcode.hard;

import com.victor.leetcode.Solution;

/**
 * LeetCode 4. 寻找两个正序数组的中位数
 * 
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的中位数。
 * 
 * 算法的时间复杂度应该为 O(log (m+n))。
 * 
 * @author Victor
 */
public class MedianOfTwoSortedArrays extends Solution {
    
    @Override
    public int getProblemNumber() {
        return 4;
    }
    
    @Override
    public String getProblemTitle() {
        return "寻找两个正序数组的中位数";
    }
    
    @Override
    public Difficulty getDifficulty() {
        return Difficulty.HARD;
    }
    
    /**
     * 方法一：合并数组后找中位数
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(m + n)
     */
    public double findMedianSortedArraysSimple(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, k = 0;
        
        // 合并两个有序数组
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        int total = m + n;
        if (total % 2 == 1) {
            return merged[total / 2];
        } else {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }
    }
    
    /**
     * 方法二：二分查找
     * 时间复杂度：O(log(min(m, n)))
     * 空间复杂度：O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // 找到正确的分割点
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // nums1 的分割点太靠右
                right = partitionX - 1;
            } else {
                // nums1 的分割点太靠左
                left = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("输入的数组不是有序的");
    }
    
    /**
     * 方法三：第 k 小元素
     * 时间复杂度：O(log(m + n))
     * 空间复杂度：O(log(m + n))
     */
    public double findMedianSortedArraysKth(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return findKthElement(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            double left = findKthElement(nums1, 0, nums2, 0, total / 2);
            double right = findKthElement(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        }
    }
    
    private int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int half = k / 2;
        int mid1 = start1 + half - 1;
        int mid2 = start2 + half - 1;
        
        int pivot1 = (mid1 >= nums1.length) ? Integer.MAX_VALUE : nums1[mid1];
        int pivot2 = (mid2 >= nums2.length) ? Integer.MAX_VALUE : nums2[mid2];
        
        if (pivot1 <= pivot2) {
            return findKthElement(nums1, mid1 + 1, nums2, start2, k - half);
        } else {
            return findKthElement(nums1, start1, nums2, mid2 + 1, k - half);
        }
    }

    @Override
    public String getProblemDescription() {
        return "给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。算法的时间复杂度应该为 O(log (m+n))。";
    }

    @Override
    public String getProblemSolution() {
        return "方法一：合并数组后找中位数\n"
                + "方法二：二分查找\n"
                + "方法三：第 k 小元素\n";
    }   
}
