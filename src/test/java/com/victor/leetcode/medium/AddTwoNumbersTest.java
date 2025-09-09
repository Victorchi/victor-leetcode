package com.victor.leetcode.medium;

import com.victor.leetcode.medium.AddTwoNumbers.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * AddTwoNumbers 测试类
 * 
 * @author Victor
 */
@DisplayName("LeetCode 2. 两数相加 测试")
class AddTwoNumbersTest {
    
    private AddTwoNumbers solution;
    
    @BeforeEach
    void setUp() {
        solution = new AddTwoNumbers();
    }
    
    @Test
    @DisplayName("基本用例测试")
    void testBasicCases() {
        // 测试用例 1: 342 + 465 = 807
        // l1 = [2,4,3], l2 = [5,6,4], 输出: [7,0,8]
        ListNode l1 = AddTwoNumbers.createListFromArray(new int[]{2, 4, 3});
        ListNode l2 = AddTwoNumbers.createListFromArray(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertThat(AddTwoNumbers.listToArray(result)).isEqualTo(new int[]{7, 0, 8});
        
        // 测试用例 2: 0 + 0 = 0
        // l1 = [0], l2 = [0], 输出: [0]
        l1 = AddTwoNumbers.createListFromArray(new int[]{0});
        l2 = AddTwoNumbers.createListFromArray(new int[]{0});
        result = solution.addTwoNumbers(l1, l2);
        assertThat(AddTwoNumbers.listToArray(result)).isEqualTo(new int[]{0});
        
        // 测试用例 3: 9999999 + 9999 = 10009998
        // l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9], 输出: [8,9,9,9,0,0,0,1]
        l1 = AddTwoNumbers.createListFromArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = AddTwoNumbers.createListFromArray(new int[]{9, 9, 9, 9});
        result = solution.addTwoNumbers(l1, l2);
        assertThat(AddTwoNumbers.listToArray(result)).isEqualTo(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
    }
    
    @Test
    @DisplayName("不同长度链表测试")
    void testDifferentLengthLists() {
        // l1 = [1,2], l2 = [9,9,9], 输出: [0,2,0,1]
        // 21 + 999 = 1020
        ListNode l1 = AddTwoNumbers.createListFromArray(new int[]{1, 2});
        ListNode l2 = AddTwoNumbers.createListFromArray(new int[]{9, 9, 9});
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertThat(AddTwoNumbers.listToArray(result)).isEqualTo(new int[]{0, 2, 0, 1});
        
        // l1 = [5], l2 = [5], 输出: [0,1]
        // 5 + 5 = 10
        l1 = AddTwoNumbers.createListFromArray(new int[]{5});
        l2 = AddTwoNumbers.createListFromArray(new int[]{5});
        result = solution.addTwoNumbers(l1, l2);
        assertThat(AddTwoNumbers.listToArray(result)).isEqualTo(new int[]{0, 1});
    }
    
    @Test
    @DisplayName("单个节点测试")
    void testSingleNode() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertThat(AddTwoNumbers.listToArray(result)).isEqualTo(new int[]{0, 1});
    }
    
    @Test
    @DisplayName("辅助方法测试")
    void testHelperMethods() {
        // 测试 createListFromArray
        int[] arr = {1, 2, 3, 4, 5};
        ListNode list = AddTwoNumbers.createListFromArray(arr);
        assertThat(AddTwoNumbers.listToArray(list)).isEqualTo(arr);
        
        // 测试空数组
        ListNode emptyList = AddTwoNumbers.createListFromArray(new int[0]);
        assertThat(emptyList).isNull();
        assertThat(AddTwoNumbers.listToArray(null)).isEqualTo(new int[0]);
        
        // 测试 toString 方法
        ListNode testList = AddTwoNumbers.createListFromArray(new int[]{1, 2, 3});
        assertThat(testList.toString()).isEqualTo("1 -> 2 -> 3");
    }
    
    @Test
    @DisplayName("测试题目信息")
    void testProblemInfo() {
        assertThat(solution.getProblemNumber()).isEqualTo(2);
        assertThat(solution.getProblemTitle()).isEqualTo("两数相加");
        assertThat(solution.getDifficulty()).isEqualTo(AddTwoNumbers.Difficulty.MEDIUM);
    }
}
