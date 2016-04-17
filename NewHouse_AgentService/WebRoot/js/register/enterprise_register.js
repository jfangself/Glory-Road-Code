$().ready(function() {
	$("#enterprise_register").validate({
		rules : {
			shopId : {
				required : true,
				digits : true
			}
		}
	});
});