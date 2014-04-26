package incidenceManagement;

import java.util.UUID;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import utils.ConstantesGestionIncidencias;
import utils.Fechas;

public class VipCustomerListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		execution.setVariable(ConstantesGestionIncidencias.TICKET_ID, UUID.randomUUID().toString());
		execution.setVariable(ConstantesGestionIncidencias.TICKET_DATE, Fechas.fechaActual());
	}

}
