(function() {
	var dataUrls = {
		employees : '/XoriantSurveyPortal/Xoriant/Employees'
	}, allEmployees = [];

	angular.module('employees', []).service('employeeDataService',
			function($http, $log) {
				this.getEmployees = function() {
					return $http.get(dataUrls.employees);
				};
			}).controller(
			'EmployeeController',
			function($scope, $log, employeeDataService, $stateParams, $state,
					$rootScope) {
				$scope.employees = allEmployees || [];
				$rootScope.pageClass = 'employees';
				function init() {
					if (allEmployees.length === 0) {
						employeeDataService.getEmployees().then(loadEmployees);
					}

				}
				function loadEmployees(employees) {
					// load survey list into UI
					$log.log('Employees: ', employees);
					$scope.employees = allEmployees = employees.data;
				}

				init();
			});
})();