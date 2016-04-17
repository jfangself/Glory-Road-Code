$().ready(function() {
	$("#withdraw_list").validate({
		rules : {
			city_id : {
				digits : true
			},
			status : {
				required : true,
				digits : true
			},
			start_time : {

			},
			end_time : {

			},
			settle_id : {
				digits : true
			},
			page_index : {
				required : true,
				digits : true
			},
			page_size : {
				required : true,
				digits : true
			}
		}
	});

	$('#start_time').datepicker({
		changeMonth : true,
		changeYear : true,
		yearSuffix : '',
		maxDate : 0,
		yearRange : '1950:2020',

	});

	$('#end_time').datepicker({
		changeMonth : true,
		changeYear : true,
		yearSuffix : '',
		maxDate : 0,
		yearRange : '1950:2020',

	});
});