/* <![CDATA[ */ 
//register
$(document).ready( function() {
    $("#reg").on('click', '.modal-footer .btn-primary', function(e) {
    	$('a[data-toggle="tab"]').each(function(e){
    		if($(this).parent().attr("class") == 'active'){
    			if ($(this).attr("href") == '#tab-elb'){
            		var sendInfo = {
           				description:{
           					jobId: $('#tab-elb').find('#jobId').val(),
           					triggerName: $('#tab-elb').find('#triggerName').val(),
           					actionName: $('#tab-elb').find('#actionName').val(),
           		   			awsName: $('#tab-elb').find('#awsName').val(),
           		   			sys:{
           		   				modalId: '',
           		   			  	rh: '',
           		   			  	mail: '1',
           		   				elb:{
           		   					profileName: $('#tab-elb').find('#awsName').val(),
           		   				  	region: $('#tab-elb').find('#region').val(),
           		   				  	name: $('#tab-elb').find('#elb').val(),
           		   				  	instanceId: $('#tab-elb').find('#instance').val(),
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
	
	$("#tab-elb #actionName").change(function () {
		console.debug($(this).val());
/*		if ('elb-authorizeSecurityGroupIngress' ==  $(this).val()){
		  $('#tab-elb').find('#instance').prop("disabled",true);
		}
		else{
		  $('#tab-elb').find('#instance').prop("disabled",false);
		}
*/
	});

	$("#tab-elb #awsName").change(function () {
		$("#tab-elb #region").val("cn-north-1");
        $('#tab-elb #instance').children().remove();
	});
	$("#tab-elb #region").change(function () {
		var region = $("#tab-elb #region").val();
		var awsName = $("#tab-elb #awsName").val();
		console.debug(region);
    	$.ajax({
  	        type:"GET",
  	        url:"/cloud-tool/v1/api/elb/elbs",
  	        data:{awsName:awsName,region:region},
  	        contentType: 'application/json', // リクエストの Content-Type
  	        dataType: "json"           // レスポンスをJSONとしてパースする
    	}).done(function(json, status, xhr) {
	       	console.log("success : "+json);
        	console.log(json);
            $('#tab-elb #elb').children().remove();
            $.each(json, function(key, value) {
                $('#tab-elb #elb').append("<option value='" + key + "'>" + value + "</option>");
            });
    	}).fail(function(xhr, status, error){
          	alert("Server Error. Pleasy try again later.");
        }).always(function(arg1, status, arg2) {
           	console.log("done");
  	  	});
    	$.ajax({
  	        type:"GET",
  	        url:"/cloud-tool/v1/api/ec2/instances",
  	        data:{awsName:awsName,region:region},
  	        contentType: 'application/json',
  	        dataType: "json"
    	}).done(function(json, status, xhr) {
	       	console.log("success : "+json);
        	console.log(json);
            $('#tab-elb #instance').children().remove();
            $.each(json, function(key, value) {
                $('#tab-elb #instance').append("<option value='" + key + "'>" + value + "</option>");
            });
    	}).fail(function(xhr, status, error){
          	alert("Server Error. Pleasy try again later.");
        }).always(function(arg1, status, arg2) {
           	console.log("done");
  	  	});
    });
});
/*]]>*/