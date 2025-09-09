package com.victor.leetcode.medium;

import com.victor.leetcode.Solution;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortList extends Solution {

    @Override
    public int getProblemNumber() {
        return 148;
    }

    @Override
    public String getProblemTitle() {

        return "排序链表";
    }

    @Override
    public Difficulty getDifficulty() {
        return Difficulty.MEDIUM;
    }

    @Override
    public String getProblemDescription() {
        return "给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。";
    }

    @Override
    public String getProblemSolution() {
        String text = """
                归并排序(Merge Sort)详解
                归并排序是一种基于 分治法(Divide and Conquer) 的排序算法，特别适合链表的排序。它的核心思想是将链表 分割 成更小的子链表，递归排序后再 合并 成一个有序链表。
                1. 归并排序的步骤
                归并排序分为两个主要阶段：
                (1) 分割(Split)
                使用 快慢指针(Fast and Slow Pointer) 找到链表的中间节点。
                将链表从中间断开，分为左右两部分。
                (2) 合并(Merge)
                递归地对左右两部分进行排序。递归地对左右两部分进行排序。
                将两个已排序的子链表 合并 成一个有序链表。
                2. 为什么归并排序适合链表？
                链表不支持随机访问，而归并排序只需要顺序遍历，不需要像数组那样频繁交换元素。
                空间复杂度低：合并过程只需要调整指针，不需要额外存储空间(递归栈除外)。
                时间复杂度稳定：始终是 O(n log n)，没有最坏情况。
                                                """;
        return text;

    }

    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left,right);   
    }


    private ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // 左右节点都不为空，比较大小，小的节点接在curr后面
        while(left!=null && right!=null){
            if(left.val<right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if(left!=null){
            curr.next = left;
        }
        if(right!=null){
            curr.next = right;
        }
        return dummy.next;
           
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
