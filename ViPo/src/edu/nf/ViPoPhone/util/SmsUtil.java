package edu.nf.ViPoPhone.util;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

import java.util.Map;

/**
 * 
 * @date 2019-07-29
 */
public class SmsUtil {

    /**
     * API_KEY
     */
    private static final String API_KEY = "3c3a19d1d5f43e8c8000dd2189bd8b3a";
    /**
     * 构建云片客户端
     */
    private static YunpianClient client;

    static {
        client = new YunpianClient(API_KEY).init();
    }

    /**
     * 发送验证码
     *
     * @param code  随机验证码
     * @param phone 客户联系电话，用于接收系统发送的验证码
     * @return boolean true表示发送成功
     */
    public static boolean send(String code, String phone) {
        Map<String, String> param = client.newParam(2);
        param.put(YunpianClient.TEXT, "【雄丰Test】您的验证码是"+code+"，该验证码3分钟内有效，请勿想任何人提供此验证码。");
        param.put(YunpianClient.MOBILE, phone);
        Result<SmsSingleSend> result = client.sms().single_send(param);
        return result.isSucc();
    }
}
