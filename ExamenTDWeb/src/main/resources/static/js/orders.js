function getStatus(){
	$.ajax({
		type : "get",
		url : "/orders/listStatus",
		success : function(res) {
			result="";
			$.each(res, function(k,v) {
				$("#status").append("<option>" + v.status + "</option>");
			});
		}
	})
}

function getCustomers(){
	$.ajax({
		type : "get",
		url : "/customers/list",
		success : function(res) {
			result="";
			$.each(res, function(k,v) {
				$("#customers").append('<option value="'+ v.customernumber +'">' + v.contactfirstname + " " + v.contactlastname + '</option>');
			});
		}
	})
}

function btnBuscar(){
	var s = document.getElementById("status");
	var c = document.getElementById("customers");
	var fd = new Date($('#fde').val());
	var fh = new Date($('#fha').val());
	var stat = s.options[s.selectedIndex].text;
	var cust = c.options[c.selectedIndex].value;
	
	console.log("status : "+stat);
	console.log("customer id : "+cust);
	
	fd = validaFecha(fd);
	fh = validaFecha(fh);
	
	var ver = '<button type="button" class="btn btn-primary btn-xs">ver</button>';

	$("#orders").empty();
	$.ajax({
		type : "post",
		url : "/orders/listByStatusCustomer",
		data: "status="+stat+"&customernumber="+cust+"&desde="+fd+"&hasta="+fh,
		success : function(res) {
			console.log(res);
			$.each(res, function(k,v) {
				$("#orders").append("<tr><td>"+v.ordernumber+"</td><td>"+v.orderdate+"</td><td>"+v.requireddate+"</td><td>"+v.status+"</td><td>"+ver+"</td></tr>");
			});
		}
	})
}

function validaFecha(fc){
	var fv;
	if(isNaN(fc)){
		console.log("fecha : no valida o opcional");
		fv="";
	}else{
		fv=formatearFecha(fc);
	}	
	return fv;
}

function formatearFecha(f){
	let day = f.getDate();
	let month = f.getMonth() + 1;
	let year = f.getFullYear();

	if(month < 10){
	  month = "0"+month;
	}
	if(day < 10){
	  day = "0"+day;
	}
	var fecha = day+"/"+month+"/"+year; 
	return fecha;
}

function onload(){
	getStatus();
	getCustomers();
}