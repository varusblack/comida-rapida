package pojos;

public class Request {

	private String id;
	private String type;
	private String issue;
	private String description;
	private String author;
	private String date;
	private String solution;
	private String state;
	
	public Request() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", type=" + type + ", issue=" + issue
				+ ", description=" + description + ", author=" + author
				+ ", date=" + date + ", solution=" + solution + ", state="
				+ state + "]";
	}

	
}
