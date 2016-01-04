(function() {
	var dataUrls = {
		employeeSurveys : '/XoriantSurveyPortal/Xoriant/AttemptedSurvey'
	}, allSurveys = [];

	angular.module('employeeSurveyDetails', []).service(
			'employeeSurveyService', function($http, $log) {
				this.getSurveys = function(id) {
					return $http.get(dataUrls.employeeSurveys + "/" + id);
				};
			}).controller(
			'EmployeeSurveyController',
			function($scope, $log, employeeSurveyService, $stateParams, $state,
					$rootScope) {
				$scope.surveys = allSurveys || [];
				$rootScope.pageClass = 'responses';
				function init() {
					employeeSurveyService.getSurveys($stateParams.id).then(
							loadEmployeeSurvey);
				}
				$log.log(allSurveys);
				function loadEmployeeSurvey(surveys) {
					// load survey list into UI
					$log.log('Surveys: ', surveys);
					$scope.surveys = allSurveys = surveys.data;
				}
				function loadSurvey(survey) {
					// load survey list into UI
					$log.log('Surveys: ', survey);
					$scope.survey = survey.data;
				}

				init();
			});
})();
