package com.hand;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class GetInfo {
    private static GetInfo instance = new GetInfo();
    private static String code;

    private GetInfo(){}

    public static GetInfo getInstance(){
        return instance;
    }

    public  String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String getResult(){
        //打包的时候一直报什么引入apache的包，明明引入了啊？？？？？
        //HttpClient client = HttpClients.createDefault();
        //+code
        //HttpGet get = new HttpGet("http://hq.sinajs.cn/list=sh601006");
        //HttpResponse response = client.execute(get);
        //HttpEntity entity = response.getEntity();

        try {
            URL url = new URL("http://hq.sinajs.cn/list=sh601006");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();

            //attention！！！ 题目没说设置成什么，我就设成gbk了，这儿还可以设置成UTF-8
            InputStreamReader isr = new InputStreamReader(is,"GBK");


            BufferedReader bufferedReader = new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = bufferedReader.readLine())!=null){
                builder.append(line);
            }
            String result = builder.toString();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
