(function() {

	var dataUrls = {
		surveys : '/XoriantSurveyPortal/Xoriant/Surveys/Random',
		addemployeesurvey : '/XoriantSurveyPortal/Xoriant/AddSurvey'
	}, Survey = [];

	angular.module('takeSurvey', [ 'common-elements' ]).service(
			'takeSurveyService', function($http, $log) {
				this.getSurveys = function() {
					return $http.get(dataUrls.surveys);
				};

				this.createEmployeeSurvey = function(employeeSurvey) {
					var url = dataUrls.addemployeesurvey;
					return $http({
						method : 'POST',
						url : url,
						data : employeeSurvey,
						headers : {
							'Content-Type' : 'application/json'
						}
					});
				};

			}).controller(
			'TakeSurveyController',
			function(commonService, $scope, $log, takeSurveyService,
					$stateParams, $state, $rootScope) {
				$rootScope.pageClass = 'takeSurvey';
				function init() {
					takeSurveyService.getSurveys().then(loadSurvey);
				}
				function loadSurvey(survey) {
					// load survey list into UI

					$scope.surveyId = survey.data.surveyId;
					$scope.surveyTitle = survey.data.title;
					$scope.choice1 = survey.data.choice1;
					$scope.choice2 = survey.data.choice2;
					commonService.surveyId = survey.data.surveyId;
					commonService.title = survey.data.title;

				}

				$scope.createEmployeeSurvey = function() {
					$scope.EmployeeSurvey.empSurveyId = commonService.empId
							+ commonService.surveyId;
					$scope.EmployeeSurvey.title = commonService.title;
					$scope.EmployeeSurvey.empId = commonService.empId;
					$scope.EmployeeSurvey.surveyId = commonService.surveyId;

					// Parse to JSON
					var EmployeeSurveyJSON = angular
							.toJson($scope.EmployeeSurvey);

					var response = takeSurveyService.createEmployeeSurvey(
							EmployeeSurveyJSON).success(function(jsonData) {

						$rootScope.pageClass = 'home';
						$state.go('thanks');
					});

				};

				init();
			});
})();