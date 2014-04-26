package incidenceManagement;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import utils.ConstantesGestionIncidencias;
import utils.Fechas;

public class AccManagerListenerToSystemListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		execution.setVariable(ConstantesGestionIncidencias.SYSTEM_TICKET_DATE, Fechas.fechaActual());
	}

}
