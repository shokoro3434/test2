/* <![CDATA[ */ 
	//remove
	function removeJob(arn){
		console.debug(arn);
    	$.ajax({
  	        type:"DELETE",
  	        url:"/cloud-tool/v1/api/lambda/"+arn,
//  	        data:{arn},
  	        contentType: 'application/json', // リクエストの Content-Type
  	        dataType: "json"           // レスポンスをJSONとしてパースする
    	}).done(function(json, status, xhr) {
	       	console.log("success : "+json);
        	console.log(json);
        	$('#job-table').bootstrapTable('refresh');
    	}).fail(function(xhr, status, error){
          	alert("Server Error. Pleasy try again later.");
        }).always(function(arg1, status, arg2) {
           	console.log("done");
  	  	});
	}
/*]]>*/
