package vzsolt.xsdparse;

import java.util.List;

import org.w3c.dom.Document;

public interface DocumentReader {

  abstract void findDocuments();
  abstract List<Document> getDocuments();
  
  
  
}
