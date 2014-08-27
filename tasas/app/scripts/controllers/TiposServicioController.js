'use strict';

/**
 * @ngdoc function
 * @name tasasApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the tasasApp
 */
angular.module('tasasApp')
    .controller('TiposServicioController', function ($scope, tasasApi) {

        $scope.myData = tasasApi.tipoServicio.getAll();
        console.log($scope.myData);
        $scope.gridOptions = { data: 'myData' };

    });
