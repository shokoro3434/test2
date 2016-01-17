/* <![CDATA[ */ 
  //static
$(document).ready( function() {
    // JavaScript で表示
  	$('#staticButton').on('click', function() {
    	$('#static').modal();
    });
    
    $('#static').on('show.bs.modal', function(event) {
    	$('#loading').show() 
    	var button = $(event.relatedTarget);
      	var arn = button.data('arn');
      	var description = stringify(button.data('description'));
      	var json2 = button.data('description');
      	console.debug(json2.sys.rh);
  	  	var modal = $(this)  //モーダルを取得
	    $.ajax({
	        type:"GET",                // method = "POST"
	        url:"/cloud-tool/v1/api/invoke",        // POST送信先のURL
	        data:{arn:arn,description:description},  // JSONデータ本体
	        contentType: 'application/json', // リクエストの Content-Type
	        dataType: "json",           // レスポンスをJSONとしてパースする
	    }).done(function(json, status, xhr) {
		       	console.log("success : "+stringify(json));
	        	eval(json2.sys.rh+"(modal,json)");
	    }).fail(function(xhr, status, error){
    	      	alert("Server Error. Pleasy try again later.");
	    }).always(function(arg1, status, arg2) {
        	   	console.log("done");
            	$('#loading').hide() 
	  	});
    });
   // ダイアログ表示直後にフォーカスを設定する
   	$('#static').on('shown.bs.modal', function(event) {
     	$(this).find('.modal-footer .btn-default').focus();
   	});
	$('#static').on('hidden.bs.modal', function () {
  		$('#static').find('.modal-body .recipient').text("");
	});
   	$('#static').on('click', '.modal-footer .btn-primary', function() {
   	});

});

/*]]>*/
