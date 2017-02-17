/**
 * Created by dosi on 2/16/17.
 */
angular.module("RDash").service("FormationSrv", ["$http", function ($http) {
    var url_formation = "http://localhost:8090/formation/";

    this.supprimerFormation = function (codeFormation, cb) {
        $http.delete(url_formation + codeFormation).then(function (response) {
            cb();
        }, function (error) {
            alert("une erreur serveur s'est produite");
            console.log(error);
        });
    };

    this.getOneFormation = function (codeForamtion, cb) {
        $http.get(url_formation + codeForamtion).then(function (response) {
                cb(response.data)
            },
            function (error) {
                alert("une erreur serveur s'est produite");
                console.log(error);
            });
    };
    this.getToutesLesFormations = function (cb) {
        $http.get(url_formation).then(function (response) {
            cb(response.data);
        }, function (error) {
            alert("une erreur serveur s'est produite");
            console.log(error);
        });
    };

    this.ajouterFormation = function (formation, cb) {
        $http.post(url_formation, formation, {
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).then(function (response) {
            cb();
        }, function (error) {
            alert("une erreur serveur s'est produite");
            console.log(error);
        });
    };

    this.modifierFormation = function (formation, cb) {

        $http.put(url_formation, formation, {
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).then(function (response) {
            cb();
        }, function (error) {
            alert("une erreur serveur s'est produite");
            console.log(error);
        });
    };
}]);