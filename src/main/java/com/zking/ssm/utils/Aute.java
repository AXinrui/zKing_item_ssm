package com.zking.ssm.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class Aute {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    public static final String URL ="";
    public static final String TPL_ID ="";
    public static final String KEY ="";


    public static String mobileQuery(String phone){

        Random random = new Random();
        String yzm = "";
        for (int i =0;i<6;i++){
            yzm += random.nextInt(9);
        }
        String result =null;
        String url ="http://v.juhe.cn/sms/send";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("mobile",phone);//接受短信的用户手机号码
        params.put("tpl_id","155321");//您申请的短信模板ID，根据实际情况修改
        params.put("tpl_value","#code#="+yzm);//您设置的模板变量，根据实际情况修改
        params.put("key","d77319d34ec5f412e48fa8df81da4a2b");//应用APPKEY(应用详细页查询)
        try {
            result = net(url, params, "GET");
            JSONObject jsonObject = new JSONObject(result);
            System.out.println("error_code:"+jsonObject.get("error_code"));
            if("操作成功".equals(jsonObject.get("reason"))){
                System.out.println("reason:"+jsonObject.get("result"));
                return yzm;
            }else{
                String json = jsonObject.get("error_code")+":"+jsonObject.get("reason");
                return json;
            }
        } catch (Exception e) {
             e.printStackTrace();
            return "异常---------";
        }
    }

    public static void main(String[] args) {
//        St    ring str = "{\"reason\":\"操作成功\",\"result\":{\"sid\":\"0d6e3264533c428ba951716df42a0432\",\"fee\":1,\"count\":1},\"error_code\":0}";
//        JSONObject jsonObject = new JSONObject(str);
////        String string = jsonObject.getString("error_code");
//        System.out.println(jsonObject.get("result"));
        String result =null;
        String url ="http://api.map.baidu.com/geocoder";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("address","长沙");//接受短信的用户手机号码
        params.put("output","json");//您申请的短信模板ID，根据实际情况修改
        params.put("key","37492c0ee6f924cb5e934fa08c6b1676");//应用APPKEY(应用详细页查询)
        try {
            result = net(url, params, "GET");
            JSONObject jsonObject = new JSONObject(result);
            JSONObject jsonArray = jsonObject.getJSONObject(result);
            System.out.println("result:"+jsonObject.get("result"));
            System.out.println("jsonArray："+jsonArray);

//            System.out.println("reason:"+jsonObject.get("result"));
            String json = jsonObject.get("error_code")+":"+jsonObject.get("reason");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,String> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
