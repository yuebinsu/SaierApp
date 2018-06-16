package com.outsource.saier.app;

/**
 * Created by：User on 2018/4/25 17:52
 * 619389279@qq.com
 */
public interface ARoutePaths {

    /**
     * 欢迎页面
     */
    String HOME_SPLASH = "/home/splash";
    /**
     * 登录页
     */
    String USER_LOGIN = "/user/login";
    /**
     * 首页
     */
    String HOME_MAIN = "/home/main";
    /**
     * 测量ECG
     */
    String HEALTHY_ECG = "/healthy/ecg";

    /**
     * 测量ECG
     */
    String HEALTHY_ECG_TO = "/healthy/ecgto";
    /**
     * 医嘱
     */
    String HEALTHY_ADVICE = "/healthy/advice";

    /**
     * 随访管理
     */
    String HEALTHY_FOLLOWUP = "/healthy/followup";


    /**
     * 用户信息
     */
    String USER_USERINFO = "/user/userInfo";

    /**
     * 病历
     */
    String USER_RECORD = "/user/record";

    /**
     * 设备信息
     */
    String USER_EQUIPMENT = "/user/equipment";

    /**
     * 设置
     */
    String USER_SEETING = "/user/setting";

    /**
     * 测量血压  无仪器
     */
    String HEALTHY_HEALTHY = "/healthy/healthy";

    /**
     * 血压历史
     */
    String HEALTHY_BLOOD_HISTORY= "/healthy/blood_history";
    /**
     * 消息
     */
    String CONSULT_MESSAGE = "/consult/message";
    /**
     * ecg历史结果列表
     */
    String HEALTHY_ECG_HISTORY = "/healthy/ecg/history";
    /**
     * ecg历史结果
     */
    String HEALTHY_ECG_RESULT = "/healthy/ecg/result";
}
