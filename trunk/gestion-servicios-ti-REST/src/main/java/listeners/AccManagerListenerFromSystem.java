package listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import pojos.Request;
import services.RESTKeyAccountManagerService;
import utils.ConstantesGestionIncidencias;

public class AccManagerListenerFromSystem implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		
		if((Boolean) execution.getVariable("hayRespuestas")) {
			
			Request request = RESTKeyAccountManagerService.getRespuestaTTS();
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_ID, request.getId());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_ISSUE, request.getIssue());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_DESCRIPTION, request.getDescription());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_TYPE, request.getType());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_AUTHOR, request.getAuthor());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_DATE, request.getDate());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_RESULTS, request.getSolution());
		}

//		if (request != null) {
//		}
		
	}

}
