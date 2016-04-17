$().ready(function() {
	$("#withdraw_oper_list").validate({
		rules : {
			settle_id : {
				required : true,
				digits : true
			}
		}
	});
});