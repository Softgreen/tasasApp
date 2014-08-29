'use strict';

/**
 * @ngdoc function
 * @name tasasApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the tasasApp
 */
angular.module('tasasApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
