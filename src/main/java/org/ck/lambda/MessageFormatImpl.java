package org.ck.lambda;

/**
 * @className: MessageFormatImpl
 * @description:
 * @createDate: 2021年01月20日 17:39:00
 * @author: ck
 */
public class MessageFormatImpl implements MessageFound {
    @Override
    public String format(String message, String format) {
        System.out.println("消息转换...");
        return message;
    }
}
