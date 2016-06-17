
public interface Record {
	
	String getAuthor();
	String getTitle();
	int hashCode();
	String toString();
	boolean equals(Record r);
	void raiseCount();
}
