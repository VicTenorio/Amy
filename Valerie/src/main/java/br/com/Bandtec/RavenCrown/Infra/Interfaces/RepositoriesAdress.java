package br.com.Bandtec.RavenCrown.Infra.Interfaces;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.*;

public enum RepositoriesAdress {

    SERVICE_IMAGE(GetHomeFolder()+"/home/data/images/servicos"),
    USER_IMAGE(GetHomeFolder()+"/home/data/images/usuarios"),
    WEB_SERVICE("https://ravenmail.azurewebsites.net/Default.aspx/SandEmail?"),
    CONNECTION_URL(GetURL());

    private String locais;

    private RepositoriesAdress(String tipo){
        this.locais = tipo;
    }

    public String getLocais(){
        return locais;
    }

    private static String GetURL() {
        String connection = "";
        try {
            File fXmlFile = new File("config.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(fXmlFile);

            NodeList nList = doc.getElementsByTagName("connectonString");

            for (int count = 0; count < nList.getLength(); count++) {

                Node tempNode = nList.item(count);

                if (tempNode.hasAttributes()) {

                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int temp = 0; temp < nodeMap.getLength(); temp++) {
                        Node node = nodeMap.item(temp);
                        System.out.println("conn : " + node.getNodeValue());

                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return "";
    }

        private static String GetHomeFolder() {
            String home = "";
            try {
                File fXmlFile = new File("config.xml");
                home = "c:";
            } catch (Exception ex) {
                home = "\\~";
            }
            return home;
        }
    }