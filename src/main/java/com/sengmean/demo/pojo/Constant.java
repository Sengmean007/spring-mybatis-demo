package com.sengmean.demo.pojo;

/**
 * Created by Sengmean 15/05/2019
 */
public class Constant {

    public static final String SUCCESSFUL = "successful";
    public static final String FAIL = "fail";

    /**
     * to show message
     * @param msg
     * @return
     */
    protected String showMessage(String msg) {
        if (msg.equals(SUCCESSFUL)){
            return msg;
        }
        if (msg.equals(FAIL)){
            return msg;
        }
        return msg;
    }
}
