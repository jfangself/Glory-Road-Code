$().ready(function() {
	$("#withdraw_audit").validate({
		rules : {
			settle_id : {
				required : true,
				digits : true
			},
			status : {
				required : true,
				digits : true
			},
			oper_user_id : {
				required : true,
				digits : true
			},
			oper_user_name : {
				required : true,
			},
			oper_role : {
				required : true,
			},
			oper_mobile : {
				required : true,
			}
		}
	});
});