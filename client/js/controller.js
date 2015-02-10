var schoolAppControllers = angular.module('schoolAppControllers', ['ui.grid']);

schoolAppControllers.controller('admissionCtrl', function($scope, $location,
		$http) {
	$scope.title = "Registration-Student Information";

	$scope.submitAdmission = function() {
		var data = $scope.register;
		$http({
			url : 'addStudent',
			method : 'POST',
			data : data
		}).success(function(data) {
			console.log("success");
		});
	};
});

schoolAppControllers.controller('classListCtrl', function($scope, $http) {
	$http({
		method : "get",
		url : "classList"
	}).success(function(data) {
		$scope.classlist = data;
	});
});

schoolAppControllers.controller('uploadStudInfoCtrl', function($scope,
		fileUpload, $location, $rootScope) {
	$scope.uploadFile = function() {
		var file = $scope.myFile;
		var uploadUrl = "fileUpload";
		fileUpload.uploadFileToUrl(file, uploadUrl);
	};
});

schoolAppControllers.controller('uploadResultCntrl', function($scope,$rootScope) {
	$scope.studentDetails = $rootScope.uploadResponse;
	$scope.gridOptions = {
		columnDefs : [ {
			displayName : 'Admission',
			field : 'admission.admissionId'
		}, {
			displayName : 'Name',
			field : 'admission.firstName'
		}, {
			displayName : 'Class',
			field : 'classDetail.className'
		} ],
		data : 'studentDetails'
	};
});