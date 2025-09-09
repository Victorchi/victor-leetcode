package com.victor.leetcode;

/**
 * LeetCode 题目解答基类
 * 
 * @author Victor
 */
public abstract class Solution {
    
    /**
     * 获取题目编号
     */
    public abstract int getProblemNumber();
    
    /**
     * 获取题目标题
     */
    public abstract String getProblemTitle();
    
    /**
     * 获取难度等级
     */
    public abstract Difficulty getDifficulty();
    
    /**
     * 获取题目描述
     */
    public abstract String getProblemDescription();
    
    /**
     * 获取题目解法
     */
    public abstract String getProblemSolution();

    /**
     * 难度枚举
     */
    public enum Difficulty {
        EASY("简单"),
        MEDIUM("中等"),
        HARD("困难");
        
        private final String description;
        
        Difficulty(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
        
        @Override
        public String toString() {
            return description;
        }
    }
}
