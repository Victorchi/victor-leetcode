package com.victor.leetcode.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * MedianOfTwoSortedArrays 测试类
 * 
 * @author Victor
 */
@DisplayName("LeetCode 4. 寻找两个正序数组的中位数 测试")
class MedianOfTwoSortedArraysTest {
    
    private MedianOfTwoSortedArrays solution;
    
    @BeforeEach
    void setUp() {
        solution = new MedianOfTwoSortedArrays();
    }
    
    @Test
    @DisplayName("基本用例测试")
    void testBasicCases() {
        // 测试用例 1: nums1 = [1,3], nums2 = [2], 输出: 2.0
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
        
        // 测试用例 2: nums1 = [1,2], nums2 = [3,4], 输出: 2.5
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        expected = 2.5;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("单个数组为空测试")
    void testOneEmptyArray() {
        // nums1 = [], nums2 = [1], 输出: 1.0
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
        
        // nums1 = [2], nums2 = [], 输出: 2.0
        nums1 = new int[]{2};
        nums2 = new int[]{};
        expected = 2.0;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("奇数长度测试")
    void testOddLength() {
        // nums1 = [1,3,5], nums2 = [2,4], 输出: 3.0
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4};
        double expected = 3.0;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("偶数长度测试")
    void testEvenLength() {
        // nums1 = [1,2], nums2 = [3,4], 输出: 2.5
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("重复元素测试")
    void testDuplicateElements() {
        // nums1 = [1,1], nums2 = [1,2], 输出: 1.0
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 2};
        double expected = 1.0;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("负数测试")
    void testNegativeNumbers() {
        // nums1 = [-2,-1], nums2 = [1,2], 合并后 [-2,-1,1,2], 中位数: (-1+1)/2 = 0.0
        int[] nums1 = {-2, -1};
        int[] nums2 = {1, 2};
        double expected = 0.0;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("大数组测试")
    void testLargeArrays() {
        // 创建较大的数组进行测试
        int[] nums1 = new int[100];
        int[] nums2 = new int[100];
        
        for (int i = 0; i < 100; i++) {
            nums1[i] = i * 2;      // 0, 2, 4, 6, ..., 198
            nums2[i] = i * 2 + 1;  // 1, 3, 5, 7, ..., 199
        }
        
        double expected = 99.5; // (99 + 100) / 2
        
        // 只测试优化算法，简单算法可能较慢但结果应该一致
        assertThat(solution.findMedianSortedArrays(nums1, nums2)).isEqualTo(expected);
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("浮点数精度测试")
    void testFloatingPointPrecision() {
        // nums1 = [1,3], nums2 = [2,7], 输出: 2.5
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7};
        double expected = 2.5;
        
        assertThat(solution.findMedianSortedArrays(nums1, nums2))
            .isCloseTo(expected, within(1e-9));
        assertThat(solution.findMedianSortedArraysSimple(nums1, nums2))
            .isCloseTo(expected, within(1e-9));
        assertThat(solution.findMedianSortedArraysKth(nums1, nums2))
            .isCloseTo(expected, within(1e-9));
    }
    
    @Test
    @DisplayName("测试题目信息")
    void testProblemInfo() {
        assertThat(solution.getProblemNumber()).isEqualTo(4);
        assertThat(solution.getProblemTitle()).isEqualTo("寻找两个正序数组的中位数");
        assertThat(solution.getDifficulty()).isEqualTo(MedianOfTwoSortedArrays.Difficulty.HARD);
    }
}
