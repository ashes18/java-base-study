package org.ashes.exceptiontest.turntest;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 转换过程
 */
public class TrunOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wrapCheckedException = new WrapCheckedException();
        wrapCheckedException.throwRuntimeException(3);

        for (int i = 0; i < 4; i++) {
            try {
                if(i<3) {
                    wrapCheckedException.throwRuntimeException(i);
                }else {
                    throw new SomeOtherException();
                }
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            }catch (RuntimeException re) {
                try {
                    //如果它的”cause“存在则返回这个异常的”cause“，否则返回空（”cause“是”throwable 发生的原因“）这个方法返回了由其他几个以
                    // Throwable 类型参数的构造方法，或者”initCause(Throwable)“方法设置的”cause“。虽然通常不需要重写此方法
                    // ，但子类可以重写此方法以通过其他方式返回原因集。这适用于将异常原因加到”Throwable“所形成的的“遗留链式抛出”。
                    // 注意，所有调用 getCause 方法来确定抛出的原因的 PrintStackTrace 方法不需要重写。

                    Throwable e = re.getCause();
                    throw e;
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException: " + e);
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                    e.printStackTrace();
                }

            }
        }
    }
}
