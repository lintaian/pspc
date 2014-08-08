require.config({
	baseUrl: 'js',
	paths: {
		jquery: 'lib/jquery',
		jqueryMobile: 'lib/jquery.mobile-1.4.3',
		login2: 'custom/login'
	},
	shim: {
		login2: {deps: ['jquery']},
		jqueryMobile: {deps: ['jquery', 'login2']}
	}
});
require(['jquery', 'login2'], function($) {
	$.mobile.changePage('content.html')
	$(document).bind("mobileinit", function () {
	   $.mobile.autoInitializePage = false; 
	});

});
require(['jqueryMobile'], function() {
	 $.mobile.initializePage();
});