package com.hand;

public class App 
{
    public static void main( String[] args )
    {
        GetInfo getInfo = GetInfo.getInstance();
        for (String arg:args) {
            System.out.println("输入的参数:"+arg);
            getInfo.setCode(arg);
        }

        new JsonParseThread().start();
        new XmlParseThread().start();
    }
}
