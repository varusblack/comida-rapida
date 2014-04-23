function guid() {
	function s4() {
		return Math.floor((1 + Math.random()) * 0x10000).toString(16)
				.substring(1);
	}
	return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4()
			+ s4() + s4();
}

function fechaActual() {
	var today = new Date();
	var DD = today.getDate();
	var MM = today.getMonth()+1; //January is 0!
	var YYYY = today.getFullYear();
	var hh = today.getHours();
	var mm = today.getMinutes();
	var ss = today.getSeconds();

	if(DD < 10) {
	    DD = '0' + DD;
	} 

	if(MM < 10) {
	    MM = '0' + MM;
	} 

	var fechaString = DD + '/' + MM + '/' + YYYY + " - " + hh + ":" + mm + ":" + ss ;
	return fechaString;
}