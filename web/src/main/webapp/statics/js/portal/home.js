// Initialize your app
var myApp = new Framework7({
			animateNavBackIcon : true,
			animatePages : Framework7.prototype.device.ios,
			swipePanel : 'left',
			modalButtonOk : '确认',
			modalButtonCancel : '取消',
			imagesLazyLoadPlaceholder : imgUrl + '/image/loading.png',
			// Hide and show indicator during ajax requests
			onAjaxStart : function(xhr) {
				myApp.showIndicator();
			},
			onAjaxComplete : function(xhr) {
				myApp.hideIndicator();
			}
		});

// Export selectors engine
var $$ = Dom7;

// Add view
var mainView = myApp.addView('.view-main', {
			// Because we use fixed-through navbar we can enable dynamic navbar
			dynamicNavbar : true
		});
$$('#href-1').on('click', function() {
			portal_home_stats();
		});

// ==============================

var view3 = myApp.addView('#view-3', {
			dynamicNavbar : true
		});
$$('#href-3').on('click', function() {
			if (view3.history.length == 1) {
				view3.router.load({
							url : appUrl + "/shop/list.htm",
							ignoreCache : true,
							reload : true
						});
			}
		});

var view5 = myApp.addView('#view-5', {
			dynamicNavbar : true
		});
$$('#href-5').on('click', function() {
			if (view5.history.length == 1) {
				view5.router.load({
							url : appUrl + "/member/index.htm"
						});
			} else {
				// 刷新
				member_index_stats();
			}
		});

$$('#view_3_click').on('click', function() {
			if (view3.history.length == 1) {
				view3.router.load({
							url : appUrl + "/shop/list.htm",
							ignoreCache : true,
							reload : true
						});
			}

			$$('#href-3').addClass("active");
		});

// ==============================

// 异步统计

function portal_home_stats() {
	$$.get(appUrl + '/sale/stats.htm', {}, function(data) {
				var stats = data.split("&");
				$$('#portal/home/sale').html('今天：' + stats[0] + '<br/>本月：'
						+ stats[1]);
			});

	$$.get(appUrl + '/cashflow/stats.htm', {}, function(data) {
				var stats = data.split("&");
				$$('#portal/home/cashflow').html('保证金：50,000<br/>余额：'
						+ stats[2]);
			});

	$$.get(appUrl + '/stock/stats.htm', {}, function(data) {
				$$('#portal/home/stock').html('数量：<br/>' + data);
			});

	$$.get(appUrl + '/trade/stats.htm', {
				type : 'tosend'
			}, function(data) {
				var stats = data.split("&");
				$$('#portal/home/trade/tosend').html('金额：' + stats[0]
						+ '<br/>订单：' + stats[1]);
			});

	$$.get(appUrl + '/shop/stats.htm', {}, function(data) {
				var stats = data.split("&");
				$$('#portal/home/shop').html('新开：' + stats[0] + '<br/>总计：'
						+ stats[1]);
			});
}

portal_home_stats();

myApp.onPageInit('portal.home', function(page) {
			portal_home_stats();
		})