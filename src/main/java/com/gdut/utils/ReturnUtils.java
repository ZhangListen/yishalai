package com.gdut.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2017/1/8.
 */
public class ReturnUtils {

    /**
     *
     * @return
     */
    public static Map<String,Object> getSuccessReturn(){
        return returnCode(Contants.SUCCESS);
    }

    /**
     *
     * @return
     */
    public static Map<String,Object> getParamErrorReturn() {
        return returnCode(Contants.ERROR_PARAM);
    }

    /**
     *
     * @return
     */
    public static Map<String,Object> getServerErrorReturn(){
        return returnCode(Contants.ERROR_SERVER);
    }

    /**
     *
     * @param code
     * @return
     */
    public static Map<String,Object> returnCode(String code){
        Map<String,Object> result=new HashMap<>();
        result.put("code",code);
        return result;
    }

}
