/* <![CDATA[ */ 
//register
$(document).ready( function() {
    $("#reg").on('click', '.modal-footer .btn-primary', function(e) {
    	$('a[data-toggle="tab"]').each(function(e){
    		if($(this).parent().attr("class") == 'active'){
    			if ($(this).attr("href") == '#tab-sg'){
            		var sendInfo = {
           				description:{
           					jobId: $('#tab-sg').find('#jobId').val(),
           					triggerName: $('#tab-sg').find('#triggerName').val(),
           					actionName: $('#tab-sg').find('#actionName').val(),
           		   			awsName: $('#tab-sg').find('#awsName').val(),
           		   			sys:{
           		   				modalId: '',
           		   			  	rh: '',
           		   			  	mail: '1',
           		   				sg:{
           		   					profileName: $('#tab-sg').find('#awsName').val(),
           		   				  	region: $('#tab-sg').find('#region').val(),
           		   				  	groupId: $('#tab-sg').find('#groupId').val(),
           		   				  	ipProtocol: $('#tab-sg').find('#ipProtocol').val(),
           		   				  	port: $('#tab-sg').find('#port').val(),
           		   				  	cidr: $('#tab-sg').find('#cidr').val()
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
	
	$("#tab-sg #actionName").change(function () {
		console.debug($(this).val());
/*		if ('sg-authorizeSecurityGroupIngress' ==  $(this).val()){
		  $('#tab-sg').find('#instance').prop("disabled",true);
		}
		else{
		  $('#tab-sg').find('#instance').prop("disabled",false);
		}
*/
	});

	$("#tab-sg #awsName").change(function () {
		$("#tab-sg #region").val("cn-north-1");
        $('#tab-sg #groupId').children().remove();
	});
	$("#tab-sg #region").change(function () {
		var region = $("#tab-sg #region").val();
		var awsName = $("#tab-sg #awsName").val();
		console.debug(region);
    	$.ajax({
  	        type:"GET",
  	        url:"/cloud-tool/v1/api/ec2/sg",
  	        data:{awsName:awsName,region:region},
  	        contentType: 'application/json',
  	        dataType: "json"
    	}).done(function(json, status, xhr) {
	       	console.log("success : "+json);
        	console.log(json);
            $('#tab-sg #groupId').children().remove();
            $.each(json, function(key, value) {
                $('#tab-sg #groupId').append("<option value='" + key + "'>" + value + "</option>");
            });
    	}).fail(function(xhr, status, error){
          	alert("Server Error. Pleasy try again later.");
        }).always(function(arg1, status, arg2) {
           	console.log("done");
  	  	});
    });
});
/*]]>*/