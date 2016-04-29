'use strict';

var app = angular.module('ngdemo');

angular.module('ngdemo.ctrlPessoa', [])
        .controller('ControllerPessoa', ControllerPessoa)

ControllerPessoa.$inject = ['$scope', 'Restangular', '$cookies'];

function ControllerPessoa($scope, Restangular, $cookies) {

    init();
    atualizaLista();

    function init() {
        
        $scope.paginas = 5;
        setarLinhas($scope.paginas);
    }
    ;

    function setarLinhas(num) {
        
        if (num == 'Todas') {
            num = $scope.pessoas.length;
        }
        ;
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
        var favoriteCookie = $cookies.get('JSESSIONID');
        console.log(favoriteCookie);
        if (favoriteCookie != '') {
            window.location.assign("//localhost:8080/app/#/login");
        }
        
        Restangular.all("pessoas").getList().then(function (objeto) {
              $scope.pessoas = objeto;
            setarLinhas($scope.paginas);
        });
    }
    ;

    $scope.createNewPessoa = function () {
        console.log($scope.pessoa);
        Restangular.all('pessoas').post($scope.pessoa).then(function () {
            atualizaLista();
            $scope.pessoa = null;
            

        });
        
    };

    $scope.deletePessoa = function (pessoaId) {
        Restangular.one('pessoas', pessoaId).remove().then(function () {
            atualizaLista();
        });
    };

    $scope.updatePessoa = function () {
        var copiaItem = Restangular.copy($scope.pessoa);
        $scope.pessoa = copiaItem.put().then(function () {
            atualizaLista();
            $scope.pessoa = null;
        });
    };

    $scope.mostraData = function (data) {
        var parts

        if (data !== null && data !== undefined) {
            parts = data.split('-');
            var mydate = parts[2] + '/' + parts[1] + '/' + parts[0];

            return mydate;
        }

    };

    $scope.carregaPessoa = function (pessoaId) {
        $scope.pessoa = Restangular.one("pessoas", pessoaId).get().$object;
    };

    $scope.limpaVariaveis = function () {
        $scope.pessoa = null;
    };
}
