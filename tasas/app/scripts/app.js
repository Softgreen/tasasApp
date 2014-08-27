'use strict';

/**
 * @ngdoc overview
 * @name tasasApp
 * @description
 * # tasasApp
 *
 * Main module of the application.
 */
angular
    .module('tasasApp', [
        'ngAnimate',
        'ngCookies',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'ngGrid',
        'tasasApi'
    ])
    .config(function ($routeProvider, tasasApiProvider) {

        tasasApiProvider.setBaseUrl('http://localhost:8080/TasasREST/rest');

        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .when('/tiposServicio', {
                templateUrl: 'views/tiposServicio.html',
                controller: 'TiposServicioController'
            })
            .when('/tasasInteres', {
                templateUrl: 'views/tasasInteres.html',
                controller: 'TasasInteresController'
            })
            .when('/valoresTasaInteres', {
                templateUrl: 'views/valoresTasaInteres.html',
                controller: 'ValoresTasaInteresController'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
