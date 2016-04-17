$().ready(function() {
	$("#agent_newValuation").validate({
		rules : {
			OwnerId : {
				required : true,
				digits : true
			},
			HouseId : {
				required : true,
				digits : true
			},
			AgentId : {
				required : true,
				digits : true
			},
			Price : {
				required : true,
				number : true
			},
			CellMinPrice : {
				required : true,
				number : true
			},
			CellMaxPrice : {
				required : true,
				number : true
			},
			Reason : {
				required : true,
			}
		}
	});
});