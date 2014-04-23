package incidenceManagement;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;

import utils.ConstantesGestionIncidencias;
import utils.Fechas;


public class PPICalculator {
	
	private static final Logger LOGGER = Logger.getLogger("PPI - IncidenceManagement");
	
	@Autowired
	private HistoryService historyService;
	
	public String calculatePPIAccountManager () {
		String processDefinitionKey = ConstantesGestionIncidencias.PROCESS_KEY_ACCOUNT_MANAGER;
		List<HistoricProcessInstance> instances = historyService.createHistoricProcessInstanceQuery().
				processDefinitionKey(processDefinitionKey).list();
		LOGGER.info("CalculatePPI Account Manager - Obtenida lista de instancias del proceso con KEY = " + processDefinitionKey);
		
		Long sum = 0L;
		
		for (HistoricProcessInstance hpi : instances) {
			sum +=  Calendar.getInstance().getTimeInMillis();
		}
		LOGGER.info("CalculatePPI Account Manager - Calculada la suma de todos los milisegundos");
		
		Double avg = new Double((sum/instances.size()));
		avg = avg/1000;
		LOGGER.info("CalculatePPI1 Account Manager - Calculada la media de la suma de milisengundos");
		
		return avg.toString();
	}
	
	public String calculatePPITicketSystem () {
		String processDefinitionKey = ConstantesGestionIncidencias.PROCESS_TROUBLE_TICKET_SYSTEM;
		List<HistoricProcessInstance> instances = historyService.createHistoricProcessInstanceQuery().
				processDefinitionKey(processDefinitionKey).list();
		LOGGER.info("CalculatePPI Trouble Ticket System - Obtenida lista de instancias del proceso con KEY = " + processDefinitionKey);
		
		Long sum = 0L;
		
		for (HistoricProcessInstance hpi : instances) {
			sum += Calendar.getInstance().getTimeInMillis();
		}
		LOGGER.info("CalculatePPI Trouble Ticket System- Calculada la suma de todos los milisegundos");
		
		Double avg = new Double((sum/instances.size()));
		avg = avg/1000;
		LOGGER.info("CalculatePPI Trouble Ticket System- Calculada la media de la suma de milisengundos");
		
		return avg.toString();
	}
	
	public String calculatePPIFirstLevelSupport () {
		String processDefinitionKey = ConstantesGestionIncidencias.PROCESS_FIRST_LEVEL_SUPPORT_AGENT;
		List<HistoricProcessInstance> instances = historyService.createHistoricProcessInstanceQuery().
				processDefinitionKey(processDefinitionKey).list();
		LOGGER.info("CalculatePPI Fist Level Support - Obtenida lista de instancias del proceso con KEY = " + processDefinitionKey);
		
		Long sum = 0L;
		
		for (HistoricProcessInstance hpi : instances) {
			sum +=  Calendar.getInstance().getTimeInMillis();
		}
		LOGGER.info("CalculatePPI Fist Level Support - Calculada la suma de todos los milisegundos");
		
		Double avg = new Double((sum/instances.size()));
		avg = avg/1000;
		LOGGER.info("CalculatePPI Fist Level Support - Calculada la media de la suma de milisengundos");
		
		return avg.toString();
	}
	
	public String calculatePPISecondLevelSupport () {
		String processDefinitionKey = "Process_3";
		List<HistoricProcessInstance> instances = historyService.createHistoricProcessInstanceQuery().
				processDefinitionKey(processDefinitionKey).list();
		LOGGER.info("CalculatePPI Second Level Support - Obtenida lista de instancias del proceso con KEY = " + processDefinitionKey);
		
		Long sum = 0L;
		
		for (HistoricProcessInstance hpi : instances) {
			sum +=  Calendar.getInstance().getTimeInMillis();
		}
		LOGGER.info("CalculatePPI Second Level Support - Calculada la suma de todos los milisegundos");
		
		Double avg = new Double((sum/instances.size()));
		avg = avg/1000;
		LOGGER.info("CalculatePPI Second Level Support - Calculada la media de la suma de milisengundos");
		
		return avg.toString();
	}
	
	public String calculatePPISoftwareDeveloper () {
		String processDefinitionKey = ConstantesGestionIncidencias.PROCESS_SOFTWARE_DEVELOPER;
		List<HistoricProcessInstance> instances = historyService.createHistoricProcessInstanceQuery().
				processDefinitionKey(processDefinitionKey).list();
		LOGGER.info("CalculatePPI Software Developer - Obtenida lista de instancias del proceso con KEY = " + processDefinitionKey);
		
		Long sum = 0L;
		
		for (HistoricProcessInstance hpi : instances) {
			sum +=  Calendar.getInstance().getTimeInMillis();
		}
		LOGGER.info("CalculatePPI Software Developer - Calculada la suma de todos los milisegundos");
		
		Double avg = new Double((sum/instances.size()));
		avg = avg/1000;
		LOGGER.info("CalculatePPI Software Developer - Calculada la media de la suma de milisengundos");
		
		return avg.toString();
	}
	
	public void vacio(){
		
	}

}
