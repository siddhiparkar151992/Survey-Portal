/***	Common Elements - Header / Footer	***/
/** * Directives ** */
(function() {
	var app = angular.module('common-elements', []);
	app
	// Header directive
	.directive('appHeader', function() {
		return {
			restrict : 'E',
			templateUrl : 'includes/app-header.html'
		};
	})
	// Footer directive
	.directive('appFooter', function() {
		return {
			restrict : 'E',
			templateUrl : 'includes/app-footer.html'
		};
	})

	// Filters
	.filter('getById', function() {
		return function(input, id) {
			var i = 0, len = input.length;
			for (; i < len; i++) {
				if (+input[i].surveyId == +id) {
					return input[i];
				}
			}
			return null;
		};// Service
	}).service('commonService', function($http, $log) {

		return ({

		});

	})
})();
