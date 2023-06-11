package org.ashes.exceptiontest.turntest;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author HASEE
 * 被检查异常转换为不检查异常
 */
public class WrapCheckedException {
    public void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0 : throw new FileNotFoundException();
                case 1 : throw new IOException();
                case 2 : throw new RuntimeException("Where am i?");
                default: return;
            }
        } catch (IOException e) {
            //Adapt to unchecked;
            throw new RuntimeException(e);
        }
    }
}
