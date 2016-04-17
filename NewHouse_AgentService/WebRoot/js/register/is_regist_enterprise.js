$().ready(function() {
	$("#is_regist_enterprise").validate({
		rules : {
			shopIdList : {
				required : true,
			}
		}
	});
});