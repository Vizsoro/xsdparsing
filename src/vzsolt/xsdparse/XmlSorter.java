package vzsolt.xsdparse;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.SAXException;

public class XmlSorter {

	private Path xmlPath;
	private Set<Record> books;
	private Set<Record> audioBooks;
	public XmlSorter() {
		books = new HashSet<Record>();
		audioBooks = new HashSet<Record>();
	}

	public static void main(String[] args) {
		XmlSorter xmlSorter = new XmlSorter();
		String filePath = new File("").getAbsolutePath();
		String schemaPath = new File("").getAbsolutePath();
		filePath = filePath.concat("\\library");
		schemaPath = schemaPath.concat("\\library\\librarySchema2.xsd");		
		xmlSorter.xmlPath = Paths.get(filePath);		
	
		
		SchemaValidator validator = new LibraryValidator();
		try {
		    validator.setSchema(schemaPath);
		    validator.validate(xmlSorter.xmlPath);
		    
		} catch (SAXException e) {
         e.printStackTrace();
		}
		SourceReaderInterface sourceReader = new SourceReader();
		sourceReader.setSource(validator.getCorrectSource());
		sourceReader.createDocuments();

		// Parsing the documents and creating two sets of Records (books and
		// audiobooks)
		
		/* DocumentParser documentParser = new XmlDocumentParser(sourceReader.getDocuments());
		documentParser.parseDocuments();
		xmlSorter.books = documentParser.getBooks();
		xmlSorter.audioBooks = documentParser.getAudioBooks();
		for (Record book : xmlSorter.books) {
			System.out.println("Book: " + book.toString());
		}
		for (Record audioBook : xmlSorter.audioBooks) {
			System.out.println("Audiobook: " + audioBook.toString());
		}
		*/
	}
}
