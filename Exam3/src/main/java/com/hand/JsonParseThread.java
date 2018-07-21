package com.hand;

import java.io.*;

import com.google.gson.Gson;

public class JsonParseThread extends Thread{
    @Override
    public void run() {
        File directory = new File("Exam3/tmp");
        if(!directory.exists()) {
            directory.mkdir();
        }
        try {
            String result = null;
            if((result = GetInfo.getResult())!=null){
                FileOutputStream fis = new FileOutputStream("Exam3/tmp/股票编码.json");
                OutputStreamWriter osw = new OutputStreamWriter(fis);
                BufferedWriter bw = new BufferedWriter(osw);

                String[] fixResult = result.split("\"");
                String[] singles = fixResult[1].split(",");
                //json玩点不一样的？嘿嘿嘿
                Stock stock = new Stock(singles);
                Gson gson = new Gson();
                String json = gson.toJson(stock);

                bw.write(json);

                bw.close();
                osw.close();
                fis.close();
                System.out.println("json解析完成，请前往此项目的tmp目录下查看");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
