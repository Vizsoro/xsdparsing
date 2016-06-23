package vzsolt.xsdparse;

import java.nio.file.Path;

import org.w3c.dom.Document;


public interface XmlWriterInterface {

  void setDestinationPath(Path destinationPath);

  void setDocumentOut(Document documentOut);

  void write();

}
