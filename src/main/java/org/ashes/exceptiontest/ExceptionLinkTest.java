package org.ashes.exceptiontest;

/**
 * 异常链
 * @author HASEE
 */
public class ExceptionLinkTest {
    public void test1() throws SbException {
        throw new SbException("上课要认真");
    }

    public void test2() {
        try {
            test1();
        } catch (SbException e) {
            RuntimeException runtimeException = new RuntimeException("不好好上课是愚蠢的，要好好努力啊");
            runtimeException.initCause(e);
            throw runtimeException;
        }
    }

    public void test3() {
        try {
            test1();
        } catch (SbException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExceptionLinkTest linkTest = new ExceptionLinkTest();
        System.out.println("----调用test2---");

        try {
            linkTest.test2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("----调用test3---");

        try {
            linkTest.test3();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
