/* <![CDATA[ */ 
//register
$(document).ready( function() {
    $("#reg").on('click', '.modal-footer .btn-primary', function(e) {
    	$('a[data-toggle="tab"]').each(function(e){
    		if($(this).parent().attr("class") == 'active'){
    			if ($(this).attr("href") == '#tab-ebs'){
            		var sendInfo = {
           				description:{
           					jobId: $('#tab-ebs').find('#jobId').val(),
           					triggerName: $('#tab-ebs').find('#triggerName').val(),
           					actionName: $('#tab-ebs').find('#actionName').val(),
           		   			awsName: $('#tab-ebs').find('#awsName').val(),
           		   			sys:{
           		   				modalId: '',
           		   			  	rh: '',
           		   			  	mail: '1',
           		   				ebs:{
           		   					profileName: $('#tab-ebs').find('#awsName').val(),
           		   				  	region: $('#tab-ebs').find('#region').val(),
           		   				  	volumeId: $('#tab-ebs').find('#volume').val()
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
	
	$("#tab-ebs #actionName").change(function () {
		console.debug($(this).val());
/*		if ('ebs-authorizeSecurityGroupIngress' ==  $(this).val()){
		  $('#tab-ebs').find('#instance').prop("disabled",true);
		}
		else{
		  $('#tab-ebs').find('#instance').prop("disabled",false);
		}
*/
	});

	$("#tab-ebs #awsName").change(function () {
		$("#tab-ebs #region").val("cn-north-1");
        $('#tab-ebs #volume').children().remove();
	});
	$("#tab-ebs #region").change(function () {
		var region = $("#tab-ebs #region").val();
		var awsName = $("#tab-ebs #awsName").val();
		console.debug(region);
    	$.ajax({
  	        type:"GET",
  	        url:"/cloud-tool/v1/api/ebs/volumes",
  	        data:{awsName:awsName,region:region},
  	        contentType: 'application/json',
  	        dataType: "json"
    	}).done(function(json, status, xhr) {
	       	console.log("success : "+json);
        	console.log(json);
            $('#tab-ebs #volume').children().remove();
            $.each(json, function(key, value) {
                $('#tab-ebs #volume').append("<option value='" + key + "'>" + value + "</option>");
            });
    	}).fail(function(xhr, status, error){
          	alert("Server Error. Pleasy try again later.");
        }).always(function(arg1, status, arg2) {
           	console.log("done");
  	  	});
    });
});
/*]]>*/