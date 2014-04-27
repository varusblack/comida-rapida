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
	private String ticketID;
	private String ticketType;
	private String ticketIssue;
	private String ticketDescription;
	private String ticketDate;
	private String ticketAuthor;
	private String ticketState;
	private String ticketSolution;

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
		return this.ticketID;
	}

	/**
	 * Modifica el ID de la incidencia.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.ticketID = id;
	}

	/**
	 * @return the ticketType
	 */
	public String getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * @return the ticketIssue
	 */
	public String getTicketIssue() {
		return ticketIssue;
	}

	/**
	 * @param ticketIssue the ticketIssue to set
	 */
	public void setTicketIssue(String ticketIssue) {
		this.ticketIssue = ticketIssue;
	}

	/**
	 * @return the ticketDescription
	 */
	public String getTicketDescription() {
		return ticketDescription;
	}

	/**
	 * @param ticketDescription the ticketDescription to set
	 */
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	/**
	 * @return the ticketAuthor
	 */
	public String getTicketAuthor() {
		return ticketAuthor;
	}

	/**
	 * @param ticketAuthor the ticketAuthor to set
	 */
	public void setTicketAuthor(String ticketAuthor) {
		this.ticketAuthor = ticketAuthor;
	}

	/**
	 * Obtiene el estado de la incidencia.
	 * 
	 * @return the state
	 */
	public String getState() {
		return this.ticketState;
	}

	/**
	 * Modifica el estado de la incidencia.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.ticketState = state;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.ticketDate = date;
	}

	/**
	 * Obtiene la fecha en la que fue realizada la incidencia.
	 * 
	 * @return
	 */
	public String getDate() {
		return this.ticketDate;
	}

	/**
	 * @return the ticketSolution
	 */
	public String getTicketSolution() {
		return ticketSolution;
	}

	/**
	 * @param ticketSolution the ticketSolution to set
	 */
	public void setTicketSolution(String ticketSolution) {
		this.ticketSolution = ticketSolution;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ticketAuthor == null) ? 0 : ticketAuthor.hashCode());
		result = prime * result
				+ ((ticketDate == null) ? 0 : ticketDate.hashCode());
		result = prime
				* result
				+ ((ticketDescription == null) ? 0 : ticketDescription
						.hashCode());
		result = prime * result
				+ ((ticketID == null) ? 0 : ticketID.hashCode());
		result = prime * result
				+ ((ticketIssue == null) ? 0 : ticketIssue.hashCode());
		result = prime * result
				+ ((ticketState == null) ? 0 : ticketState.hashCode());
		result = prime * result
				+ ((ticketType == null) ? 0 : ticketType.hashCode());
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
		if (ticketAuthor == null) {
			if (other.ticketAuthor != null)
				return false;
		} else if (!ticketAuthor.equals(other.ticketAuthor))
			return false;
		if (ticketDate == null) {
			if (other.ticketDate != null)
				return false;
		} else if (!ticketDate.equals(other.ticketDate))
			return false;
		if (ticketDescription == null) {
			if (other.ticketDescription != null)
				return false;
		} else if (!ticketDescription.equals(other.ticketDescription))
			return false;
		if (ticketID == null) {
			if (other.ticketID != null)
				return false;
		} else if (!ticketID.equals(other.ticketID))
			return false;
		if (ticketIssue == null) {
			if (other.ticketIssue != null)
				return false;
		} else if (!ticketIssue.equals(other.ticketIssue))
			return false;
		if (ticketState == null) {
			if (other.ticketState != null)
				return false;
		} else if (!ticketState.equals(other.ticketState))
			return false;
		if (ticketType == null) {
			if (other.ticketType != null)
				return false;
		} else if (!ticketType.equals(other.ticketType))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Incidence [ticketID=" + ticketID + ", ticketType=" + ticketType
				+ ", ticketIssue=" + ticketIssue + ", ticketDescription="
				+ ticketDescription + ", ticketDate=" + ticketDate
				+ ", ticketAuthor=" + ticketAuthor + ", ticketState="
				+ ticketState + "]";
	}
}
