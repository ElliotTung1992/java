package com.github.demo.utils.hutool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @author 董感恩
 * @date 2020-03-16 10:25
 * @desc
 */
public class XmlUtilTest {

    public static void main(String[] args) {
        try {
            // 初始化xml解析工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 创建DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 创建Document
            Document doc = builder.newDocument();
            // standalone用来表示该文件是否呼叫其它外部的文件。若值是 ”yes” 表示没有呼叫外部文件
            //doc.setXmlStandalone(true);
            // 创建一个根节点
            Element element = doc.createElement("Kp");
            // 创建二级节点 - Version节点
            Element elementVersion = doc.createElement("Version");
            elementVersion.setTextContent("2.0");
            element.appendChild(elementVersion);

            // 创建二级节点 - Fpxx节点
            Element elementFpxx = doc.createElement("Fpxx");
            element.appendChild(elementFpxx);

            // 创建三级节点 - Zsl节点
            Element elementZsl = doc.createElement("Zsl");
            elementZsl.setTextContent("1");
            elementFpxx.appendChild(elementZsl);

            //创建三级节点 - Fpsj节点
            Element elementFpsj = doc.createElement("Fpsj");
            elementFpxx.appendChild(elementFpsj);

            //创建四级节点 - Fp节点
            Element elementFp = doc.createElement("Fp");
            elementFpsj.appendChild(elementFp);

            //创建五级节点 - Spbmbbh节点
            Element elementSpbmbbh = doc.createElement("Spbmbbh");
            elementSpbmbbh.setTextContent("18.0");
            elementFp.appendChild(elementSpbmbbh);

            //创建五级节点 - Hsbz节点
            Element elementHsbz = doc.createElement("Hsbz");
            elementHsbz.setTextContent("0");
            elementFp.appendChild(elementHsbz);

            //创建五级节点 - Sgbz节点
            Element elementSgbz = doc.createElement("Sgbz");
            elementSgbz.setTextContent("0");
            elementFp.appendChild(elementSgbz);

            //创建五级节点 - Djh节点
            Element elementDjh = doc.createElement("Djh");
            elementDjh.setTextContent("6667281");
            elementFp.appendChild(elementDjh);

            //创建五级节点 - Gfmc节点
            Element elementGfmc = doc.createElement("Gfmc");
            elementGfmc.setTextContent("腾讯音乐");
            elementFp.appendChild(elementGfmc);

            //创建五级节点 - Gfsh节点
            Element elementGfsh = doc.createElement("Gfsh");
            elementGfsh.setTextContent("88271637222");
            elementFp.appendChild(elementGfsh);

            //创建五级节点 - Gfyhzh节点
            Element elementGfyhzh = doc.createElement("Gfyhzh");
            elementGfyhzh.setTextContent("宁波银行");
            elementFp.appendChild(elementGfyhzh);

            //创建五级节点 - Gfdzdh节点
            Element elementGfdzdh = doc.createElement("Gfdzdh");
            elementGfdzdh.setTextContent("北京市北京市朝阳区呼家楼街道 0574-9998");
            elementFp.appendChild(elementGfdzdh);

            //创建五级节点 - Bz节点
            Element elementBz = doc.createElement("Bz");
            elementBz.setTextContent("发票号:40000012  起运港:ABIDJANfff 开航日期:2020-02-16\n" +
                    "\n" +
                    "            业务编号:EXP202002033 船名航次:CMCX38290\n" +
                    "\n" +
                    "            开票日期:2020-03-16");
            elementFp.appendChild(elementBz);

            //创建五级节点 - Fhr节点
            Element elementFhr = doc.createElement("Fhr");
            elementFhr.setTextContent("olymtech");
            elementFp.appendChild(elementFhr);

            //创建五级节点 - Skr节点
            Element elementSkr = doc.createElement("Skr");
            elementSkr.setTextContent("收款夏");
            elementFp.appendChild(elementSkr);

            //创建五级节点 - Spxx节点
            Element elementSpxx = doc.createElement("Spxx");
            elementFp.appendChild(elementSpxx);

            //创建六级节点 - Sph节点
            Element elementSph = doc.createElement("Sph");
            elementSpxx.appendChild(elementSph);

            //创建七级节点 - Xh节点
            Element elementXh = doc.createElement("Xh");
            elementXh.setTextContent("1");
            elementSph.appendChild(elementXh);

            //创建七级节点 - Spmc节点
            Element elementSpmc = doc.createElement("Spmc");
            elementSpmc.setTextContent("代理海运费");
            elementSph.appendChild(elementSpmc);

            //创建七级节点 - Ggxh节点
            Element elementGgxh = doc.createElement("Ggxh");
            elementGgxh.setTextContent("");
            elementSph.appendChild(elementGgxh);

            //创建七级节点 - Jldw节点
            Element elementJldw = doc.createElement("Jldw");
            elementJldw.setTextContent("");
            elementSph.appendChild(elementJldw);

            //创建七级节点 - Jldw节点
            Element elementDj = doc.createElement("Dj");
            elementDj.setTextContent("2000.0");
            elementSph.appendChild(elementDj);

            //创建七级节点 - Sl节点
            Element elementSl = doc.createElement("Sl");
            elementSl.setTextContent("1");
            elementSph.appendChild(elementSl);

            //创建七级节点 - Je节点
            Element elementJe = doc.createElement("Je");
            elementJe.setTextContent("2000.0");
            elementSph.appendChild(elementJe);

            //创建七级节点 - Slv节点
            Element elementSlv = doc.createElement("Slv");
            elementSlv.setTextContent("0");
            elementSph.appendChild(elementSlv);

            //创建七级节点 - Spbm节点
            Element elementSpbm = doc.createElement("Spbm");
            elementSpbm.setTextContent("3040802010100000000");
            elementSph.appendChild(elementSpbm);

            //创建七级节点 - Qyspbm节点
            Element elementQyspbm = doc.createElement("Qyspbm");
            elementQyspbm.setTextContent("");
            elementSph.appendChild(elementQyspbm);

            //创建七级节点 - Syyhzcbz节点
            Element elementSyyhzcbz = doc.createElement("Syyhzcbz");
            elementSyyhzcbz.setTextContent("0");
            elementSph.appendChild(elementSyyhzcbz);

            //创建七级节点 - Lslbz节点
            Element elementLslbz = doc.createElement("Lslbz");
            elementLslbz.setTextContent("3");
            elementSph.appendChild(elementLslbz);

            //创建七级节点 - Yhzcsm节点
            Element elementYhzcsm = doc.createElement("Yhzcsm");
            elementSph.appendChild(elementYhzcsm);

            //创建七级节点 - Kce节点
            Element elementKce = doc.createElement("Kce");
            elementKce.setTextContent("0");
            elementSph.appendChild(elementKce);

            // 添加根节点
            doc.appendChild(element);

            // 把xml内容输出到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            File file = new File("/Users/apple/Desktop/test2.xml");
            transformer.transform(new DOMSource(doc),new StreamResult(file));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
