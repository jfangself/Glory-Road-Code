$().ready(function() {
	$("#get_account_trade_record").validate({
		rules : {
			user_id : {
				required : true,
				digits : true
			},
			trade_type : {
				required : true,
				digits : true
			},
			start_time : {

			},
			end_time : {

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