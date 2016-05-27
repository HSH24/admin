myApp.onPageInit('cashflow.shop', function(page) {
			cashflow_shop_stats();
		});

function cashflow_shop_stats() {
	$$.get(appUrl + '/cashflow/stats.htm', {}, function(data) {
				var stats = data.split("&");
				$$('#cashflow/shop/b').html(stats[1]);
				$$('#cashflow/shop/curBal').html(stats[2]);
			});
}