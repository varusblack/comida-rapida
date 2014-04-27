package aws.models;

/**
 * Clase incidencia. Representa una incidencia en el sistema.
 * 
 * @author Alberto Salido
 * @author Alvaro Tristancho
 * @author Nicolas Sanchez
 * 
 */
public class Incidence {

	// Constantes con los estados de las incidencias.
	public static String PENDING = "Pendiente de procesar";
	public static String IN_PROGRESS = "En proceso";
	public static String REJECTED = "Rechazada";
	public static String COMPLETED = "Completada";

	// Atributos de la clase.
	private String id;
	private String type;
	private String issue;
	private String description;
	private String date;
	private String author;
	private String state;
	private String solution;

	/**
	 * Constructor. Crea una nueva incidencia a fecha actual y con estado
	 * "pendiente"
	 */
	public Incidence() {
	}

	/**
	 * Obtiene el ID de la incidencia.
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Modifica el ID de la incidencia.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Obtiene el estado de la incidencia.
	 * 
	 * @return the state
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * Modifica el estado de la incidencia.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Obtiene la fecha en la que fue realizada la incidencia.
	 * 
	 * @return
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * @return the ticketSolution
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((date == null) ? 0 : date.hashCode());
		result = prime
				* result
				+ ((description == null) ? 0 : description
						.hashCode());
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((issue == null) ? 0 : issue.hashCode());
		result = prime * result
				+ ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidence other = (Incidence) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issue == null) {
			if (other.issue != null)
				return false;
		} else if (!issue.equals(other.issue))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Incidence [id=" + id + ", type=" + type + ", issue=" + issue
				+ ", description=" + description + ", date=" + date
				+ ", author=" + author + ", state=" + state + ", solution="
				+ solution + "]";
	}


}
