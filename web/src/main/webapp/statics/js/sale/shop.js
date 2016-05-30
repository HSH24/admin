myApp.onPageInit('sale.shop', function(page) {
	myApp.picker({
				input : '#sale/shop/date',
				rotateEffect : true,
				formatValue : function(p, values, displayValues) {
					return values[0] + '年' + values[1] + '月';
				},
				cols : [{
							values : ['2015', '2016', '2017'],
							displayValues : ['2015年', '2016年', '2017年'],
							textAlign : 'right',
							width : 1000
						}, {
							values : ['1', '2', '3', '4', '5', '6', '7', '8',
									'9', '10', '11', '12'],
							displayValues : ['1月', '2月', '3月', '4月', '5月',
									'6月', '7月', '8月', '9月', '10月', '11月', '12月'],
							textAlign : 'left',
							width : 1000
						}],
				onOpen : function(p) {
					p.setValue([$$('#sale/shop/year').val(),
							$$('#sale/shop/month').val()]);
				},
				onClose : function(p) {
					$$('#sale/shop/year').val(p.value[0]);
					$$('#sale/shop/month').val(p.value[1]);
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