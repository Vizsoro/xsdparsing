package vzsolt.xsdparse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlDocumentParser implements DocumentParser {
	private Set<Record> books;
	private Set<Record> audioBooks;
	private List<Document> documentsToParse;
 		
	public XmlDocumentParser(List<Document> documents) {
	  this.documentsToParse = documents;
		
	}

	public Set<Record> getBooks(){
		return books;
	}
	public Set<Record> getAudioBooks(){
		return audioBooks;
	}
	
	public void parseDocuments(){
	  LibraryRecord newBook;
      LibraryRecord newAudioBook;
      Boolean duplicate;
      books = new HashSet<Record>();
      audioBooks =  new HashSet<Record>();
      for(Document document : documentsToParse){
          Element docEle = document.getDocumentElement();
          NodeList nlistBook = docEle.getElementsByTagName("book");
          NodeList nlistAudioBook = docEle.getElementsByTagName("audiobook");
          for (int i = 0; i<nlistBook.getLength(); i++){
                          duplicate = false;
                          Element bookElement = (Element)nlistBook.item(i);
                          newBook = new LibraryRecord(bookElement);
                          for(Record oldBook : books ){
                              if (oldBook.equals(newBook)){
                                  oldBook.raiseCount();
                                  duplicate = true;
                              }
                          }
                          if(!duplicate){
                            books.add(newBook);
                          }
                      }
          for (int i = 0; i<nlistAudioBook.getLength(); i++){
                          duplicate = false;
                          Element audioBookElement = (Element)nlistAudioBook.item(i);
                          newAudioBook = new LibraryRecord(audioBookElement);
                          for(Record oldAudioBook : audioBooks ){
                              if (oldAudioBook.equals(newAudioBook)){
                                  oldAudioBook.raiseCount();
                                  duplicate = true;
                              }
                          }
                          if(!duplicate) {
                            audioBooks.add(newAudioBook);
                          }
                      }
      }       
	  
	}
	
}
