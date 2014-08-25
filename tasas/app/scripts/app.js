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
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'ngGrid',
        'core'
    ])
    .config(function ($routeProvider, apiProvider) {
        apiProvider.setBaseRoute('http://localhost:8080/TasasApp/rest/');

        apiProvider.endpoint('tiposServicio').
            route('tiposServicio/:id').
            model(app.TipoServicio);

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
