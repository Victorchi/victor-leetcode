package com.victor.leetcode.easy;

import com.victor.leetcode.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. 两数之和
 * 
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，
 * 并返回它们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 
 * @author Victor
 */
public class TwoSum extends Solution {
    
    @Override
    public int getProblemNumber() {
        return 1;
    }
    
    @Override
    public String getProblemTitle() {
        return "两数之和";
    }
    
    @Override
    public Difficulty getDifficulty() {
        return Difficulty.EASY;
    }
    
    /**
     * 方法一：暴力枚举
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
    /**
     * 方法二：哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[0];
    }
}
