$().ready(function() {
	$("#house_search_house").validate({
		rules : {
			cityId : {
				required : true,
				digits : true
			},
			Property : {
				required : true,
				digits : true
			},
			cellId : {
				digits : true
			},
			pageNo : {
				digits : true
			},
			pageSize : {
				digits : true
			}
		}
	});
});