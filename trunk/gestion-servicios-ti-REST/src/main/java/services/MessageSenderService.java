package services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;

import utils.ConstantesGestionIncidencias;
import utils.Fechas;

public class MessageSenderService {
	
	private static final Logger LOGGER = Logger.getLogger("IncidenceManagement");
	
	@Autowired
	private RuntimeService runtimeService;
	
	public void vipCustomer2AccManager(String ticketType, String ticketIssue, String ticketDescription, String ticketAuthor) {
		
		Map<String, Object> variables = new HashMap<String, Object>();
		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_VIP_CUSTOMER_2_ACC_MANAGER);
		String ticketId = UUID.randomUUID().toString();
		variables.put(ConstantesGestionIncidencias.TICKET_ID, ticketId);
		variables.put(ConstantesGestionIncidencias.TICKET_TYPE, ticketType);
		variables.put(ConstantesGestionIncidencias.TICKET_ISSUE, ticketIssue);
		variables.put(ConstantesGestionIncidencias.TICKET_DESCRIPTION, ticketDescription);
		variables.put(ConstantesGestionIncidencias.TICKET_DATE, Fechas.fechaActual());
		variables.put(ConstantesGestionIncidencias.TICKET_AUTHOR, ticketAuthor);
		
		LOGGER.info("ID: "+ ticketId);
		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_VIP_CUSTOMER_2_ACC_MANAGER + 
				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_KEY_ACCOUNT_MANAGER);
		runtimeService.startProcessInstanceByMessage(ConstantesGestionIncidencias.MESSAGE_VIP_CUSTOMER_2_ACC_MANAGER, 
				ConstantesGestionIncidencias.PROCESS_KEY_ACCOUNT_MANAGER, variables);
	}
	
	public void accManager2TroubleTicketSystem(String systemTicketIssue, String systemTicketDescription, String systemTicketAuthor){
		Map<String, Object> variables = new HashMap<String, Object>();
		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_ACC_MANAGER_2_TROUBLE_TICKET_SYSTEM);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_ID, UUID.randomUUID().toString());
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_ISSUE, systemTicketIssue);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_DESCRIPTION, systemTicketDescription);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_DATE, Fechas.fechaActual());
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_AUTHOR, systemTicketAuthor);
		
		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_ACC_MANAGER_2_TROUBLE_TICKET_SYSTEM + 
				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_TROUBLE_TICKET_SYSTEM);
		runtimeService.startProcessInstanceByMessage(ConstantesGestionIncidencias.MESSAGE_ACC_MANAGER_2_TROUBLE_TICKET_SYSTEM, 
				ConstantesGestionIncidencias.PROCESS_TROUBLE_TICKET_SYSTEM, variables);
	}
	
//	public void troubleTicketSystem2FirstLevelSupportAgent(String firstLevelTicketIssue, String firstLevelTicketDescription, String firstLevelTicketAuthor) {
//		Map<String, Object> variables = new HashMap<String, Object>();
//		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_FIRST_LEVEL_SUPPORT_AGENT);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_ID, UUID.randomUUID().toString());
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_ISSUE, firstLevelTicketIssue);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_DESCRIPTION, firstLevelTicketDescription);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_DATE, Fechas.fechaActual());
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_AUTHOR, firstLevelTicketAuthor);
//		
//		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_FIRST_LEVEL_SUPPORT_AGENT + 
//				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_FIRST_LEVEL_SUPPORT_AGENT);
//		runtimeService.startProcessInstanceByMessage(ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_FIRST_LEVEL_SUPPORT_AGENT, 
//				ConstantesGestionIncidencias.PROCESS_FIRST_LEVEL_SUPPORT_AGENT, variables);
//	}
//	
//	public void firstLevelSupportAgent2TroubleTicketSystem(String firstLevelTicketId, String firstLevelTicketIssue, String firstLevelTicketDescription, Date firstLevelTicketDate, String firstLevelTicketAuthor, String firstLevelTicketResults) {
//		Map<String, Object> variables = new HashMap<String, Object>();
//		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_FIRST_LEVEL_SUPPORT_AGENT_2_TROUBLE_TICKET_SYSTEM);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_ID, firstLevelTicketId);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_ISSUE, firstLevelTicketIssue);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_DESCRIPTION, firstLevelTicketDescription);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_DATE, firstLevelTicketDate);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_AUTHOR, firstLevelTicketAuthor);
//		variables.put(ConstantesGestionIncidencias.FIRST_LEVEL_TICKET_RESULTS, firstLevelTicketResults);
//		
//		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_FIRST_LEVEL_SUPPORT_AGENT_2_TROUBLE_TICKET_SYSTEM + 
//				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_TROUBLE_TICKET_SYSTEM);
//		runtimeService.correlateMessage(ConstantesGestionIncidencias.MESSAGE_FIRST_LEVEL_SUPPORT_AGENT_2_TROUBLE_TICKET_SYSTEM, variables);
//	}
//	
//	public void troubleTicketSystem2SecondLevelSupportAgent(String secondLevelTicketIssue, String secondLevelTicketDescription, String secondLevelTicketAuthor) {
//		Map<String, Object> variables = new HashMap<String, Object>();
//		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_SECOND_LEVEL_SUPPORT_AGENT);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_ID, UUID.randomUUID().toString());
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_ISSUE, secondLevelTicketIssue);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_DESCRIPTION, secondLevelTicketDescription);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_DATE, Fechas.fechaActual());
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_AUTHOR, secondLevelTicketAuthor);
//		
//		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_SECOND_LEVEL_SUPPORT_AGENT + 
//				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_SECOND_LEVEL_SUPPORT_AGENT);
//		runtimeService.startProcessInstanceByMessage(ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_SECOND_LEVEL_SUPPORT_AGENT, 
//				ConstantesGestionIncidencias.PROCESS_SECOND_LEVEL_SUPPORT_AGENT, variables);
//	}
//	
//	public void secondLevelSupportAgent2SoftwareDeveloper(String developerTicketIssue, String developerTicketDescription, String developerTicketAuthor) {
//		Map<String, Object> variables = new HashMap<String, Object>();
//		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_SECOND_LEVEL_SUPPORT_AGENT_2_SOFTWARE_DEVELOPER);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_ID, UUID.randomUUID().toString());
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_ISSUE, developerTicketIssue);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_DESCRIPTION, developerTicketDescription);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_DATE, Fechas.fechaActual());
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_AUTHOR, developerTicketAuthor);
//		
//		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_SECOND_LEVEL_SUPPORT_AGENT_2_SOFTWARE_DEVELOPER + 
//				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_SOFTWARE_DEVELOPER);
//		runtimeService.startProcessInstanceByMessage(ConstantesGestionIncidencias.MESSAGE_SECOND_LEVEL_SUPPORT_AGENT_2_SOFTWARE_DEVELOPER, 
//				ConstantesGestionIncidencias.PROCESS_SOFTWARE_DEVELOPER, variables);
//	}
//	
//	public void softwareDeveloper2SecondLevelSupportAgent(String developerTicketId, String developerTicketIssue, String developerTicketDescription, Date developerTicketDate, String developerTicketAuthor, String developerTicketResults) {
//		Map<String, Object> variables = new HashMap<String, Object>();
//		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_SOFTWARE_DEVELOPER_2_SECOND_LEVEL_SUPPORT_AGENT);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_ID, developerTicketId);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_ISSUE, developerTicketIssue);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_DESCRIPTION, developerTicketDescription);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_DATE, developerTicketDate);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_AUTHOR, developerTicketAuthor);
//		variables.put(ConstantesGestionIncidencias.DEVELOPER_TICKET_RESULTS, developerTicketResults);
//		
//		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_SOFTWARE_DEVELOPER_2_SECOND_LEVEL_SUPPORT_AGENT + 
//				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_SECOND_LEVEL_SUPPORT_AGENT);
//		runtimeService.correlateMessage(ConstantesGestionIncidencias.MESSAGE_SOFTWARE_DEVELOPER_2_SECOND_LEVEL_SUPPORT_AGENT, variables);
//	}
//	
//	public void secondLevelSupportAgent2TroubleTicketSystem(String secondLevelTicketId, String secondLevelTicketIssue, String secondLevelTicketDescription, Date secondLevelTicketDate, String secondLevelTicketAuthor, String secondLevelTicketResults) {
//		Map<String, Object> variables = new HashMap<String, Object>();
//		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_SECOND_LEVEL_SUPPORT_AGENT);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_ID, secondLevelTicketId);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_ISSUE, secondLevelTicketIssue);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_DESCRIPTION, secondLevelTicketDescription);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_DATE, secondLevelTicketDate);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_AUTHOR, secondLevelTicketAuthor);
//		variables.put(ConstantesGestionIncidencias.SECOND_LEVEL_TICKET_RESULTS, secondLevelTicketResults);
//		
//		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_SECOND_LEVEL_SUPPORT_AGENT + 
//				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_SECOND_LEVEL_SUPPORT_AGENT);
//		runtimeService.correlateMessage(ConstantesGestionIncidencias.MESSAGE_SECOND_LEVEL_SUPPORT_AGENT_2_TROUBLE_TICKET_SYSTEM, variables);
//	}
	
	public void troubleTicketSystem2AccManager(String systemTicketId, String systemTicketIssue, String systemTicketDescription, String systemTicketAuthor, String systemTicketResults) {
		Map<String, Object> variables = new HashMap<String, Object>();
		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_ACC_MANAGER);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_ID, systemTicketId);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_ISSUE, systemTicketIssue);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_DESCRIPTION, systemTicketDescription);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_AUTHOR, systemTicketAuthor);
		variables.put(ConstantesGestionIncidencias.SYSTEM_TICKET_RESULTS, systemTicketAuthor);
		
		Map<String, Object> correlationKeys = new HashMap<String, Object>();
		correlationKeys.put(ConstantesGestionIncidencias.SYSTEM_TICKET_ISSUE, systemTicketIssue);
		correlationKeys.put(ConstantesGestionIncidencias.SYSTEM_TICKET_DESCRIPTION, systemTicketDescription);
		correlationKeys.put(ConstantesGestionIncidencias.SYSTEM_TICKET_AUTHOR, systemTicketAuthor);
		
		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_ACC_MANAGER + 
				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_KEY_ACCOUNT_MANAGER);
		runtimeService.correlateMessage(ConstantesGestionIncidencias.MESSAGE_TROUBLE_TICKET_SYSTEM_2_ACC_MANAGER, correlationKeys, variables);
	}
	
	public void accManager2VipCustomer(String ticketId, String ticketType, String ticketIssue, String ticketDescription, String ticketAuthor, String ticketResults) {

		Map<String, Object> variables = new HashMap<String, Object>();
		LOGGER.info("PREPARANDO MAPA DE VARIABLES PARA ENVIO DEL MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_VIP_CUSTOMER_2_ACC_MANAGER);
		variables.put(ConstantesGestionIncidencias.TICKET_ID, ticketId);
		variables.put(ConstantesGestionIncidencias.TICKET_TYPE, ticketType);
		variables.put(ConstantesGestionIncidencias.TICKET_ISSUE, ticketIssue);
		variables.put(ConstantesGestionIncidencias.TICKET_DESCRIPTION, ticketDescription);
		variables.put(ConstantesGestionIncidencias.TICKET_AUTHOR, ticketAuthor);
		variables.put(ConstantesGestionIncidencias.TICKET_RESULTS, ticketResults);
		
		LOGGER.info("MANDANDO MENSAJE: " + ConstantesGestionIncidencias.MESSAGE_ACC_MANAGER_2_VIP_CUSTOMER + 
				" A PROCESO: " + ConstantesGestionIncidencias.PROCESS_VIP_CUSTOMER);
		
		Map<String, Object> correlationKeys = new HashMap<String, Object>();
		correlationKeys.put(ConstantesGestionIncidencias.TICKET_ISSUE, ticketIssue);
		correlationKeys.put(ConstantesGestionIncidencias.TICKET_DESCRIPTION, ticketDescription);
		correlationKeys.put(ConstantesGestionIncidencias.TICKET_TYPE, ticketType);
		correlationKeys.put(ConstantesGestionIncidencias.TICKET_AUTHOR, ticketAuthor);
		
		runtimeService.correlateMessage(ConstantesGestionIncidencias.MESSAGE_ACC_MANAGER_2_VIP_CUSTOMER, correlationKeys, variables);
	}

}
