'use strict';

/**
 * @ngdoc function
 * @name tasasApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the tasasApp
 */
angular.module('tasasApp')
    .factory('TipoServicio', function () {

        /**
         * Constructor, with class name
         */
        function TipoServicio(denominacion, descripcion, servicios) {
            // Public properties, assigned to the instance ('this')
            this.denominacion = denominacion;
            this.descripcion = descripcion;
            this.servicios = servicios;
        }

        /**
         * Public method, assigned to prototype
         */
        TipoServicio.prototype.getServiciosAsString = function () {
            var result = '';
            for(var i = 0; i<this.servicios.length ; i++)
                result = result + this.servicios[i].denominacion;
            return result;
        };

        /**
         * Static method, assigned to class
         * Instance ('this') is not available in static context
         */
        TipoServicio.build = function (data) {
            return new TipoServicio(
                data.denominacion,
                data.descripcion,
                data.servicios
            );
        };

        /**
         * Return the constructor function
         */
        return TipoServicio;
    });
