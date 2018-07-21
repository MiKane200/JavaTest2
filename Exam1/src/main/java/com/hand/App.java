package com.hand;

import java.io.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        HttpClient client = HttpClients.createDefault();
        new Thread(() -> {
            HttpGet get = new HttpGet("http://192.168.11.205:18080/trainning/SampleChapter1.pdf");
            try {
                File directory = new File("Exam1/tmp");
                if(!directory.exists()) {
                    directory.mkdir();
                }
                FileOutputStream fos = new FileOutputStream("Exam1/tmp/SampleChapter1.pdf");
                BufferedOutputStream bos = new BufferedOutputStream(fos,1000);

                HttpResponse response = client.execute(get);
                HttpEntity entity = response.getEntity();
                byte[] bytes = new byte[100];
                bytes = EntityUtils.toByteArray(entity);
                bos.write(bytes);

                bos.close();
                fos.close();
                System.out.println("已经下载完成！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
