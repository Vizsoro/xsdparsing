package vzsolt.xsdparse;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class LibraryValidator implements SchemaValidator {
  private Validator validator;
  private List<Source> correctSources = new ArrayList<Source>();
  private List<Source> incorrectSources = new ArrayList<Source>();
  

  public LibraryValidator() {
  }

  @Override
  public void setSchema(String path) throws SAXException {
    SchemaFactory factory =  SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = factory.newSchema(new File(path));
    validator = schema.newValidator();
    }
  
  public void validate(Path xmlPath){
    Source xmlFile = new StreamSource();
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(xmlPath, "*.xml")) {
      
      for (Path filePath : stream) {
        try{
          xmlFile = new StreamSource(filePath.toFile());
          validator.validate(xmlFile);
          } catch (SAXException e) {
          System.out.println("The xml file " + filePath.toString() + " is not valid.");
          this.incorrectSources.add(xmlFile);
          continue;
          }  
        System.out.println("The xml file " + filePath.toString() + " is valid.");
       correctSources.add(xmlFile);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } 

  }
  

  @Override
  public void setDataFiles(List<Document> documents) {
  }
  
  public List<Source> getCorrectSource(){
    return this.correctSources;
  }
  
  public List<Source> getIncorrectSource(){
    return this.incorrectSources;
  }

}
