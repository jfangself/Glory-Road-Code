$().ready(function() {
	$("#get_publish_time").validate({
		rules : {
			city_id : {
				required : true,
				digits : true
			}
		}
	});
});