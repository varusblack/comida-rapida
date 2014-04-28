package listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import pojos.Request;
import services.RESTKeyAccountManagerService;
import utils.ConstantesGestionIncidencias;

public class AccManagerListener implements ExecutionListener{

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		
		if ((Boolean) execution.getVariable("hayPeticiones")) {
			Request request = RESTKeyAccountManagerService.getPeticionVip();
			request.setState(ConstantesGestionIncidencias.STATE_WORKING);
			
			execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_ID, request.getId());
			execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_ISSUE, request.getIssue());
			execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_DESCRIPTION, request.getDescription());
			execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_TYPE, request.getType());
			execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_AUTHOR, request.getAuthor());
			execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_DATE, request.getDate());
			execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_RESULTS, request.getSolution());
			
		}
//		if (request != null) {
//		}
	}

}
