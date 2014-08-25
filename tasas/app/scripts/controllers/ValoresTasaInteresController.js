'use strict';

/**
 * @ngdoc function
 * @name tasasApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the tasasApp
 */
angular.module('tasasApp')
  .controller('ValoresTasaInteresController', function ($scope) {
        $scope.myData = [{name: "Moroni", age: 50},
            {name: "Tiancum", age: 43},
            {name: "Jacob", age: 27},
            {name: "Nephi", age: 29},
            {name: "Enos", age: 34}];
        $scope.gridOptions = { data: 'myData' };
  });
