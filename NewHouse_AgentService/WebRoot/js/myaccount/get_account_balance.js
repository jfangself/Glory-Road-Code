$().ready(function() {
	$("#get_account_balance").validate({
		rules : {
			user_id : {
				required : true,
				digits : true
			}
		}
	});
});