

function alreadywork(id) {
    var dataFormJson = {'orderId':id}
	$.ajax({
		cache : true,
		type : "POST",
		url : rootPath + "/OperatorController/alreadwork",
		data : dataFormJson,
		async : false,
		error : function(request) {
			$.modal.alertError("系统错误");
		},
		success : function(data) {
			$.operate.saveSuccess(data);
		}
	});
}
function fire_setoff(id) {
    var dataFormJson = {'deviceId':id}
    $.ajax({
        cache : true,
        type : "POST",
        url : rootPath + "/DeviceController/setfireoff",
        data : dataFormJson,
        async : false,
        error : function(request) {
            $.modal.alertError("系统错误");
        },
        success : function(data) {
            $.operate.saveSuccess(data);
        }
    });
}
