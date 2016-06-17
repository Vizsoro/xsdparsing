import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class XmlSorter {

	private DocumentReader docReader;
	private Path path;
	private Set<Record> books;
	private Set<Record> audioBooks;

	public XmlSorter() {
		books = new HashSet<Record>();
		audioBooks = new HashSet<Record>();
	}

	public static void main(String[] args) {
		XmlSorter xmlSorter = new XmlSorter();
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat("\\library");
		xmlSorter.path = Paths.get(filePath);
		xmlSorter.docReader = new XmlDocumentReader(xmlSorter.path);
		// Find all the xml documents at the given path
		xmlSorter.docReader.findDocuments();
		// Parsing the documents and creating two sets of Records (books and
		// audiobooks)
		DocumentParser documentParser = new XmlDocumentParser(xmlSorter.docReader.getDocuments());
		// Get the sets
		xmlSorter.books = documentParser.getBooks();
		xmlSorter.audioBooks = documentParser.getAudioBooks();
		for (Record book : xmlSorter.books) {
			System.out.println("Book: " + book.toString());
		}
		for (Record audioBook : xmlSorter.audioBooks) {
			System.out.println("Audiobook: " + audioBook.toString());
		}

	}

}
