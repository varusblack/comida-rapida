package incidenceManagement;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import pojos.Request;
import services.RESTKeyAccountManagerService;
import utils.ConstantesGestionIncidencias;

public class AsignadorVariablesListener implements ExecutionListener{

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		Request request = RESTKeyAccountManagerService.getPeticionespendientes().get(0);
		request.setTicketState(ConstantesGestionIncidencias.STATE_WORKING);
		
		execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_ID, request.getTicketId());
		execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_ISSUE, request.getTicketIssue());
		execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_DESCRIPTION, request.getTicketDescription());
		execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_TYPE, request.getTicketType());
		execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_AUTHOR, request.getTicketAuthor());
		execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_DATE, request.getTicketDate());
		execution.setVariableLocal(ConstantesGestionIncidencias.TICKET_RESULTS, request.getTicketSolution());
	}

}
