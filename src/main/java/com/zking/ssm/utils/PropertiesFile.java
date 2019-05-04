package com.zking.ssm.utils;

import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesFile {

    /**
     * read properties file
     *
     * @param paramFile file path
     * @throws Exception
     */
    public static Map<String,Object> inputFile(String paramFile) throws Exception {
        Properties props = new Properties();//使用Properties类来加载属性文件
        Map<String,Object> map = new HashMap<>();
        FileInputStream iFile = new FileInputStream(paramFile);
        props.load(iFile);

        /**begin*******直接遍历文件key值获取*******begin*/
        Iterator<String> iterator = props.stringPropertyNames().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key!=null) {
                /**end*******直接遍历文件key值获取*******end*/
                map.put(key,props.getProperty(key));
            }
        }
        iFile.close();
        return map;
    }

    /**
     * write properties file
     *
     * @param paramFile file path
     * @throws IOException
     */
    private static int outputFile(String paramFile,Map<String,Object> map ) throws IOException {
        ///保存属性到b.properties文件
        Properties props = new Properties();
        FileOutputStream oFile = new FileOutputStream(paramFile);//true表示追加打开
            for (Map.Entry<String, Object> s : map.entrySet()) {
                props.setProperty(s.getKey(),s.getValue()+"");
            }
        //store(OutputStream,comments):store(输出流，注释)  注释可以通过“\n”来换行
        props.store(oFile, null);
        oFile.close();
        return 0;
    }

    public static void main(String[] args) {

        // 赋值更新
       try {
            String url = "E:\\idea_project\\zKing_item_ssm\\zKing_item_ssm\\src\\main\\resources\\properties\\jdbc.properties";
            Map<String, Object> map = PropertiesFile.inputFile(url);
            for (Map.Entry<String, Object> s : map.entrySet()) {
                System.out.println(s.getKey()+":"+s.getValue());
            }
            map.put("x","12.12315");
            map.put("y","543.45345345");
            int i = PropertiesFile.outputFile(url, map);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
