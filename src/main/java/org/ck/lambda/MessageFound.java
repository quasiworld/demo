package org.ck.lambda;

/**
 * @className: MessageFound
 * @description: 格式转换
 * @createDate: 2021年01月20日 17:21:42
 * @author: ck
 */
@FunctionalInterface
public interface MessageFound {

    /**
     * 功能描述:
     *
     * @param message
     * @param format
     * @return java.lang.String
     * @author ck
     * @date 2021-01-20 17:22
     */
    String format(String message, String format);

    static boolean verifyMessage(String msg) {

        if (msg != null) {
            return true;
        }
        return false;
    }
}
