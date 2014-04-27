package listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import pojos.Request;
import services.RESTTroubleTicketSystemService;
import utils.ConstantesGestionIncidencias;

public class SystemTicketListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		Request request = RESTTroubleTicketSystemService.getPeticionKAM();
		
		if (request != null) {
			request.setTicketState(ConstantesGestionIncidencias.STATE_WORKING_SYSTEM);
			
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_ID, request.getTicketId());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_ISSUE, request.getTicketIssue());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_DESCRIPTION, request.getTicketDescription());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_AUTHOR, request.getTicketAuthor());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_DATE, request.getTicketDate());
			execution.setVariableLocal(ConstantesGestionIncidencias.SYSTEM_TICKET_RESULTS, request.getTicketSolution());
		}
		
	}

}
