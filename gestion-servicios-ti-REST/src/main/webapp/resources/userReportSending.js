/**
 * 
 */
function alerta() {
	var guid = guid();
	var fecha = fechaActual();
	
	var ticketType = $("#ticketType");
	var ticketIssue = $("#ticketIssue");
	var ticketDescription = $("#ticketDescription");
	var ticketAuthor = $("#ticketAuthor");
	
	$("#ticketId").val(guid);
	$("#ticketDate").val(fecha);
	
	var mostrando = "GUID: " + guid + ", FECHA: " + fecha + ", TYPE: " + ticketType + ", ISSUE: " + ticketIssue;
	
	alert(mostrando);
}