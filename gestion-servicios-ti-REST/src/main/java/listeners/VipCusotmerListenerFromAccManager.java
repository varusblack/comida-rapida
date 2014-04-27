package listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import pojos.Request;
import services.RESTVipCustomerService;
import utils.ConstantesGestionIncidencias;

public class VipCusotmerListenerFromAccManager implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		
		Request respuestaKAW = RESTVipCustomerService.getRespuestaKAM();
		
		if (respuestaKAW != null) {
			execution.setVariable(ConstantesGestionIncidencias.TICKET_RESULTS, respuestaKAW.getTicketSolution());
			respuestaKAW.setTicketState(ConstantesGestionIncidencias.STATE_FINISHED);
		}
		
	}

}
