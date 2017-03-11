
var app = angular.module("TravelCityManagement",  ['smart-table']);

//Controller Part
app.controller("TravelCityController", function($scope, $http) {


	$scope.cities = [];
	$scope.cityForm = {
			City : "",
			Country : "",
			Attractions : "",
			Visited:""
	};

	//Now load the data from server
	_refreshData();

	
	$scope.visitChange= function(city){
		$http({
			method : "PUT",
			url : 'rest/city',
			data : angular.toJson(city),
			headers : {
			'Content-Type' : 'application/json'
		}
		}).then(_successUPD, _error );
		
	}
	//HTTP POST method for add city 

	$scope.submitCity = function() {
		if($scope.cityForm.Attractions)
			$scope.cityForm.Attractions = $scope.cityForm.Attractions.split(',');
		else
			$scope.cityForm.Attractions=[];

		$http({
			method : "POST",
			url : 'rest/city',
			data : angular.toJson($scope.cityForm),
			headers : {
			'Content-Type' : 'application/json'
		}
		}).then(_successADD, _error );
	};         

	/* Private Methods */
	//HTTP GET- retrieve the cities from the server
	function _refreshData() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/TravelApp-0.0.1-SNAPSHOT/rest/city'
		}).then(function successCallback(response) {
			$scope.cities = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	function _successUPD(response) {

	}
	function _success(response) {
			_refreshData();
			_clearFormData();
	}
	function _successADD(response) {
		if(response.data)
		{
			_refreshData();
			_clearFormData();
		}
		else
			alert("Fail cannot add this city item!")
}
	function _error(response) {
		console.log(response.statusText);
	}

	//Clear the form
	function _clearFormData() {
		$scope.cityForm.City = "";
		$scope.cityForm.Country = "";
		$scope.cityForm.Attractions = "";
		$scope.cityForm.Visited = "";                
	};
});
