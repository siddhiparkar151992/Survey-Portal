(function() {
	// 'use strict';

	var dataUrls = {
		addsurvey : '/XoriantSurveyPortal/Xoriant/Surveys',
	};
	angular.module('addSurvey', [ 'common-elements' ]).service(
			'addSurveyService', function($http, $log) {

				this.createSurvey = function(survey) {
					var url = dataUrls.addsurvey;
					return $http({
						method : 'POST',
						url : url,
						data : survey,
						headers : {
							'Content-Type' : 'application/json'
						}
					});
				};

			}).controller(
			'AddSurveyController',
			function($scope, $rootScope, $state, addSurveyService, $log,
					$window, commonService) {
				$rootScope.pageClass = 'addSurvey';
				$scope.createSurvey = function() {

					// Parse to JSON
					var SurveyJSON = angular.toJson($scope.Survey);

					var response = addSurveyService.createSurvey(SurveyJSON)
							.success(function(jsonData) {

								$rootScope.pageClass = 'home';
								$state.go('thanks');
							});

				};

			});
})();