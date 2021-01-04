var myApp = angular.module('myApp',[]);

var gameBoardDto = {
    player1:"0",
    player2:"0",
    topLeft:"",
    top:"",
    topRight:"",
    left:"",
    middle:"",
    right:"",
    bottomLeft:"",
    bottom:"",
    bottomRight:"",
    selection:""
};

myApp.controller('displayPageController', function($scope,$http) {

  $scope.playPage = function(selection) {
      gameBoardDto.selection = selection;
      $http({
            method: 'PUT',
            url: 'http://localhost:8082/play',
            data: gameBoardDto,
            headers: {'Content-Type': 'application/json;charset=UTF-8'}
        }).success(function(response) {
              $scope.gameBoardDto = JSON.parse(JSON.stringify(response));
          }.bind(this));
  };
});