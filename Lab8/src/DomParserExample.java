import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

public class DomParserExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            URL url = new URL("http://naviny.by/rss/alls.xml");
            Document document = builder.parse(url.openStream());

            Rss rss = processDocument(document);
            System.out.println(rss.getChannel());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Rss processDocument(Document document) {
        Rss rss = new Rss();
        Channel channel = new Channel();
        NodeList channelList = document.getElementsByTagName("channel");

        if (channelList.getLength() > 0) {
            Element channelElement = (Element) channelList.item(0);
            channel.setTitle(getTextContent(channelElement, "title"));
            channel.setLink(getTextContent(channelElement, "link"));
            channel.setDescription(getTextContent(channelElement, "description"));

            // Обработка элементов (новостей) внутри канала
            NodeList itemList = channelElement.getElementsByTagName("item");
            for (int i = 0; i < itemList.getLength(); i++) {
                Element itemElement = (Element) itemList.item(i);
                Item item = new Item();
                item.setTitle(getTextContent(itemElement, "title"));
                item.setLink(getTextContent(itemElement, "link"));
                item.setDescription(getTextContent(itemElement, "description"));
                channel.getItems().add(item);
            }
        }

        rss.setChannel(channel);
        return rss;
    }

    private static String getTextContent(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }
}
