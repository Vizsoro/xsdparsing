package vzsolt.xsdparse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SourceReader implements SourceReaderInterface {
private List<Source> source = new ArrayList<Source>();
private List<Document> documents = new ArrayList<Document>();


  
  /* (non-Javadoc)
   * @see vzsolt.xsdparse.SourceReaderInterface#getSource()
   */
 

/* (non-Javadoc)
 * @see vzsolt.xsdparse.SourceReaderInterface#setSource(java.util.List)
 */
@Override
public void setSource(List<Source> source) {
  this.source = source;
}



/* (non-Javadoc)
 * @see vzsolt.xsdparse.SourceReaderInterface#getDocuments()
 */
@Override
public List<Document> getDocuments() {
  return documents;
}



/* (non-Javadoc)
 * @see vzsolt.xsdparse.SourceReaderInterface#setDocuments(java.util.List)
 */

  public SourceReader() {
  }
  
  /* (non-Javadoc)
   * @see vzsolt.xsdparse.SourceReaderInterface#createDocuments()
   */
  @Override
  public void createDocuments(){
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    Document dom = null;
    DocumentBuilder db;
    for(Source fileSource: this.source){
      try {
        db = dbf.newDocumentBuilder();
        dom = db.parse(new InputSource(fileSource.getSystemId()));
      } catch (ParserConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.documents.add(dom);
      
    }
  }
 

}
