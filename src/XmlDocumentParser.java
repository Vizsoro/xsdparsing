import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlDocumentParser implements DocumentParser {
	private Set<Record> books;
	private Set<Record> audioBooks;
		
	public XmlDocumentParser(List<Document> documents) {
		LibraryRecord newBook;
		LibraryRecord newAudioBook;
		books = new HashSet<Record>();
		audioBooks =  new HashSet<Record>();
		for(Document document : documents){
			Element docEle = document.getDocumentElement();
			NodeList nlistBook = docEle.getElementsByTagName("book");
			NodeList nlistAudioBook = docEle.getElementsByTagName("audiobook");
			nlistLoop: for (int i = 0; i<nlistBook.getLength(); i++){
							Element bookElement = (Element)nlistBook.item(i);
							newBook = new LibraryRecord(bookElement);
							for(Record oldBook : books ){
								if (oldBook.equals(newBook)){
									oldBook.raiseCount();
									break nlistLoop;
								}
							}
							books.add(newBook);
						}
			nlistLoop: for (int i = 0; i<nlistAudioBook.getLength(); i++){
							Element audioBookElement = (Element)nlistAudioBook.item(i);
							newAudioBook = new LibraryRecord(audioBookElement);
							for(Record oldAudioBook : audioBooks ){
								if (oldAudioBook.equals(newAudioBook)){
									oldAudioBook.raiseCount();
									break nlistLoop;
								}
							}
							audioBooks.add(newAudioBook);
						}
		}		
	}

	public Set<Record> getBooks(){
		return books;
	}
	public Set<Record> getAudioBooks(){
		return audioBooks;
	}
	
}
