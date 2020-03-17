package learning.com.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Create by HuQiuYue on 2020/3/16
 */
public class JsonUtil {

    public static String getValueByJPath(JSONObject response,String jPath){
        Object obj = response;
        for(String s:jPath.split("/")){
            if(!s.isEmpty()){
                if(!s.contains("[") || !s.contains("]")){
                    obj = ((JSONObject)obj).get(s);
                }else{
                    obj = ((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]","")));
                }
            }
        }
        return obj.toString();
    }
}
