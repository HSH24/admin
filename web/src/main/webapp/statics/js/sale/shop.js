var sale_shop_flag = true;

myApp.onPageInit('sale.shop', function(page) {

			myPicker = myApp.picker({
						input : '#picker-year-month',
						closeByOutsideClick : false,
						rotateEffect : true,
						cols : [{
									textAlign : 'left',
									values : ['2015年', '2016年']
								}, {
									values : ['1月', '2月', '3月', '4月', '5月',
											'6月', '7月', '8月', '9月', '10月',
											'11月', '12月']
								}],
						onChange : function(picker, values, displayValues) {
							var a = 1;
						}
					});

			$$('#picker-year-month').on('click', function() {
						myPicker.open();
						sale_shop_flag = false;
					});

			$$('.page-content').on('click', function() {
						if (sale_shop_flag) {
							myPicker.close();
						} else {
							sale_shop_flag = true;
						}

					});

			sale_shop_stats();
		});

myApp.onPageBack('sale.shop', function(page) {
			myPicker.close();
		});

function sale_shop_stats() {
	$$.get(appUrl + '/sale/stats.htm', {}, function(data) {
				var stats = data.split("&");
				$$('#sale/shop/a').html(stats[0]);
				$$('#sale/shop/b').html(stats[1]);
			});
}