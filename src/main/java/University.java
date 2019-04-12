package main.java;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


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
                String Uni_url = catalog.get(i).getLink();
                HttpsURLConnection conn;
                URL url = new URL(Uni_url);
                conn = (HttpsURLConnection) url.openConnection();
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, new TrustManager[]{new TrustHttpsManager()}, new java.security.SecureRandom());

                conn.setSSLSocketFactory(sc.getSocketFactory());

                DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(conn.getInputStream());

                Node root = doc.getDocumentElement();
                NodeList childNodes = root.getChildNodes();


                String fileName = catalog.get(i).getName();
                FileWriter writer = new FileWriter(path+ "\\" +fileName + ".csv", false);

                writer.append("ФАМИЛИЯ, ОТЧЕСТВО, ИМЯ, СТАТУС\n");


                for (int student = 0; student < childNodes.getLength(); student++) {

                    NamedNodeMap attributes = childNodes.item(student).getAttributes();
                    if (attributes != null) {
                        String[] info = attributes.item(0).getTextContent().split(" ");
                        String status = attributes.item(1).getTextContent();
                        writer.append(String.format("%s, %s, %s, %s", info[0], info[2], info[1], status));
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
