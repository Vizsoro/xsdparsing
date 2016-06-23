package vzsolt.xsdparse;

import java.nio.file.Path;
import java.util.List;

import javax.xml.transform.Source;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public interface SchemaValidator {
  
  void setSchema(String path) throws SAXException;
  void setDataFiles (List<Document> documents);
  void validate(Path filePath);
  
  List<Source> getCorrectSource();
  List<Source> getIncorrectSource();
  

}
