/* <![CDATA[ */ 
  $(document).ready( function() {
//	  $('#modifyButton').on('click', function() {
//	        $('#modify').modal();
//	  });
	  $('#mod-rds').on('show.bs.modal', function(event) {
		  var button = $(event.relatedTarget);
	  	  var json = button.data('description');
	  	  console.debug(json);
	  	  var description = stringify(json);
		  var awsName = json.awsName;
	      var arn = button.data('arn');

		  $(this).find('#jobId').val(json.jobId);
		  $(this).find('#triggerName').val(json.triggerName);
		  $(this).find('#actionName').val(json.actionName);
		  $(this).find('#awsName').val(json.awsName);
		  var region = json.sys.rds.region;
		  $(this).find('#region').val(region);
	    	$.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/rds/instances",
	  	        data:{awsName:awsName,region:region},
	  	        contentType: 'application/json', // リクエストの Content-Type
	  	        dataType: "json"           // レスポンスをJSONとしてパースする
	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
	        	console.log(json);
	            $('#mod-rds #instance').children().remove();
	            $.each(json, function(key, value) {
	                $('#mod-rds #instance').append("<option value='" + key + "'>" + value + "</option>");
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
	            $('#mod-rds #snapshot').children().remove();
	            $.each(json, function(key, value) {
	                $('#mod-rds #snapshot').append("<option value='" + key + "'>" + value + "</option>");
	            });
	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
	  	  	});


	      if('rds' in json.sys){
			    $(this).find('#triggerName').prop("disabled",true);
			    $(this).find('#actionName').prop("disabled",true);
			    $(this).find('#awsName').prop("disabled",true);
			}

		  $(this).find('#description').val(description);
		  $(this).find('#arn').val(arn);

  	    });
	  $('#mod-rds').on('hidden.bs.modal', function () {
     		$('#mod-rds').find('#error').text("");
	  });
	  $('#mod-rds').on('click', '.modal-footer .btn-primary', function(e) {
		  console.debug("test");
		  var description = $('#mod-rds').find('#description').val();
		  var json = $.parseJSON(description);
		  var arn = $('#mod-rds').find('#arn').val();

		  console.debug(json);
		  
		  var sendInfo = {
		  	arn: arn,
		  	description:{
			  	triggerName: $('#mod-rds').find('#triggerName').val(),
			  	actionName: $('#mod-rds').find('#actionName').val(),
			  	jobId: $('#mod-rds').find('#jobId').val(),
			  	awsName: $('#mod-rds').find('#awsName').val(),
			  	sys:{
			  		modalId: json.sys.modalId,
			  		modModalId: json.sys.modModalId,
			  		rh: '',
			  		mail: json.sys.mail,
				  	rds:{
				  		profileName: $('#mod-rds').find('#awsName').val(),
				  		region: $('#mod-rds').find('#region').val(),
				  		instance: $('#mod-rds').find('#instance').val(),
				  		snapshot: $('#mod-rds').find('#snapshot').val()
				  	},
			  	},
			  },
		  };
		  console.debug(sendInfo);
	      $.ajax({
	      	type:"PUT",
	        url:"/cloud-tool/v1/api/lambda",
	        data:stringify(sendInfo),
	        contentType: 'application/json',
	        dataType: "json",
	      }).done(function(data, status, xhr) {
	          	console.log("done : "+data);
	           	console.log(data);
	            $('#mod-rds').modal('hide');
	        	$('#job-table').bootstrapTable('refresh');
	      }).fail(function(xhr, status, error){
	           	console.log(status);
	           	console.log(xhr.status);
	           	console.log(xhr.statusText);
	           	if (xhr.status == 400){
	           		//validation failed
	           		console.log(400);
	           		console.log(xhr.responseText);
	           		$('#mod-rds').find('#error').text(xhr.responseText);
	           	}
	  	  }).always(function(arg1, status, arg2) {
	           	console.log("done");
	  	  });
	    });
  });

/*]]>*/