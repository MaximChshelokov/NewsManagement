var app = angular.module('NewsManager', []);
app.controller('NewsController', ['$scope', 'NewsService', function ($scope, NewsService) {

    $scope.updateNews = function () {
        NewsService.updateNews($scope.news.id, $scope.news.title, $scope.news.date, $scope.news.brief, $scope.news.content)
            .then(function success(response) {
                      $scope.message = 'User data updated!';
                      $scope.errorMessage = '';
                      $scope.showViewNews();
                  },
                  function error(response) {
                      $scope.errors = response.data;
                      $scope.errorMessage = 'Error updating news!';
                      $scope.message = '';
                  });
    };

    $scope.getNews = function (index_id) {
        var id = $scope.news_list[index_id].id;
        NewsService.getNews(id)
            .then(function success(response) {
                      $scope.news = response.data[0];
                      $scope.news.id = id;
                      $scope.news.date = new Date($scope.news.date);
                      $scope.message = '';
                      $scope.errorMessage = '';
                  },
                  function error(response) {
                      $scope.message = '';
                      if (response.status === 404) {
                          $scope.errorMessage = 'News not found!';
                      }
                      else {
                          $scope.errorMessage = "Error getting news!";
                      }
                  });
    };

    $scope.addNews = function () {
        if ($scope.news != null && $scope.news.title) {
            NewsService.addNews($scope.news.title, $scope.news.date, $scope.news.brief, $scope.news.content)
                .then(function success(response) {
                          $scope.message = 'News added!';
                          $scope.errorMessage = '';
                          $scope.news = response.data;
                          $scope.news.date = new Date($scope.news.date);
                          $scope.showViewNews();
                      },
                      function error(response) {
                          $scope.errors = response.data;
                          $scope.errorMessage = 'Error adding news!';
                          $scope.message = '';
                      });
        }
        else {
            $scope.errorMessage = 'Please enter a title!';
            $scope.message = '';
        }
    };

    $scope.deleteNews = function (index_id) {
        var id = $scope.news_list[index_id].id;
        NewsService.deleteNews(id)
            .then(function success(response) {
                      $scope.message = 'News deleted!';
                      $scope.news = null;
                      $scope.errorMessage = '';
                      $scope.getAllNews();
                  },
                  function error(response) {
                      $scope.errorMessage = 'Error deleting news!';
                      $scope.message = '';
                  })
    };

    $scope.getAllNews = function () {
        NewsService.getAllNews()
            .then(function success(response) {
                      $scope.news_list = response.data;
                      $scope.news_list.forEach(function (element) {
                          element.date = new Date(element.date);
                      });
                      $scope.message = '';
                      $scope.errorMessage = '';
                      $scope.showAllNews();
                  },
                  function error(response) {
                      $scope.message = '';
                      $scope.errorMessage = 'Error getting list of news!';
                  });
    };

    $scope.editNews = function (index_id) {
        $scope.getNews(index_id);
        $scope.showAddNewsForm();
    };

    $scope.viewNews = function (index_id) {
        $scope.getNews(index_id);
        $scope.showViewNews();
    };

    $scope.createNews = function () {
        $scope.news = {id: 0, title: '', date: new Date, brief: '', content: ''};
        $scope.showAddNewsForm();
    };

    $scope.showAddNewsForm = function () {
        $scope.feed_visible = false;
        $scope.form_visible = true;
        $scope.view_visible = false;
        $scope.view_class = '';
        $scope.form_class = 'selected-item';
    };

    $scope.showAllNews = function () {
        $scope.feed_visible = true;
        $scope.form_visible = false;
        $scope.view_visible = false;
        $scope.view_class = 'selected-item';
        $scope.form_class = '';
    };

    $scope.showViewNews = function () {
        $scope.feed_visible = false;
        $scope.form_visible = false;
        $scope.view_visible = true;
        $scope.view_class = '';
        $scope.form_class = '';

    };

    $scope.getAllNews();

}]);

app.service('NewsService', ['$http', function ($http) {

    this.getNews = function getNews(NewsId) {
        return $http({
                         method: 'GET',
                         url: 'news/' + NewsId
                     });
    };

    this.addNews = function addNews(title, date, brief, content) {
        return $http({
                         method: 'POST',
                         url: 'news',
                         data: {title: title, date: date, brief: brief, content: content}
                     });
    };

    this.deleteNews = function deleteNews(id) {
        return $http({
                         method: 'DELETE',
                         url: 'news/' + id
                     })
    };

    this.updateNews = function updateUser(id, title, date, brief, content) {
        return $http({
                         method: 'PUT',
                         url: 'news/' + id,
                         data: {title: title, date: date, brief: brief, content: content}
                     })
    };

    this.getAllNews = function getAllNews() {
        return $http({
                         method: 'GET',
                         url: 'news'
                     });
    }

}]);

app.directive('ngConfirmClick', [
    function () {
        return {
            link: function (scope, element, attr) {
                var msg = attr.ngConfirmClick || "Are you sure?";
                var clickAction = attr.confirmedClick;
                element.bind('click', function (event) {
                    if (window.confirm(msg)) {
                        scope.$eval(clickAction)
                    }
                });
            }
        };
    }]);