package com.victor.leetcode.medium;

import com.victor.leetcode.Solution;
import com.victor.leetcode.Solution.Difficulty;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortList  extends Solution  {

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

    public ListNode sortList(ListNode head) {
        return null;
    }

}
