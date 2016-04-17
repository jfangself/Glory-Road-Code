$().ready(function() {
	$("#withdraw_detail").validate({
		rules : {
			settle_id : {
				required : true,
				digits : true
			}
		}
	});
});