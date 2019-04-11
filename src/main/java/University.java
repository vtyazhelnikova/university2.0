package main.java;

import org.w3c.dom.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.stream.Collectors;


public class University {
    private String name;
    private List<Group> catalog;

    University(String name) {
        this.name = name;
        this.catalog = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Университет: " +
                "название- " + name +
                ", cписок групп: " + catalog;
    }

    public void generateGroupInfo(String path) {
        for (int i = 0; i < catalog.size(); i++) {
            try {
                HttpsURLConnection conn;
                URL url = new URL(path);
                conn = (HttpsURLConnection) url.openConnection();
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, new TrustManager[]{new TrustHttpsManager()}, new java.security.SecureRandom());

                conn.setSSLSocketFactory(sc.getSocketFactory());

                DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(conn.getInputStream());

                NodeList childNodes = doc.getChildNodes();

                String fileName = childNodes.item(0).getAttributes().item(0).getTextContent().split(",")[0];
                FileWriter writer = new FileWriter(fileName + ".csv", false);

                writer.append("ФАМИЛИЯ, ОТЧЕСТВО, ИМЯ, СТАТУС\n");
                for (int student = 0; student < childNodes.item(0).getChildNodes().getLength(); student++) {
                    NamedNodeMap attributes = childNodes.item(i).getChildNodes().item(student).getAttributes();
                    if (attributes != null) {
                        String[] user = attributes.item(0).getTextContent().split(" ");
                        String status = attributes.item(1).getTextContent();
                        writer.append(String.format("%s, %s, %s, %s", user[0], user[2], user[1], status));
                        writer.append("\n");
                    }
                }

                writer.flush();
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void add_group(Group i) {
        this.catalog.add(i);
    }
}
