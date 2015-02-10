//Modules
var schoolApp = angular.module('schoolApp',	[ 'ngRoute', 'schoolAppControllers','ui.grid']);

// Routing
schoolApp.config(function($routeProvider,$httpProvider) {
	
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    
	$routeProvider.when('/admission', {
		templateUrl : 'templates/admission.html',
		controller : 'admissionCtrl'
	}).when('/uploadStudInfo', {
		templateUrl : 'templates/upload.html',
		controller : 'uploadStudInfoCtrl'
	}).when('/uploadResult',{
		templateUrl : 'templates/uploadResult.html',
		controller :'uploadResultCntrl'
	}).when('/', {
		templateUrl : 'templates/home.html'
	});
});