(function() {
	// 'use strict';

	var dataUrls = {
		register : '/XoriantSurveyPortal/Xoriant/Employees',
	};
	angular.module('register', [ 'common-elements' ]).service(
			'registerService', function($http, $log) {

				this.createEmployee = function(employee) {
					var url = dataUrls.register;
					return $http({
						method : 'POST',
						url : url,
						data : employee,
						headers : {
							'Content-Type' : 'application/json'
						}
					});
				};

			}).controller(
			'RegisterController',
			function($scope, $rootScope, $state, registerService, $log,
					$window, commonService) {
				$rootScope.pageClass = 'register';
				$scope.createEmployee = function() {

					// Parse to JSON
					var EmployeeJSON = angular.toJson($scope.Employee);

					var response = registerService.createEmployee(EmployeeJSON)
							.success(function(jsonData) {
								$scope.employee = EmployeeJSON;
								$rootScope.pageClass = 'takeSurvey';
								$state.go('takeSurvey');
								commonService.empId = $scope.Employee.empId;
								commonService.ename = $scope.Employee.ename;
							});

				};

			});
})();