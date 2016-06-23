package vzsolt.xsdparse;

import java.util.List;

import javax.xml.transform.Source;

import org.w3c.dom.Document;


public interface SourceReaderInterface {

  void setSource(List<Source> source);

  List<Document> getDocuments();

  void createDocuments();

}
