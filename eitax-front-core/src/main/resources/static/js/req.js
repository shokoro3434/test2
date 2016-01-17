/* <![CDATA[ */ 
	//request schedule
  	$(document).ready( function() {
        $('#request #time').timepicker();

  	    $("#request").on('click', '.modal-footer .btn-primary', function(e) {
    		var jobId = $("#request #jobId").val();
    		var time = $("#request #time").val();
    		var cronType = $("#request #cronType").val();
    		var note = $("#request #note").val();
    		console.debug(jobId);
    		console.debug(time);
    		console.debug(cronType);
    		console.debug(note);
  	    	$.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/lambda/schedules",
	  	        data:{jobId:jobId,time:time,cronType:cronType,note:note},
	  	        contentType: 'application/json',
	  	        dataType: "json"
  	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
  	        	console.log(json);
  	            $('#request').modal('hide');
  	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
  	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
  	  	  	});
  	    });
  	    $('#request').on('show.bs.modal', function(event) {
  	    	var button = $(event.relatedTarget);
  	      	var arn = button.data('arn');
  	      	var description = stringify(button.data('description'));
	        	console.log("###########"+description);
  	  	  	var modal = $(this)  //モーダルを取得
  	    	$.ajax({
	  	        type:"GET",
	  	        url:"/cloud-tool/v1/api/lambda/jobIds",
//	  	        data:,
	  	        contentType: 'application/json', // リクエストの Content-Type
	  	        dataType: "json"           // レスポンスをJSONとしてパースする
  	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
  	        	console.log(json);
                $('#request #jobId').children().remove();
                $.each(json, function(key, value) {
                    $('#request #jobId').append("<option value='" + key + "'>" + value + "</option>");
                });
  	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
  	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
  	  	  	});
    	});
        // ダイアログ表示直後にフォーカスを設定する
      	$('#request').on('shown.bs.modal', function(event) {
        	$(this).find('.modal-footer .btn-default').focus();
      	});
  		$('#request').on('hidden.bs.modal', function () {
     		//$('#exec').find('.modal-body .recipient').text("通信中..");
  		});
      	$('#request').on('click', '.modal-footer .btn-primary', function() {
      	});
  	});

/*]]>*/
