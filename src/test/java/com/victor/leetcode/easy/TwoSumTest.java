package com.victor.leetcode.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * TwoSum 测试类
 * 
 * @author Victor
 */
@DisplayName("LeetCode 1. 两数之和 测试")
class TwoSumTest {
    
    private TwoSum solution;
    
    @BeforeEach
    void setUp() {
        solution = new TwoSum();
    }
    
    @Test
    @DisplayName("基本用例测试")
    void testBasicCases() {
        // 测试用例 1: [2,7,11,15], target = 9
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 1};
        assertThat(solution.twoSum(nums1, target1)).isEqualTo(expected1);
        assertThat(solution.twoSumBruteForce(nums1, target1)).isEqualTo(expected1);
        
        // 测试用例 2: [3,2,4], target = 6
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] expected2 = {1, 2};
        assertThat(solution.twoSum(nums2, target2)).isEqualTo(expected2);
        assertThat(solution.twoSumBruteForce(nums2, target2)).isEqualTo(expected2);
        
        // 测试用例 3: [3,3], target = 6
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] expected3 = {0, 1};
        assertThat(solution.twoSum(nums3, target3)).isEqualTo(expected3);
        assertThat(solution.twoSumBruteForce(nums3, target3)).isEqualTo(expected3);
    }
    
    @Test
    @DisplayName("边界用例测试")
    void testEdgeCases() {
        // 最小数组
        int[] nums = {0, 1};
        int target = 1;
        int[] expected = {0, 1};
        assertThat(solution.twoSum(nums, target)).isEqualTo(expected);
        assertThat(solution.twoSumBruteForce(nums, target)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("负数测试")
    void testNegativeNumbers() {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] expected = {0, 2};
        assertThat(solution.twoSum(nums, target)).isEqualTo(expected);
        assertThat(solution.twoSumBruteForce(nums, target)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("大数组性能测试")
    void testLargeArray() {
        // 创建一个较大的数组来测试性能
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        // 测试 499 + 500 = 999，哈希表会找到第一个匹配的组合
        int target = 999;
        int[] expected = {499, 500}; // nums[499] = 499, nums[500] = 500
        
        // 只测试优化算法，暴力算法会太慢
        assertThat(solution.twoSum(nums, target)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("测试题目信息")
    void testProblemInfo() {
        assertThat(solution.getProblemNumber()).isEqualTo(1);
        assertThat(solution.getProblemTitle()).isEqualTo("两数之和");
        assertThat(solution.getDifficulty()).isEqualTo(TwoSum.Difficulty.EASY);
    }
}
