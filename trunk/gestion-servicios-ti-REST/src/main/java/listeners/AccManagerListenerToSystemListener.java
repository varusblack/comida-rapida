package listeners;

import java.util.UUID;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import utils.ConstantesGestionIncidencias;
import utils.Utilidades;

public class AccManagerListenerToSystemListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		execution.setVariable(ConstantesGestionIncidencias.SYSTEM_TICKET_DATE, Utilidades.fechaActual());
		execution.setVariable(ConstantesGestionIncidencias.SYSTEM_TICKET_ID, UUID.randomUUID().toString());
	}

}
