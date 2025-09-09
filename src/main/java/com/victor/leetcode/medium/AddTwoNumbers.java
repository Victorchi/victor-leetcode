package com.victor.leetcode.medium;

import com.victor.leetcode.Solution;

/**
 * LeetCode 2. 两数相加
 * 
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * @author Victor
 */
public class AddTwoNumbers extends Solution {
    
    @Override
    public int getProblemNumber() {
        return 2;
    }
    
    @Override
    public String getProblemTitle() {
        return "两数相加";
    }
    
    @Override
    public Difficulty getDifficulty() {
        return Difficulty.MEDIUM;
    }
    
    /**
     * 链表节点定义
     */
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }
    
    /**
     * 模拟加法运算
     * 时间复杂度：O(max(m, n))，其中 m 和 n 分别为两个链表的长度
     * 空间复杂度：O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
    
    /**
     * 辅助方法：从数组创建链表
     */
    public static ListNode createListFromArray(int[] arr) {
        if (arr.length == 0) return null;
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    /**
     * 辅助方法：将链表转换为数组
     */
    public static int[] listToArray(ListNode head) {
        if (head == null) return new int[0];
        
        // 计算长度
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        // 填充数组
        int[] result = new int[length];
        temp = head;
        for (int i = 0; i < length; i++) {
            result[i] = temp.val;
            temp = temp.next;
        }
        
        return result;
    }

    @Override
    public String getProblemDescription() {
        return "给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。请你将两个数相加，并以相同形式返回一个表示和的链表。";
    }

    @Override
    public String getProblemSolution() {
        return "方法一：链表模拟\n"
                + "方法二：辅助方法\n";
    }
}
