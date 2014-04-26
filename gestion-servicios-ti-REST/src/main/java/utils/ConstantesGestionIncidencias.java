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

	// Datos formulario Acc Manager
	public static final String SYSTEM_TICKET_ID = "systemTicketId";
	public static final String SYSTEM_TICKET_TYPE = "systemTicketType";
	public static final String SYSTEM_TICKET_ISSUE = "systemTicketIssue";
	public static final String SYSTEM_TICKET_DESCRIPTION = "systemTicketDescription";
	public static final String SYSTEM_TICKET_DATE = "systemTicketDate";
	public static final String SYSTEM_TICKET_AUTHOR = "systemTicketAuthor";
	public static final String SYSTEM_TICKET_RESULTS = "systemTicketResults";
	

	// Datos formulario First Level Support Agent
	public static final String FIRST_LEVEL_TICKET_ID = "firstLevelTicketId";
	public static final String FIRST_LEVEL_TICKET_TYPE = "firstLevelTicketType";
	public static final String FIRST_LEVEL_TICKET_ISSUE = "firstLevelTicketIssue";
	public static final String FIRST_LEVEL_TICKET_DESCRIPTION = "firstLevelTicketDescription";
	public static final String FIRST_LEVEL_TICKET_DATE = "firstLevelTicketDate";
	public static final String FIRST_LEVEL_TICKET_AUTHOR = "firstLevelTicketAuthor";
	public static final String FIRST_LEVEL_TICKET_RESULTS = "firstLevelTicketResults";

	// Datos formulario Second Level Support Agent
	public static final String SECOND_LEVEL_TICKET_ID = "secondLevelTicketId";
	public static final String SECOND_LEVEL_TICKET_TYPE = "secondLevelTicketType";
	public static final String SECOND_LEVEL_TICKET_ISSUE = "secondLevelTicketIssue";
	public static final String SECOND_LEVEL_TICKET_DESCRIPTION = "secondLevelTicketDescription";
	public static final String SECOND_LEVEL_TICKET_DATE = "secondLevelTicketDate";
	public static final String SECOND_LEVEL_TICKET_AUTHOR = "secondLevelTicketAuthor";
	public static final String SECOND_LEVEL_TICKET_RESULTS = "secondLevelTicketResults";

	// Datos formulario Software Developer
	public static final String DEVELOPER_TICKET_ID = "developerTicketId";
	public static final String DEVELOPER_TICKET_TYPE = "developerTicketType";
	public static final String DEVELOPER_TICKET_ISSUE = "developerTicketIssue";
	public static final String DEVELOPER_TICKET_DESCRIPTION = "developerTicketDescription";
	public static final String DEVELOPER_TICKET_DATE = "developerTicketDate";
	public static final String DEVELOPER_TICKET_AUTHOR = "developerTicketAuthor";
	public static final String DEVELOPER_TICKET_RESULTS = "developerTicketResults";

	// Mensajes Incidencias
	public static final String MESSAGE_VIP_CUSTOMER_2_ACC_MANAGER = "vipCustomer2AccManager";
	public static final String MESSAGE_ACC_MANAGER_2_TROUBLE_TICKET_SYSTEM = "accManager2TroubleTicketSystem";
	public static final String MESSAGE_TROUBLE_TICKET_SYSTEM_2_FIRST_LEVEL_SUPPORT_AGENT = "troubleTicketSystem2FirstLevelSupportAgent";
	public static final String MESSAGE_FIRST_LEVEL_SUPPORT_AGENT_2_TROUBLE_TICKET_SYSTEM = "firstLevelSupportAgent2TroubleTicketSystem";
	public static final String MESSAGE_TROUBLE_TICKET_SYSTEM_2_SECOND_LEVEL_SUPPORT_AGENT = "troubleTicketSystem2SecondLevelSupportAgent";
	public static final String MESSAGE_SECOND_LEVEL_SUPPORT_AGENT_2_SOFTWARE_DEVELOPER = "secondLevelSupportAgent2SoftwareDeveloper";
	public static final String MESSAGE_SOFTWARE_DEVELOPER_2_SECOND_LEVEL_SUPPORT_AGENT = "softwareDeveloper2SecondLevelSupportAgent";
	public static final String MESSAGE_SECOND_LEVEL_SUPPORT_AGENT_2_TROUBLE_TICKET_SYSTEM = "secondLevelSupportAgent2TroubleTicketSystem";
	public static final String MESSAGE_TROUBLE_TICKET_SYSTEM_2_ACC_MANAGER = "troubleTicketSystem2AccManager";
	public static final String MESSAGE_ACC_MANAGER_2_VIP_CUSTOMER = "accManager2VipCustomer";

	// ID Procesos
	public static final String PROCESS_VIP_CUSTOMER = "Gestion_incidencias_Vip_Customer";
	public static final String PROCESS_KEY_ACCOUNT_MANAGER = "Process_2";
	public static final String PROCESS_TROUBLE_TICKET_SYSTEM = "Process_3";
	public static final String PROCESS_FIRST_LEVEL_SUPPORT_AGENT = "Process_4";
	public static final String PROCESS_SECOND_LEVEL_SUPPORT_AGENT = "Process_5";
	public static final String PROCESS_SOFTWARE_DEVELOPER = "Process_6";
	
	// URL API RESTful
	public static final String URL_API = "http://1-dot-gestion-incidencias.appspot.com/incidences/";
	
	// Estado de los tiques
	public static final String STATE_NEW = "Nueva";
	public static final String STATE_WORKING = "En curso";
	public static final String STATE_FINISHED = "Finalizada";

}
