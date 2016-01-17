/* <![CDATA[ */ 
  $(document).ready( function() {
//	  $('#modifyButton').on('click', function() {
//	        $('#modify').modal();
//	  });
	  $('#mod-sg').on('show.bs.modal', function(event) {
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
		  var region = json.sys.sg.region;
		  $(this).find('#region').val(region);
	      $.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/ec2/sg",
	  	        data:{awsName:awsName,region:region},
	  	        contentType: 'application/json',
	  	        dataType: "json"
	      }).done(function(json, status, xhr) {
		       	console.log("success : "+json);
	        	console.log(json);
	            $('#mod-sg #groupId').children().remove();
	            $.each(json, function(key, value) {
	                $('#mod-sg #groupId').append("<option value='" + key + "'>" + value + "</option>");
	            });
	      }).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
	      }).always(function(arg1, status, arg2) {
	           	console.log("done");
	      });
		  $(this).find('#groupId').val(json.sys.sg.groupId);
		  $(this).find('#ipProtocol').val(json.sys.sg.ipProtocol);
		  $(this).find('#port').val(json.sys.sg.port);
		  $(this).find('#cidr').val(json.sys.sg.cidr);

	      if('sg' in json.sys){
			    $(this).find('#triggerName').prop("disabled",true);
			    $(this).find('#actionName').prop("disabled",true);
			    $(this).find('#awsName').prop("disabled",true);
			}

		  $(this).find('#description').val(description);
		  $(this).find('#arn').val(arn);

  	    });
	  $('#mod-sg').on('hidden.bs.modal', function () {
     		$('#mod-sg').find('#error').text("");
	  });
	  $('#mod-sg').on('click', '.modal-footer .btn-primary', function(e) {
		  console.debug("test");
		  var description = $('#mod-sg').find('#description').val();
		  var json = $.parseJSON(description);
		  var arn = $('#mod-sg').find('#arn').val();

		  console.debug(json);
		  
		  var sendInfo = {
		  	arn: arn,
		  	description:{
			  	triggerName: $('#mod-sg').find('#triggerName').val(),
			  	actionName: $('#mod-sg').find('#actionName').val(),
			  	jobId: $('#mod-sg').find('#jobId').val(),
			  	awsName: $('#mod-sg').find('#awsName').val(),
			  	sys:{
			  		modalId: json.sys.modalId,
			  		modModalId: json.sys.modModalId,
			  		rh: '',
			  		mail: json.sys.mail,
				  	sg:{
				  		profileName: $('#mod-sg').find('#awsName').val(),
				  		region: $('#mod-sg').find('#region').val(),
				  		groupId: $('#mod-sg').find('#groupId').val(),
				  		ipProtocol: $('#mod-sg').find('#ipProtocol').val(),
				  		port: $('#mod-sg').find('#port').val(),
				  		cidr: $('#mod-sg').find('#cidr').val()
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
	            $('#mod-sg').modal('hide');
	        	$('#job-table').bootstrapTable('refresh');
	      }).fail(function(xhr, status, error){
	           	console.log(status);
	           	console.log(xhr.status);
	           	console.log(xhr.statusText);
	           	if (xhr.status == 400){
	           		//validation failed
	           		console.log(400);
	           		console.log(xhr.responseText);
	           		$('#mod-sg').find('#error').text(xhr.responseText);
	           	}
	  	  }).always(function(arg1, status, arg2) {
	           	console.log("done");
	  	  });
	    });
  });

/*]]>*/