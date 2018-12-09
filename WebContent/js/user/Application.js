var application = angular.module("Application", [ "ngRoute" ]);

application.config([ '$routeProvider', function(routeProvider) {
	routeProvider.when('/register', {
		templateUrl : 'partials/registerDomain.html',
		controller : 'DomainRegistrationController'
	}).otherwise({
		redirectTo : '/'
	});
} ]);

application.filter('DomainFilter', function() {

	return function(input) {
		if (input==".in") {
			 return "India";
		}
		if (input==".com") {
			return "commercial";
		}
		if (input==".org") {
			return "organization";
		}
		if (input==".net") {
			return "network";
		}
	};

});

var URI = getURI();
