/**
 * Created by dosi on 2/16/17.
 */
angular.module("RDash").service("StatistiqueSrv", ["$http", function ($http) {
    var url_formation = "http://localhost:8090/formation/nombredeformations";

    this.getNombreDeFormation = function (cb) {
        $http.get(url_formation).then(function (response) {
            cb(response.data);
        }, function (error) {
            alert("une erreur serveur s'est produite");
            console.log(error);
        });
    }
}]);