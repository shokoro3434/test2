/* <![CDATA[ */ 
//register
$(document).ready( function() {
	    $("#reg").on('click', '.modal-footer .btn-primary', function(e) {
  	    	console.debug("event has occurred.");
	    	$('a[data-toggle="tab"]').each(function(e){
	    		if($(this).parent().attr("class") == 'active'){
	    			if ($(this).attr("href") == '#tab-rds'){
	            		var sendInfo = {
	           				description:{
	           					jobId: $('#tab-rds').find('#jobId').val(),
	           					triggerName: $('#tab-rds').find('#triggerName').val(),
	           					actionName: $('#tab-rds').find('#actionName').val(),
	           		   			awsName: $('#tab-rds').find('#awsName').val(),
	           		   			sys:{
	           		   				modalId: '',
	           		   			  	rh: '',
	           		   			  	mail: '1',
	           		   				rds:{
	           		   					profileName: $('#tab-rds').find('#awsName').val(),
	           		   				  	region: $('#tab-rds').find('#region').val(),
	           		   				  	instanceId: $('#tab-rds').find('#instance').val(),
	           		   				  	snapshotId: $('#tab-rds').find('#snapshot').val()
	           		   				},
	           		   			},
	           		   		},
	           	  	    };
	        	    	$.ajax({
	  	      	  	        type:"POST",
	  	      	  	        url:"/cloud-tool/v1/api/lambda",
	  	      	  	        data:stringify(sendInfo),
	  	      	  	        contentType: 'application/json',
	  	      	  	        dataType: "json"
	        	    	}).done(function(json, status, xhr) {
	  	      		       	console.log("success : "+json);
	        	        	console.log(json);
	        	    	}).fail(function(xhr, status, error){
		      	          	alert("Server Error. Pleasy try again later.");
	        	        }).always(function(arg1, status, arg2) {
	    	  	            $('#reg').modal('hide');
	  	    	          	$('#job-table').bootstrapTable('refresh');
	        	  	  	});
	    			}
    			}
        	});
  	    });  	    	

	
	
	
	$("#tab-rds #actionName").change(function () {
		console.debug($(this).val());
/*		if ('rds-authorizeSecurityGroupIngress' ==  $(this).val()){
		  $('#tab-rds').find('#instance').prop("disabled",true);
		}
		else{
		  $('#tab-rds').find('#instance').prop("disabled",false);
		}
*/
	});

	$("#tab-rds #awsName").change(function () {
		$("#tab-rds #region").val("cn-north-1");
        $('#tab-rds #instance').children().remove();
        $('#tab-rds #snapshot').children().remove();
	});
	$("#tab-rds #region").change(function () {
		var region = $("#tab-rds #region").val();
		var awsName = $("#tab-rds #awsName").val();
		console.debug(region);
    	$.ajax({
  	        type:"GET",
  	        url:"/cloud-tool/v1/api/rds/instances",
  	        data:{awsName:awsName,region:region},
  	        contentType: 'application/json', // リクエストの Content-Type
  	        dataType: "json"           // レスポンスをJSONとしてパースする
    	}).done(function(json, status, xhr) {
	       	console.log("success : "+json);
        	console.log(json);
            $('#tab-rds #instance').children().remove();
            $.each(json, function(key, value) {
                $('#tab-rds #instance').append("<option value='" + key + "'>" + value + "</option>");
            });
    	}).fail(function(xhr, status, error){
          	alert("Server Error. Pleasy try again later.");
        }).always(function(arg1, status, arg2) {
           	console.log("done");
  	  	});
    	$.ajax({
  	        type:"GET",
  	        url:"/cloud-tool/v1/api/rds/snapshots",
  	        data:{awsName:awsName,region:region},
  	        contentType: 'application/json',
  	        dataType: "json"
    	}).done(function(json, status, xhr) {
	       	console.log("success : "+json);
        	console.log(json);
            $('#tab-rds #snapshot').children().remove();
            $.each(json, function(key, value) {
                $('#tab-rds #snapshot').append("<option value='" + key + "'>" + value + "</option>");
            });
    	}).fail(function(xhr, status, error){
          	alert("Server Error. Pleasy try again later.");
        }).always(function(arg1, status, arg2) {
           	console.log("done");
  	  	});
    });
});
/*]]>*/