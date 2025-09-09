package com.victor.leetcode.easy;

import com.victor.leetcode.Solution;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
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
                    return new int[] { i, j };
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
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

    @Override
    public String getProblemDescription() {
        String text = "给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。\n"
                + "你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。\n"
                + "你可以按任意顺序返回答案。\n"
                + "\n"
                + "示例 1：\n"
                + "输入：nums = [2,7,11,15], target = 9\n"
                + "输出：[0,1]\n"
                + "解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。";
        return text;
    }

    @Override
    public String getProblemSolution() {
        return """
                方法一：暴力枚举
                方法二：哈希表
                """;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}       

