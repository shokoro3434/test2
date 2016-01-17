/* <![CDATA[ */ 
var ec2= function(modal,json){
    modal.find('.modal-body .recipient').text("");
		modal.find('.modal-body .recipient').append("<li>/</li>");
		modal.find('.modal-body .recipient').append("<ul class=\"root\">");
		modal.find('.modal-body .recipient .root').append("<li>status:"+json.state.name+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>instanceId:"+json.instanceId+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>vpcId : "+json.vpcId+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>subnetId : "+json.subnetId+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>privateIpAddress : "+json.privateIpAddress+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>name : "+json.tags[0].value+"</li>");
		modal.find('.modal-body .recipient').append("</ul>");

};
var ec2_SS= function(modal,json){
	modal.find('.modal-body .recipient').text("");
		modal.find('.modal-body .recipient').append("<li>/</li>");
		modal.find('.modal-body .recipient').append("<ul class=\"root\">");
		modal.find('.modal-body .recipient .root').append("<li>snapshotId:"+json.snapshotId+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>volumeId:"+json.volumeId+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>state:"+json.state+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>description:"+json.description+"</li>");
		modal.find('.modal-body .recipient').append("</ul>");
};
var ec2_AMI= function(modal,json){
		modal.find('.modal-body .recipient').text("");
			modal.find('.modal-body .recipient').append("<li>/</li>");
			modal.find('.modal-body .recipient').append("<ul class=\"root\">");
			modal.find('.modal-body .recipient .root').append("<li>imageId:"+json.imageId+"</li>");
			modal.find('.modal-body .recipient .root').append("<li>status:"+json.state+"</li>");
			modal.find('.modal-body .recipient .root').append("<li>ebs-snapshotId:"+json.blockDeviceMappings[0].ebs.snapshotId+"</li>");
			modal.find('.modal-body .recipient .root').append("<li>name:"+json.name+"</li>");
			modal.find('.modal-body .recipient').append("</ul>");
};
var rds= function(modal,json){
		modal.find('.modal-body .recipient').text("");
		modal.find('.modal-body .recipient').append("<li>/</li>");
		modal.find('.modal-body .recipient').append("<ul class=\"root\">");
		modal.find('.modal-body .recipient .root').append("<li>status:"+json.DBInstanceStatus+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>availabilityZone:"+json.availabilityZone+"</li>");
		modal.find('.modal-body .recipient').append("</ul>");
};
var rds_SS= function(modal,json){
		modal.find('.modal-body .recipient').text("");
		modal.find('.modal-body .recipient').append("<li>/</li>");
		modal.find('.modal-body .recipient').append("<ul class=\"root\">");
		modal.find('.modal-body .recipient .root').append("<li>status:"+json.status+"</li>");
		modal.find('.modal-body .recipient .root').append("<li>availabilityZone:"+json.availabilityZone+"</li>");
		modal.find('.modal-body .recipient').append("</ul>");
};
/*]]>*/