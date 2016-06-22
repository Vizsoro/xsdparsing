package vzsolt.xsdparse;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LibraryRecord implements Record {
	private String author;
	private String title;
	private int count;
	
	public LibraryRecord(Element bookNode){
		NodeList authorNode = bookNode.getElementsByTagName("author");
		if (authorNode.getLength() > 0){
			author = authorNode.item(0).getFirstChild().getNodeValue();
		} else {
			author = "Author is missing!";
		}
		NodeList titleNode = bookNode.getElementsByTagName("title");
		if(titleNode.getLength()>0){
			title = titleNode.item(0).getFirstChild().getNodeValue();
		}else {
			title = "Title is missing.";
		}
		count = 1;
	}

	
	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Record r) {
		if (author.replaceAll("\\s","").equalsIgnoreCase(r.getAuthor().replaceAll("\\s",""))){
			if(title.replaceAll("\\s","").equalsIgnoreCase(r.getTitle().replaceAll("\\s",""))){
				return true;
			}
		}
		return false;
	}
	
	public int hashCode(){
		String details = this.getAuthor() + this.getTitle();
		details = details.replaceAll("\\s","");
		return details.hashCode();
	}
	
	public void raiseCount(){
		count = count + 1;
	}
	
	public String toString(){
		String answer = "Author: " + this.author + " Title: " + this.title + " Piece: " + this.count;
		return answer;
	}

}
