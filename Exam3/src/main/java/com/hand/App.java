package com.hand;

public class App 
{
    public static void main( String[] args )
    {
        GetInfo getInfo = GetInfo.getInstance();
        //默认是601006，这里可以加code来转换编码
        getInfo.setCode("sz300170");
        for (String arg:args) {
            System.out.println("输入的参数:"+arg);
            getInfo.setCode(arg);
        }

        new JsonParseThread().start();
        new XmlParseThread().start();
    }
}
