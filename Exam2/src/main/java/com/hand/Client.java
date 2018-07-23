package com.hand;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Client extends Socket {
 
    private static final String SERVER_IP = "127.0.0.1"; // 服务端IP
    private static final int SERVER_PORT = 8899; // 服务端端口
 
    private Socket client;
 
    private FileInputStream fis;
 
    private DataOutputStream dos;

    public Client() throws Exception {
        super(SERVER_IP, SERVER_PORT);
        this.client = this;
        System.out.println("Cliect[port:" + client.getLocalPort() + "] 成功连接");
    }


    public void sendFile() throws Exception {
        try {
            File directory = new File("../Exam1/tmp/");
            if(!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(directory.getAbsolutePath()+"/SampleChapter1.pdf");
            if(file.exists()) {
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());
 
                // 文件名和长度
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
 
                // 开始传输文件
                byte[] bytes = new byte[1024];
                int length = 0;
                while((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                }
                System.out.println();
                System.out.println("传输成功，请前往改项目的根目录的tmp目录查找");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                fis.close();
            if(dos != null)
                dos.close();
            client.close();
            System.out.println("连接关闭完成！");
        }
    }
 
    /**
     * 入口
     * @param args
     */
    public static void main(String[] args) {
        try {
            Client client = new Client(); // 启动客户端连接
            client.sendFile(); // 传输文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
