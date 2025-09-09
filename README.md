# Victor LeetCode Solutions

🚀 Java 11+ 版本的 LeetCode 刷题项目

## 项目简介

这是一个基于 Java 11+ 和 Maven 的 LeetCode 刷题项目，旨在提供高质量的算法题解和完善的测试用例。

## 项目特点

- ✅ **Java 11+**: 使用 Java 11 LTS 版本，兼容更高版本
- ✅ **Maven 构建**: 标准的 Maven 项目结构，易于管理依赖
- ✅ **JUnit 5**: 现代化的单元测试框架
- ✅ **AssertJ**: 流畅的断言库，提供更好的测试体验
- ✅ **多种解法**: 每道题提供多种解题思路和时间复杂度分析
- ✅ **完整测试**: 包含边界用例、性能测试等全面的测试覆盖
- ✅ **分类组织**: 按难度等级组织代码结构

## 项目结构

```
victor-leetcode/
├── pom.xml                                 # Maven 配置文件
├── README.md                               # 项目说明文档
├── .gitignore                              # Git 忽略文件
└── src/
    ├── main/java/com/victor/leetcode/
    │   ├── Solution.java                   # 解题基类
    │   ├── easy/                          # 简单题目
    │   │   └── TwoSum.java                # 1. 两数之和
    │   ├── medium/                        # 中等题目
    │   │   └── AddTwoNumbers.java         # 2. 两数相加
    │   └── hard/                          # 困难题目
    │       └── MedianOfTwoSortedArrays.java # 4. 寻找两个正序数组的中位数
    └── test/java/com/victor/leetcode/
        ├── easy/
        │   └── TwoSumTest.java            # 两数之和测试
        ├── medium/
        │   └── AddTwoNumbersTest.java     # 两数相加测试
        └── hard/
            └── MedianOfTwoSortedArraysTest.java # 中位数测试
```

## 环境要求

- Java 11 或更高版本
- Maven 3.6 或更高版本

## 快速开始

### 1. 克隆项目

```bash
git clone <repository-url>
cd victor-leetcode
```

### 2. 编译项目

```bash
mvn clean compile
```

### 3. 运行测试

```bash
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=TwoSumTest

# 运行特定测试方法
mvn test -Dtest=TwoSumTest#testBasicCases
```

### 4. 生成测试报告

```bash
mvn surefire-report:report
```

测试报告将生成在 `target/site/surefire-report.html`

## 已实现题目

### 简单 (Easy)
- [x] [1. 两数之和 (Two Sum)](src/main/java/com/victor/leetcode/easy/TwoSum.java)
  - 暴力枚举: O(n²) 时间，O(1) 空间
  - 哈希表: O(n) 时间，O(n) 空间

### 中等 (Medium)
- [x] [2. 两数相加 (Add Two Numbers)](src/main/java/com/victor/leetcode/medium/AddTwoNumbers.java)
  - 链表模拟: O(max(m,n)) 时间，O(1) 空间

### 困难 (Hard)
- [x] [4. 寻找两个正序数组的中位数 (Median of Two Sorted Arrays)](src/main/java/com/victor/leetcode/hard/MedianOfTwoSortedArrays.java)
  - 合并数组: O(m+n) 时间，O(m+n) 空间
  - 二分查找: O(log(min(m,n))) 时间，O(1) 空间
  - 第k小元素: O(log(m+n)) 时间，O(log(m+n)) 空间

## 代码规范

### 解题类规范

每个解题类都应该：

1. 继承 `Solution` 基类
2. 实现必要的抽象方法（题号、标题、难度）
3. 提供详细的算法注释和复杂度分析
4. 如有多种解法，应提供不同的方法名

```java
public class ExampleSolution extends Solution {
    
    @Override
    public int getProblemNumber() {
        return 1;
    }
    
    @Override
    public String getProblemTitle() {
        return "示例题目";
    }
    
    @Override
    public Difficulty getDifficulty() {
        return Difficulty.EASY;
    }
    
    /**
     * 方法描述
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int solve(int[] nums) {
        // 实现代码
        return 0;
    }
}
```

### 测试类规范

每个测试类都应该：

1. 使用 `@DisplayName` 提供中文描述
2. 包含基本用例、边界用例、性能测试
3. 测试所有公开方法
4. 使用 AssertJ 进行断言

## 开发指南

### 添加新题目

1. 在相应难度包下创建解题类
2. 继承 `Solution` 基类并实现抽象方法
3. 在 `test` 目录下创建对应的测试类
4. 更新 README.md 中的题目列表

### 运行单个题目

可以创建一个简单的 main 方法来测试单个题目：

```java
public static void main(String[] args) {
    TwoSum solution = new TwoSum();
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = solution.twoSum(nums, target);
    System.out.println(Arrays.toString(result));
}
```

## 性能测试

项目包含性能测试用例，可以比较不同算法的执行效率：

```bash
# 运行性能测试
mvn test -Dtest="*Test" -Dgroups="performance"
```

## 贡献指南

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/new-problem`)
3. 提交更改 (`git commit -am 'Add new problem solution'`)
4. 推送分支 (`git push origin feature/new-problem`)
5. 创建 Pull Request

## 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件

## 联系方式

- 作者: Victor
- 邮箱: your.email@example.com
- GitHub: [your-github-username](https://github.com/your-github-username)

---

⭐ 如果这个项目对你有帮助，请给个 Star！
