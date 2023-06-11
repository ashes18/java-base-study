package org.ashes.exceptiontest;

public class ExceptionCatchTest {
    public static void main(String[] args) {
        try {
            int a = 5;
            int b = 0;
            String s = null;
            System.out.println(a/b);
            System.out.println(s.trim());
        }catch (ArithmeticException arithmeticException) {
            System.out.println("除0错，捕获第一个异常");
        }catch (Exception e) {
            System.out.println("该对象为空，如果第一个异常已经被捕获了，就轮不到我了");
        }finally {
            System.out.println("我是finally,我一定会执行");
        }
    }
}
