package org.apache.commons.numbers.fraction;

public class TestFraction {
    
    public static void main(String[] args) {
        System.out.println("===== 不使用JUnit的单元测试 =====\n");
        
        int passed = 0;
        int failed = 0;
        
        // 测试1：基本构造
        System.out.println("测试1：基本构造");
        try {
            Fraction f = Fraction.of(1, 2);
            if (f.getNumerator() == 1 && f.getDenominator() == 2) {
                System.out.println("  通过：1/2 构造正确");
                passed++;
            } else {
                System.err.println("  失败：1/2 构造错误");
                failed++;
            }
        } catch (Exception e) {
            System.err.println("  异常：" + e.getMessage());
            failed++;
        }
        
        // 测试2：约分
        System.out.println("\n测试2：约分");
        try {
            Fraction f = Fraction.of(2, 4);
            if (f.getNumerator() == 1 && f.getDenominator() == 2) {
                System.out.println("  通过：2/4 约分为 1/2");
                passed++;
            } else {
                System.err.println("  失败：约分结果为 " + f);
                failed++;
            }
        } catch (Exception e) {
            System.err.println("  异常：" + e.getMessage());
            failed++;
        }
        
        // 测试3：add方法（检测注入的缺陷）
        System.out.println("\n测试3：add方法（检测注入缺陷）");
        try {
            Fraction f1 = Fraction.of(1, 2);
            Fraction f2 = Fraction.of(1, 3);
            Fraction result = f1.add(f2);
            // 正确结果应该是 5/6
            if (result.getNumerator() == 5 && result.getDenominator() == 6) {
                System.out.println("  通过：1/2 + 1/3 = 5/6");
                passed++;
            } else {
                System.err.println("  失败：1/2 + 1/3 计算结果为 " + result + "，预期 5/6");
                System.err.println("  >>> 检测到缺陷！add方法存在逻辑错误");
                failed++;
            }
        } catch (Exception e) {
            System.err.println("  异常：" + e.getMessage());
            failed++;
        }
        
        // 测试4：subtract方法
        System.out.println("\n测试4：subtract方法");
        try {
            Fraction f1 = Fraction.of(1, 2);
            Fraction f2 = Fraction.of(1, 3);
            Fraction result = f1.subtract(f2);
            if (result.getNumerator() == 1 && result.getDenominator() == 6) {
                System.out.println("  通过：1/2 - 1/3 = 1/6");
                passed++;
            } else {
                System.err.println("  失败：1/2 - 1/3 计算结果为 " + result);
                failed++;
            }
        } catch (Exception e) {
            System.err.println("  异常：" + e.getMessage());
            failed++;
        }
        
        // 测试5：multiply方法
        System.out.println("\n测试5：multiply方法");
        try {
            Fraction f1 = Fraction.of(1, 2);
            Fraction f2 = Fraction.of(2, 3);
            Fraction result = f1.multiply(f2);
            if (result.getNumerator() == 1 && result.getDenominator() == 3) {
                System.out.println("  通过：1/2 × 2/3 = 1/3");
                passed++;
            } else {
                System.err.println("  失败：1/2 × 2/3 计算结果为 " + result);
                failed++;
            }
        } catch (Exception e) {
            System.err.println("  异常：" + e.getMessage());
            failed++;
        }
        
        System.out.println("\n===== 测试结果汇总 =====");
        System.out.println("通过：" + passed + " 个");
        System.err.println("失败：" + failed + " 个");
        System.out.println("总计：" + (passed + failed) + " 个测试用例");
        
        if (failed > 0) {
            System.err.println("\n结论：成功检测到add方法中的缺陷！");
        }
    }
}