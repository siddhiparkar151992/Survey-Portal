(function() {
	'use strict';
	angular.module('home', []).controller('HomeController',
			function($scope, $rootScope) {
				$scope.message = 'Check out the surveys @ Xoriant!!';
				$rootScope.pageClass = 'home';
			});
})();