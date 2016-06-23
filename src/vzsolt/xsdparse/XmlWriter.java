package vzsolt.xsdparse;

import java.nio.file.Path;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XmlWriter implements XmlWriterInterface {

  public XmlWriter() {
    // TODO Auto-generated constructor stub
  }
  
  private Path destinationPath;
  private Document documentOut;
  
  
  /* (non-Javadoc)
   * @see vzsolt.xsdparse.XmlWriterInterface#setDestinationPath(java.nio.file.Path)
   */
  @Override
  public void setDestinationPath(Path destinationPath) {
    this.destinationPath = destinationPath;
  }


  /* (non-Javadoc)
   * @see vzsolt.xsdparse.XmlWriterInterface#setDocumentOut(org.w3c.dom.Document)
   */
  @Override
  public void setDocumentOut(Document documentOut) {
    this.documentOut = documentOut;
  }


  /* (non-Javadoc)
   * @see vzsolt.xsdparse.XmlWriterInterface#write()
   */
  @Override
  public void write() {
    
    Transformer transformer=null;
    try {
      transformer = TransformerFactory.newInstance().newTransformer();
    } catch (TransformerConfigurationException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (TransformerFactoryConfigurationError e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
    DOMSource source = new DOMSource(documentOut);
    StreamResult console = new StreamResult(System.out);
    try {
      transformer.transform(source, console);
    } catch (TransformerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("\nXML DOM Created Successfully..");

    
  }

}
