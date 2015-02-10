schoolApp.service('fileUpload', function($http, $rootScope, $location) {

	this.uploadFileToUrl = function(file, uploadUrl) {
		var url = serverURL + uploadUrl;
		var fd = new FormData();
		fd.append('file', file);
		$http.post(url, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function(data) {
			$rootScope.uploadResponse = data;
			$location.path("/uploadResult");
		}).error(function() {
		});

	};
});