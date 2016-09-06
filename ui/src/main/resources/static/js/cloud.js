(function(){
    var app = angular.module('collector', [])

    app.controller('DataController', [ '$http', function($http){
        var store = this;
        store.allentries = [];
        $http.get('http://localhost:8080/fake/data').success(function(data) {
            store.allentries = data;
        })
    }]);
})();
