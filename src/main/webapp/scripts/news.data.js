angular.module('NewsManager', [])
    .controller('NewsList', function($scope, $http) {
        $http.get('http://localhost:8080/testapp/news').
        then(function(response) {
            $scope.news_list = response.data;
        });
    })
    .controller('NewsView', function($scope, $http){
        $http.get
    });