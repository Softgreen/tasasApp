'use strict';

/**
 * @ngdoc function
 * @name tasasApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the tasasApp
 */
angular.module('tasasApp')
    .controller('TiposServicioController', function ($scope, api) {

        $scope.myData = [{name: "Moroni", age: 50},
            {name: "Tiancum", age: 43},
            {name: "Jacob", age: 27},
            {name: "Nephi", age: 29},
            {name: "Enos", age: 34}];
        $scope.gridOptions = { data: 'myData' };


        var tiposServicio = api.tiposServicio.get({id: 1});

    });
