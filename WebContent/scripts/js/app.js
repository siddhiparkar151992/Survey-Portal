/**
 * ngSurveys - main application script file
 */

(function() {
	'use strict';

	angular.module(
			'ngSurveys',
			[ 'ui.router', 'ngAnimate', 'common-elements', 'home', 'surveys',
					'surveyResponses', 'surveyDetails', 'employees',
					'employeeSurveyDetails', 'register', 'takeSurvey',
					'addSurvey', 'thanks', ])

	// UI Routing
	.config(function($urlRouterProvider, $stateProvider) {
		$urlRouterProvider.otherwise('/home');
		$stateProvider.state('home', {
			url : '/home',
			templateUrl : 'views/home.html',
			controller : 'HomeController'
		}).state('surveys', {
			url : '/surveys',
			templateUrl : 'views/surveyList.html',
			controller : 'SurveyController'
		}).state('responseInfo', {
			url : '/response/{id:[0-9]{1,4}}',
			templateUrl : 'views/surveyResponse.html',
			controller : 'SurveyResponseController'
		}).state('employees', {
			url : '/employees',
			templateUrl : 'views/employeeList.html',
			controller : 'EmployeeController'
		}).state('employeeSurvey', {
			url : '/id/{id:[e][0-9]{1,3}}',
			templateUrl : 'views/employeeSurvey.html',
			controller : 'EmployeeSurveyController'
		}).state('idInfo', {
			url : '/id/{id:[0-9]{1,4}}',
			templateUrl : 'views/surveyId.html',
			controller : 'SurveyIdController'
		}).state('register', {
			url : '/register',
			templateUrl : 'views/register.html',
			controller : 'RegisterController'
		}).state('takeSurvey', {
			url : '/takeSurvey',
			templateUrl : 'views/takeSurvey.html',
			controller : 'TakeSurveyController'
		}).state('addSurvey', {
			url : '/addSurvey',
			templateUrl : 'views/addSurvey.html',
			controller : 'AddSurveyController'
		}).state('thanks', {
			url : '/thanks',
			templateUrl : 'views/thanks.html',
			controller : 'ThanksController'
		});
	});
})();