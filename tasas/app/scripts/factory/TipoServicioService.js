'use strict';

/**
 * @ngdoc function
 * @name tasasApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the tasasApp
 */
angular.module('tasasApp')
    .factory('TipoServicioService', function(API, Organisation){
        return {
            get: function () {
                return API
                    .get('/organisations')
                    .then(Organisation.apiResponseTransformer);
            }
        }
    });


