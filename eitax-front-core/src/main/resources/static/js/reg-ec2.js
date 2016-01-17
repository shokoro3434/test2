/* <![CDATA[ */ 
//register
  	$(document).ready( function() {
  	    $("#reg").on('click', '.modal-footer .btn-primary', function(e) {
	    	$('a[data-toggle="tab"]').each(function(e){
   	    		if($(this).parent().attr("class") == 'active'){
   	    			if ($(this).attr("href") == '#tab-ec2'){
	          	    	console.debug("event has occurred.");
	            		var sendInfo = {
	        		   		description:{
	        		   			triggerName: $('#reg').find('#triggerName').val(),
	        		   			actionName: $('#reg').find('#actionName').val(),
	        		   			jobId: $('#reg').find('#jobId').val(),
	        		   			awsName: $('#reg').find('#awsName').val(),
	        		   			sys:{
	        		   				modalId: 'static',
	        		   			  	rh: 'ec2',
	        		   			  	mail: '1',
	        		   				ec2:{
	        		   					profileName: $('#reg').find('#awsName').val(),
	        		   				  	region: $('#reg').find('#region').val(),
	        		   				  	instanceIds: [$('#reg').find('#instance').val()],
	//        		   				  	groupId: $('#reg').find('#groupId').val(),
	//        		   				  	ipProtocol: $('#reg').find('#ipProtocol').val(),
	//        		   				  	port: $('#reg').find('#port').val(),
	//        		   				  	cidr: $('#reg').find('#cidr').val()
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
	    	  	            $('#reg').modal('hide');
	  	    	          	$('#job-table').bootstrapTable('refresh');
	        	    	}).fail(function(xhr, status, error){
		      	          	alert("Server Error. Pleasy try again later.");
	        	        }).always(function(arg1, status, arg2) {
	    	  	           	console.log("done");
	        	  	  	});
   	    			}
    			}
        	});
  	    });  	    	
  		$("#tab-ec2 #actionName").change(function () {
  			console.debug($(this).val());
  			if ('ec2-authorizeSecurityGroupIngress' ==  $(this).val()){
  			  $('#tab-ec2').find('#instance').prop("disabled",true);
  			  $('#tab-ec2').find('#image').prop("disabled",true);
  			  $('#tab-ec2').find('#snapshot').prop("disabled",true);
  			}
  			else{
   			  $('#tab-ec2').find('#instance').prop("disabled",false);
   			  $('#tab-ec2').find('#image').prop("disabled",false);
   			  $('#tab-ec2').find('#snapshot').prop("disabled",false);
  			}
  		});

  		$("#tab-ec2 #awsName").change(function () {
    		$("#tab-ec2 #region").val("cn-north-1");
            $('#tab-ec2 #instance').children().remove();
            $('#tab-ec2 #image').children().remove();
            $('#tab-ec2 #snapshot').children().remove();
//            $('#tab-ec2 #groupId').children().remove();
  		});
  		$("#tab-ec2 #region").change(function () {
    		var region = $("#tab-ec2 #region").val();
    		var awsName = $("#tab-ec2 #awsName").val();
    		console.debug(region);
  	    	$.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/ec2/instances",
	  	        data:{awsName:awsName,region:region},
	  	        contentType: 'application/json', // リクエストの Content-Type
	  	        dataType: "json"           // レスポンスをJSONとしてパースする
  	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
  	        	console.log(json);
                $('#tab-ec2 #instance').children().remove();
                $.each(json, function(key, value) {
                    $('#tab-ec2 #instance').append("<option value='" + key + "'>" + value + "</option>");
                });
  	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
  	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
  	  	  	});
  	    	$.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/ec2/images",
	  	        data:{awsName:awsName,region:region},
	  	        contentType: 'application/json',
	  	        dataType: "json"
  	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
  	        	console.log(json);
                $('#tab-ec2 #image').children().remove();
                $.each(json, function(key, value) {
                    $('#tab-ec2 #image').append("<option value='" + key + "'>" + value + "</option>");
                });
  	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
  	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
  	  	  	});
  	    	$.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/ec2/snapshots",
	  	        data:{awsName:awsName,region:region},
	  	        contentType: 'application/json',
	  	        dataType: "json"
  	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
  	        	console.log(json);
                $('#tab-ec2 #snapshot').children().remove();
                $.each(json, function(key, value) {
                    $('#tab-ec2 #snapshot').append("<option value='" + key + "'>" + value + "</option>");
                });
  	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
  	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
  	  	  	});
  	    });
  	});
/*]]>*/