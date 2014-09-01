var blogApp = angular.module('blog', [ 'ngRoute' ]);

blogApp.controller('NavigationController', function($scope, $http) {
	$scope.categories = [];
	$scope.title = "Programmaniaks";

	$http.get('services/category/all').success(function(data) {
		$scope.categories = data;
	});
});

blogApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl : 'partials/index.html'
	}).when('/test', {
		templateUrl : 'partials/test.html'
	}).otherwise({
		redirectTo : '/index'
	});
} ]);