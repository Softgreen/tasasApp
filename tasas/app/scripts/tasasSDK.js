var tasasApi = angular.module('tasasApi', ['restangular']);

var tiposServicio =  function(Restangular){
    var baseUrl = 'tiposServicio';
    function TipoServicio (){
        this.denominacion = '';
        this.abreviatura = '';
        this.servicios = [];
    };

    Restangular.extendModel(baseUrl, function(data) {
        data.getServiciosAsString = function() {
            var result = '';
            if(data.servicios)
                for(var i = 0; i < data.servicios.length; i++)
                    result = result + data.servicios[i].denominacion;
            return result;
        };
        return data;
    });

    TipoServicio.prototype.get = function(id){
        return Restangular.one(baseUrl, id).get();
    };
    TipoServicio.prototype.getAll = function(){
        var result = Restangular.one(baseUrl).get();
        console.log(result.data);
        return result.data;
    };

    return new TipoServicio();

};


tasasApi.config(function($provide, RestangularProvider) {

    RestangularProvider.setBaseUrl('http://localhost:8080/TasasApp/rest');

    this.endpoints = {};

    var tasasApiProvider = {};
    tasasApiProvider.setBaseUrl = function(baseUrl) {
        RestangularProvider.setBaseUrl(baseUrl);
    };
    tasasApiProvider.$get = function($injector) {
        var api = {};

        api['tipoServicio'] = $injector.instantiate(tiposServicio);
        return api;
    };

    $provide.provider('tasasApi', tasasApiProvider);
});


