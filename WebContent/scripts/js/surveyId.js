(function() {
	var dataUrls = {
		surveysId : '/XoriantSurveyPortal/Xoriant/Surveys'
	}, allSurveys = [];

	angular.module('surveyDetails', []).service('surveyIdService',
			function($http, $log) {
				this.getSurveys = function(id) {
					return $http.get(dataUrls.surveysId + "/" + id);
				};
			}).controller(
			'SurveyIdController',
			function($scope, $log, surveyIdService, $stateParams, $state,
					$rootScope) {

				$rootScope.pageClass = 'responses';
				function init() {
					surveyIdService.getSurveys($stateParams.id)
							.then(loadSurvey);
				}
				function loadSurvey(surveys) {
					// load survey list into UI
					$log.log('Surveys: ', surveys);
					$scope.surveyTitle = surveys.data.title;
					$scope.choice1 = surveys.data.choice1;
					$scope.choice2 = surveys.data.choice2;
					$scope.status = surveys.data.status;
				}

				init();
			});
})();
