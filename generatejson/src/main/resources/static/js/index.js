var app = angular.module('myApp', []);
app.controller('appController', function ($scope, $http) {
    $scope.generateParams = {
        "dataType": "kqiTrend",
        "startTime": "20180421 12:00:00",
        "endTime": "20180421 13:00:00",
        "interval": 300
    }
    $scope.kqiList = [{
        "id": "",
        "min": 0,
        "max": 999999,
        "scale": 0,
        "unit": "",
        "serType": ""
    }];
    $scope.scaleList = [0, 1, 2, 3, 4, 5, 6];
    $scope.unitList = ["", "Kbps", "Byte", "numbers", "persons", "times", "%"];
    $scope.serTypeList = ["", "iptv", "hsi", "dia"];
    $scope.dataTypeList = ["kqiTrend", "historyKqiTrend"];
    $scope.intervalList = [300, 3600, 86400, 2592000];

    $scope.removeKqi = function (x) {
        var index = $.inArray(x, $scope.kqiList);
        if (index >= 0) {
            if ($scope.kqiList.length > 1) {
                $scope.kqiList.splice(index, 1);
            }
        }
        console.log($scope.kqiList);
    }

    $scope.addKqi = function () {
        var kqi = {
            "id": "",
            "min": 0,
            "max": 999999,
            "scale": 0,
            "unit": "",
            "serType": ""
        }
        $scope.kqiList.push(kqi);
        console.log($scope.kqiList);
    }

    $scope.errorMessage = "";

    $scope.generateJsonFile = function () {
        $scope.generateParams.kqiVOList = $scope.kqiList;
        $http({
            method: "POST",
            url: "/json/generate",
            data: $scope.generateParams
        }).then(function successCallback(response) {
            var data = response.data;
            console.log("data", data);
            if (data.resultCode && data.resultCode != 200) {
                $scope.errorMessage = data.resultMessage;
                $("#myModal").modal({
                    keyboard: true
                });
            } else {
                result = data.result;
                if (result && result.fileName) {
                    var url = "/json/download/" + result.fileName;
                    var $eleForm = $("<form method='get'></form>");
                    $eleForm.attr("action", url);
                    $(document.body).append($eleForm);
                    $eleForm.submit();
                }
            }
        }, function errorCallback(response) {
            $errorMessage = response;
            $("#myModal").modal({
                keyboard: true
            });
        });
    }
});