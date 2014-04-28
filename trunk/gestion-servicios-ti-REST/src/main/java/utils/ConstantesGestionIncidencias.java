package utils;

public class ConstantesGestionIncidencias {
	public static final String ID_GESTION = "idGestion";

	// Datos formulario Ticket Vip Customer
	public static final String TICKET_ID = "ticketId";
	public static final String TICKET_TYPE = "ticketType";
	public static final String TICKET_ISSUE = "ticketIssue";
	public static final String TICKET_DESCRIPTION = "ticketDescription";
	public static final String TICKET_DATE = "ticketDate";
	public static final String TICKET_AUTHOR = "ticketAuthor";
	public static final String TICKET_RESULTS = "ticketResults";
	public static final String TICKET_STATE = "ticketState";

	// Datos formulario Acc Manager
	public static final String SYSTEM_TICKET_ID = "systemTicketId";
	public static final String SYSTEM_TICKET_TYPE = "systemTicketType";
	public static final String SYSTEM_TICKET_ISSUE = "systemTicketIssue";
	public static final String SYSTEM_TICKET_DESCRIPTION = "systemTicketDescription";
	public static final String SYSTEM_TICKET_DATE = "systemTicketDate";
	public static final String SYSTEM_TICKET_AUTHOR = "systemTicketAuthor";
	public static final String SYSTEM_TICKET_RESULTS = "systemTicketResults";

	// ID Procesos
	public static final String PROCESS_VIP_CUSTOMER = "Process_1";
	public static final String PROCESS_KEY_ACCOUNT_MANAGER = "Process_2";
	public static final String PROCESS_TROUBLE_TICKET_SYSTEM = "Process_3";
	
	// URL API RESTful
	// AppEngine de Google
	public static final String URL_API = "http://1-dot-gestion-incidencias.appspot.com/incidences/";
	// Local
//	public static final String URL_API = "http://localhost:8888/incidences/"; 
	
	// Parametros de la URL
	public static final String URL_ID = "id";
	public static final String URL_TYPE = "type";
	public static final String URL_ISSUE = "issue";
	public static final String URL_DESCRIPTION = "description";
	public static final String URL_AUTHOR = "author";
	public static final String URL_DATE = "date";
	public static final String URL_SOLUTION = "solution";
	public static final String URL_STATE = "state";
	
	// Estado de los tiques
	public static final String STATE_NEW = "Nueva";
	public static final String STATE_NEW_SYSTEM = "Nueva para centro de soporte";
	public static final String STATE_WORKING = "En curso";
	public static final String STATE_WORKING_SYSTEM = "En curso en centro de soporte";
	public static final String STATE_FINISHED_SYSTEM = "Finalizada centro de soporte";
	public static final String STATE_FINISHED = "Finalizada";
	

}
