/* <![CDATA[ */ 

	//exec
  	$(document).ready( function() {
  	// JavaScript で表示
  		$('#execButton').on('click', function() {
  	    	$('#exec').modal();
  	    });
  	    
  	    $('#exec').on('show.bs.modal', function(event) {
  	    	$('#loading').show() 
  	    	var button = $(event.relatedTarget);
  	      	var arn = button.data('arn');
  	      	var description = stringify(button.data('description'));
	        	console.log("###########"+description);
  	  	  	var modal = $(this)  //モーダルを取得
  	    	$.ajax({
	  	        type:"GET",                // method = "POST"
	  	        url:"/cloud-tool/v1/api/invoke",        // POST送信先のURL
	  	        data:{arn:arn,description:description},  // JSONデータ本体
	  	        contentType: 'application/json', // リクエストの Content-Type
	  	        dataType: "json"           // レスポンスをJSONとしてパースする
  	    	}).done(function(json, status, xhr) {
		       	console.log("success : "+json);
  	        	console.log(json);
  	  			modal.find('.modal-body .recipient').text("");
  	  			modal.find('.modal-body .recipient').append("<li>/</li>");
  	  			modal.find('.modal-body .recipient').append("<ul class=\"root\">");
  	  			modal.find('.modal-body .recipient .root').append("<li>result:"+json.message+"</li>");
  	  			modal.find('.modal-body .recipient .root').append("<li>startDateTime:"+json.startDateTime+"</li>");
  	  			modal.find('.modal-body .recipient .root').append("<li>endDateTime:"+json.endDateTime+"</li>");
  	  			modal.find('.modal-body .recipient').append("</ul>");
  			    //modal.find('.modal-body .recipient').append("<p>status : "+json.DBInstanceStatus+"</p>");
  	        	console.log("###########");
  				console.log(json);
  	    	}).fail(function(xhr, status, error){
	          	alert("Server Error. Pleasy try again later.");
  	        }).always(function(arg1, status, arg2) {
	           	console.log("done");
            	$('#loading').hide() 
  	  	  	});
    	});
        // ダイアログ表示直後にフォーカスを設定する
      	$('#exec').on('shown.bs.modal', function(event) {
        	$(this).find('.modal-footer .btn-default').focus();
      	});
  		$('#exec').on('hidden.bs.modal', function () {
      		$('#exec').find('.modal-body .recipient').text("");
  		});
      	$('#exec').on('click', '.modal-footer .btn-primary', function() {
      	});

  	});
/*]]>*/
