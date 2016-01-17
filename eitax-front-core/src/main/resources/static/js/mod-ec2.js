/* <![CDATA[ */ 
  $(document).ready( function() {
	  $('#mod-ec2Button').on('click', function() {
	        $('#mod-ec2').modal();
	  });
	  $('#mod-ec2').on('show.bs.modal', function(event) {
		  var button = $(event.relatedTarget);
/*		  $('a[data-toggle="tab"]').each(function(e){
			  $(this).parent().removeClass("disabled");
			  $(this).parent().removeClass("active");

		  	  console.debug("##########"+$(this).attr("href"));
			  if ($(this).attr("href") != tabId){
				  $(this).parent().addClass("disabled");
    		  }
			  else{
				  $(this).parent().addClass("active");
			  }
	      });
*/
	  	  //$(tabId).trigger('click');
  	    	
	  	  var json = button.data('description');
	  	  console.debug(json);
	  	  var description = stringify(json);
		  $(this).find('#description').val(description);
		  $(this).find('#jobId').val(json.jobId);
	      var arn = button.data('arn');
		  $(this).find('#arn').val(arn);
		  console.debug(json.actionName);
		  $(this).find('#awsName').val(json.awsName);
		  var awsName = json.awsName;
		  $('#mod-ec2 #actionName option').filter(function(index){
				return $(this).text() === json.actionName; 
			}).prop('selected', true);
		  
		  $(this).find('#triggerName').val(json.triggerName);
		  if ('ec2' in json.sys){
			  var region = json.sys.ec2.region;
			  $(this).find('#region').val(json.sys.ec2.region);
		  }
		  else if('sg' in json.sys){
			  var region = json.sys.sg.region;
			  $(this).find('#region').val(region);
		  }
		  else if('rds' in json.sys){
			  $(this).find('#region').val(json.sys.rds.region);
		  }
		  $(this).find('#triggerName').prop("disabled",true);
		  $(this).find('#actionName').prop("disabled",true);
		  $(this).find('#awsName').prop("disabled",true);
	    	$.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/ec2/instances",
	  	        data:{awsName:awsName,region:region},
	  	        contentType: 'application/json',
	  	        dataType: "json"
  	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
  	        	console.log(json);
                $('#mod-ec2 #instance').children().remove();
                $.each(json, function(key, value) {
                    $('#mod-ec2 #instance').append("<option value='" + key + "'>" + value + "</option>");
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
                $('#mod-ec2 #image').children().remove();
                $.each(json, function(key, value) {
                    $('#mod-ec2 #image').append("<option value='" + key + "'>" + value + "</option>");
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
                $('#mod-ec2 #snapshot').children().remove();
                $.each(json, function(key, value) {
                    $('#mod-ec2 #snapshot').append("<option value='" + key + "'>" + value + "</option>");
                });
  	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
  	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
  	  	  	});
  	    });
	  $('#mod-ec2').on('hidden.bs.modal', function () {
     		$('#mod-ec2').find('#error').text("");
	  });
	  $('#mod-ec2').on('click', '.modal-footer .btn-primary', function(e) {
		  var description = $('#mod-ec2').find('#description').val();
		  var json = $.parseJSON(description);
		  var arn = $('#mod-ec2').find('#arn').val();

		  var sendInfo = {
		  	arn: arn,
		  	description:{
			  	triggerName: $('#mod-ec2').find('#triggerName').val(),//json.triggerName,
			  	actionName: $('#mod-ec2').find('#actionName').val(),
			  	jobId: $('#mod-ec2').find('#jobId').val(),
			  	awsName: $('#mod-ec2').find('#awsName').val(),
			  	sys:{
			  		modalId: json.sys.modalId,
			  		rh: json.sys.rh,
			  		mail: json.sys.mail,
				  	ec2:{
				  		profileName: json.sys.ec2.profileName,
				  		region: json.sys.ec2.region,
				  		instanceIds: json.sys.ec2.instanceIds
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
	            $('#mod-ec2').modal('hide');
	        	$('#job-table').bootstrapTable('refresh');
	      }).fail(function(xhr, status, error){
	           	console.log(status);
	           	console.log(xhr.status);
	           	console.log(xhr.statusText);
	           	if (xhr.status == 400){
	           		//validation failed
	           		console.log(400);
	           		console.log(xhr.responseText);
	           		$('#mod-ec2').find('#error').text(xhr.responseText);
	           	}
	  	  }).always(function(arg1, status, arg2) {
	           	console.log("done");
	  	  });
	    });
  });

/*]]>*/