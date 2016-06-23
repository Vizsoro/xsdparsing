package vzsolt.xsdparse;
import java.util.Set;

public interface DocumentParser {
	public Set<Record> getBooks();
	public Set<Record> getAudioBooks();
	public void parseDocuments();

}
