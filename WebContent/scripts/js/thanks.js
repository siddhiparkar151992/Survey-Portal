(function() {

	angular.module('thanks', []).controller('ThanksController',
			function($scope, $rootScope) {
				$rootScope.pageClass = 'thanks';
			});
})();