(function() {
	var dataUrls = {
		surveys : '/XoriantSurveyPortal/Xoriant/Surveys',
		surveyResponsesBase : '/XoriantSurveyPortal/Xoriant/SurveyResult'
	}, allSurveys = [];
	allSurveyResponses = [];

	angular.module('surveyResponses', []).service('responseDataService',
			function($http, $log) {
				this.getSurveyResponse = function(id) {
					var url = dataUrls.surveyResponsesBase + "/" + id;
					return $http.get(url);
				};
				this.getSurveys = function() {
					return $http.get(dataUrls.surveys);
				};
			}).controller(
			'SurveyResponseController',
			function($scope, $log, responseDataService, $stateParams, $state,
					$filter, $rootScope) {
				$scope.surveyResponses = allSurveyResponses || [];
				$rootScope.pageClass = 'responses';
				function init() {
					// Get all surveys
					if (allSurveys.length === 0) {
						responseDataService.getSurveys().then(loadSurveys);
					} else {
						loadSurveyInfo($stateParams.id);
					}

					// Get current survey response
					responseDataService.getSurveyResponse($stateParams.id)
							.then(loadSurveyResponseInfo);
				}
				function loadSurveys(surveys) {
					allSurveys = surveys.data;
					loadSurveyInfo($stateParams.id);
				}
				function loadSurveyResponseInfo(surveyResponse) {
					$scope.surveyResponse = surveyResponse.data;
					getPercentValuesForChart($scope.surveyResponse);
				}
				function loadSurveyInfo(id) {
					if (!id) {
						return;
					}
					$scope.survey = $filter('getById')(allSurveys, id);
			
				}
				function getPercentValuesForChart(res) {
					// Get percentages
					var totalCount = res.countChoice1 + res.countChoice2;

					$scope.choice1Pc = Math
							.round((res.countChoice1 / totalCount) * 100);
					$scope.choice2Pc = Math
							.round((res.countChoice2 / totalCount) * 100);
				}
				init();
			});
})();