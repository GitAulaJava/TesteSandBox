'use strict';

var app = angular.module('ngdemo');

angular.module('ngdemo.ctrlDomicilio', [])
        .controller('ControllerDomicilio', ControllerDomicilio)

ControllerDomicilio.$inject = ['$scope', 'Restangular'];

function ControllerDomicilio($scope, Restangular) {

    init();
    atualizaLista();
    var pessoas = [];

    function init() {
        $scope.paginas = 5;
        setarLinhas($scope.paginas);
    }
    ;

    function setarLinhas(num) {
        if (num == 'Todas') {
            num = $scope.domicilios.length;
        }
        $scope.entryLimit = num;
    }
    ;

    $scope.ordenarPor = function (coluna) {
        $scope.criterioDeOrdenacao = coluna;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };

    $scope.setItemsPagina = function (num) {
        setarLinhas(num);
    };

    function atualizaLista() {
        console.log(Restangular.all("domicilios").getList());
        Restangular.all("domicilios").getList().then(function (objeto) {
            
            $scope.domicilios = objeto;
            setarLinhas($scope.paginas);
        });
        
        $scope.listaPessoas = Restangular.all("pessoas").getList().$object;
    }
    ;

    $scope.createNewDomicilio = function () {
        Restangular.all('domicilios').post($scope.domicilio).then(function () {
            atualizaLista();
            $scope.domicilio = null;
        });
    };

    $scope.deleteDomicilio = function (domicilioId) {
        Restangular.one('domicilios', domicilioId).remove().then(function () {
            atualizaLista();
        });
    };

    $scope.updateDomicilio = function () {
        $scope.domicilio.pessoas = $scope.pessoas;
        console.log($scope.domicilio);
        var copiaItem = Restangular.copy($scope.domicilio);
        $scope.domicilio = copiaItem.put().then(function () {
            $scope.domicilio = null;
            atualizaLista();
        });
    };

    $scope.carregaDomicilio = function (domicilioId) {
        Restangular.one("domicilios", domicilioId).get().then(function (objeto) {
            $scope.domicilio = objeto;
            $scope.pessoas = $scope.domicilio.pessoas;
        });
    };

    $scope.adicionaItem = function () {
        var user;
        Restangular.one("pessoas/" + $scope.id_pessoa).get().then(function (objeto) {
            user = objeto.plain(); 
            //pessoas.push(user);
            $scope.pessoas.push(user);// = pessoas;
        });
    };
    
    $scope.retiraPessoa = function(pessoa) {  
        
        console.log($scope.pessoas.indexOf(pessoa));
       $scope.pessoas.splice($scope.pessoas.indexOf(pessoa), 1   );
    };
    
    $scope.limpaVariaveis = function () {
        $scope.domicilio = null;
    };
}
