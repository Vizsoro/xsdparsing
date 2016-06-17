import java.nio.file.Path;

import java.util.List;

import org.w3c.dom.Document;

public abstract class DocumentReader {
	Path path;
	List<Document> documents;
	
	public DocumentReader(Path p) {
		path = p;
	}
	
	abstract void findDocuments();
	abstract List<Document> getDocuments();
	
	
}
