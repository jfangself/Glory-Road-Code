$().ready(function() {
	$("#receive_pay_result").validate({
		rules : {
			withdraw_id : {
				required : true
			},
			result : {
				required : true,
				digits : true
			}
		}
	});
});