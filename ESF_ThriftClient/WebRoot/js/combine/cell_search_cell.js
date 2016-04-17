$().ready(function() {
	$("#cell_search_cell").validate({
		rules : {
			keyword : {
				required : true,
			},
			cityId : {
				required : true,
				digits : true
			}
		}
	});
});