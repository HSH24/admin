myApp.onPageInit('sale.shop', function(page) {
			myApp.picker({
						input : '#sale/shop/date',
						rotateEffect : true,
						cols : [{
									textAlign : 'left',
									values : ['2015年', '2016年']
								}, {
									values : ['1月', '2月', '3月', '4月', '5月',
											'6月', '7月', '8月', '9月', '10月',
											'11月', '12月']
								}],
						onChange : function(p, values, displayValues) {
							// $$('#sale/shop/month').html(values[1] + '月');
							// $$('#sale/shop/year').html(values[0] + '年');
						},
						onOpen : function(p) {
							p.setValue(['2015年', '5月']);
						}
					});

			sale_shop_stats();
		});

function sale_shop_stats() {
	$$.get(appUrl + '/sale/stats.htm', {}, function(data) {
				var stats = data.split("&");
				$$('#sale/shop/a').html(stats[0]);
				$$('#sale/shop/b').html(stats[1]);
			});
}