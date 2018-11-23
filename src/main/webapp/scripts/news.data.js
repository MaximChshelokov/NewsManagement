var app = angular.module('NewsManager', []);
app.controller('NewsController', ['$scope', 'NewsService', function ($scope, NewsService) {

    $scope.updateUser = function () {
        NewsService.updateUser($scope.news.id, $scope.news.title, $scope.news.date, $scope.news.brief, $scope.news.content)
            .then(function success(response) {
                      $scope.message = 'User data updated!';
                      $scope.errorMessage = '';
                  },
                  function error(response) {
                      $scope.errorMessage = 'Error updating news!';
                      $scope.message = '';
                  });
    }

    $scope.getNews = function (news_id) {
        var id = news_id;
        NewsService.getNews(news_id)
            .then(function success(response) {
                      $scope.news = response.data;
                      $scope.news.id = id;
                      $scope.message = '';
                      $scope.errorMessage = '';
                      $scope.showViewNews();
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
    }

    $scope.addNews = function () {
        if ($scope.news != null && $scope.news.title) {
            NewsService.addNews($scope.news.title, $scope.news.date, $scope.news.brief, $scope.news.content)
                .then(function success(response) {
                          $scope.message = 'News added!';
                          $scope.errorMessage = '';
                          $scope.news = response.data;
                          $scope.showViewNews();
                      },
                      function error(response) {
                          $scope.errorMessage = 'Error adding news!';
                          $scope.message = '';
                      });
        }
        else {
            $scope.errorMessage = 'Please enter a title!';
            $scope.message = '';
        }
    }

    $scope.deleteNews = function () {
        NewsService.deleteNews($scope.news.id)
            .then(function success(response) {
                      $scope.message = 'News deleted!';
                      $scope.news = null;
                      $scope.errorMessage = '';
                  },
                  function error(response) {
                      $scope.errorMessage = 'Error deleting news!';
                      $scope.message = '';
                  })
    }

    $scope.getAllNews = function () {
        NewsService.getAllNews()
            .then(function success(response) {
                      $scope.news_list = response.data;
                      $scope.message = '';
                      $scope.errorMessage = '';
                      $scope.showAllNews();
                  },
                  function error(response) {
                      $scope.message = '';
                      $scope.errorMessage = 'Error getting list of news!';
                  });
    }


    $scope.editNews = function () {
        $scope.getNews();
        $scope.showAddNewsForm();
    }

    $scope.showAddNewsForm = function () {
        $scope.feed_visible = false;
        $scope.form_visible = true;
        $scope.view_visible = false;
        $scope.view_class = '';
        $scope.form_class = 'selected-item';
    }

    $scope.showAllNews = function () {
        $scope.feed_visible = true;
        $scope.form_visible = false;
        $scope.view_visible = false;
        $scope.view_class = 'selected-item';
        $scope.form_class = '';
    }

    $scope.showViewNews = function () {
        $scope.feed_visible = false;
        $scope.form_visible = false;
        $scope.view_visible = true;
        $scope.view_class = '';
        $scope.form_class = '';

    }

    $scope.getAllNews();

}]);

app.service('NewsService', ['$http', function ($http) {

    this.getNews = function getNews(NewsId) {
        return $http({
                         method: 'GET',
                         url: 'news/' + NewsId
                     });
    }

    this.addNews = function addNews (title, date, brief, content) {
        return $http({
                         method: 'POST',
                         url: 'news',
                         data: {title: title, date: date, brief: brief, content: content}
                     });
    }

    this.deleteNews = function deleteNews(id) {
        return $http({
                         method: 'DELETE',
                         url: 'news/' + id
                     })
    }

    this.updateNews = function updateUser(id, title, date, brief, content) {
        return $http({
                         method: 'PUT',
                         url: 'news/' + id,
                         data: {title: title, date: date, brief: brief, content: content}
                     })
    }

    this.getAllNews = function getAllNews() {
        return $http({
                         method: 'GET',
                         url: 'news'
                     });
    }

}]);
