import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlDocumentReader extends DocumentReader {


  public XmlDocumentReader(Path p) {
    super(p);
    documents = new ArrayList<Document>();
  }

  @Override
  void findDocuments() {
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(this.path, "*.xml")) {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      for (Path filePath : stream) {
        try {
          Document dom;
          DocumentBuilder db = dbf.newDocumentBuilder();
          dom = db.parse(filePath.toString());
          documents.add(dom);
        } catch (ParserConfigurationException pce) {
          pce.printStackTrace();
        } catch (SAXException se) {
          se.printStackTrace();
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  List<Document> getDocuments() {
    return documents;
  }

}
