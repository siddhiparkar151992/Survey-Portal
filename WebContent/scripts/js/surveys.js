(function() {
	var dataUrls = {
		surveys : '/XoriantSurveyPortal/Xoriant/Surveys'
	}, allSurveys = [];

	angular.module('surveys', []).service('surveyDataService',
			function($http, $log) {
				this.getSurveys = function() {
					return $http.get(dataUrls.surveys);
				};
			})
	// .filter(function() {
	// return function(input, start) {
	// start = parseInt(start, 10);
	// return input.slice(start);
	// };
	// })
	.controller(
			'SurveyController',
			function($scope, $log, surveyDataService, $stateParams, $state,
					$rootScope) {
				// $scope.surveysPerPage = 5;
				// $scope.currentPage = 1;
				$scope.surveys = allSurveys || [];
				$rootScope.pageClass = 'surveys';
				function init() {
					if (allSurveys.length === 0) {
						surveyDataService.getSurveys().then(loadSurveys);
					}

				}
				function loadSurveys(surveys) {
					// load survey list into UI
					$scope.surveys = allSurveys = surveys.data;

				}

				// Tried pagination , works for id with integer type.
				//
				// for (var i=1; i<50; i++) {
				// $scope.surveys.push({ surveyId: i, title: "title "+ i,
				// choice1: "choice1 " + i,choice2: "choice2 " + i });
				// }
				//				
				// $scope.range = function() {
				// var rangeSize = 5;
				// var ret = [];
				// var start;
				// start = $scope.currentPage;
				// if ( start > $scope.pageCount()-rangeSize ) {
				// start = $scope.pageCount()-rangeSize+1;
				// }
				// for (var i=start; i<start+rangeSize; i++) {
				// ret.push(i);
				// }
				// return ret;
				// };
				//				
				// $scope.prevPage = function() {
				// if ($scope.currentPage > 0) {
				// $scope.currentPage--;
				// }
				// };
				// $scope.prevPageDisabled = function() {
				// return $scope.currentPage === 0 ? "disabled" : "";
				// };
				// $scope.pageCount = function() {
				// return
				// Math.ceil($scope.surveys.length/$scope.surveysPerPage)-1;
				// };
				// $scope.nextPage = function() {
				// if ($scope.currentPage < $scope.pageCount()) {
				// $scope.currentPage++;
				// }
				// };
				// $scope.nextPageDisabled = function() {
				// return $scope.currentPage === $scope.pageCount() ? "disabled"
				// : "";
				// };
				// $scope.setPage = function(n) {
				// $scope.currentPage=n;
				// };
				//				
				//				
				//				
				//				
				//				
				//				

				init();
			});
})();