package com.hand;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlParseThread extends Thread{
    @Override
    public void run() {
        File directory = new File("tmp/");
        if(!directory.exists()) {
            directory.mkdir();
        }
            String result = null;
            if((result = GetInfo.getResult())!=null){
                String[] fixResult = result.split("\"");
                String[] singles = fixResult[1].split(",");

                create(singles);

                System.out.println("xml解析完成，请前往此项目的tmp目录下查看");

            }
    }
    public static void create(String[] singles){
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        org.w3c.dom.Document document = builder.newDocument();

        org.w3c.dom.Element root = document.createElement("stock");

        org.w3c.dom.Element son1 = document.createElement("name");
        son1.setTextContent(singles[0]);
        org.w3c.dom.Element son2 = document.createElement("open");
        son2.setTextContent(singles[1]);
        org.w3c.dom.Element son3 = document.createElement("close");
        son3.setTextContent(singles[2]);
        org.w3c.dom.Element son4 = document.createElement("current");
        son4.setTextContent(singles[3]);
        org.w3c.dom.Element son5 = document.createElement("high");
        son5.setTextContent(singles[4]);
        org.w3c.dom.Element son6 = document.createElement("low");
        son6.setTextContent(singles[5]);

        document.appendChild(root);
        root.appendChild(son1);
        root.appendChild(son2);
        root.appendChild(son3);
        root.appendChild(son4);
        root.appendChild(son5);
        root.appendChild(son6);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transform = null;
        try {
            transform = transformerFactory.newTransformer();
            transform.setOutputProperty("encoding","UTF-8");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        StringWriter writer = new StringWriter();
        try {
            transform.transform(new DOMSource(document),new StreamResult(writer));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        try {
            transform.transform(new DOMSource(document),new StreamResult(new File("tmp/股票编码.xml")));
        } catch (TransformerException e) {
            //e.printStackTrace();
        }
    }
}
