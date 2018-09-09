window.onload = function () {
    var loading = null;
    var app = new Vue({
        el: '#app',
        data: {
            options: [{
                value: '0',
                label: '正常'
            }, {
                value: '1',
                label: '异常'
            }],
            type: '',
            staffId: '',
            date: [],
            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }
                , {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "1"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "1"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "1"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }, {
                date: '2016-05-02',
                name: '王小虎',
                staffId: "wwx123456",
                supplier: "1",
                startTime: "2016-05-02 09:00:00",
                endTime: "2016-05-02 19:00:00",
                punishTime: 0,
                type: "0"
            }],
            isMask: false,
            currentPage: 1,
            pageSize: 40,
            pageSizes: [40, 50, 60, 70, 80],
            total: 400,
            totalVO: {
                totalWorkTime: 1200,
                avgWorkTime: 8.00,
                workDayNums: 22,
                otWorkTime: 16,
                otWrokDays: 2,
                exceptionDays: 0
            }
        },
        methods: {
            query: function () {
                var params = getParams();
                console.log("query===", params);
            },
            queryCurMonth: function () {
                var dateRange = getCurMonthDateRange();
                app.date = dateRange;
                var params = getParams();
                console.log("queryCurMonth===", params);
            },
            exportExcel: function () {
                var params = getParams();
                params.type = null;
                console.log("exportExcel===", params);
            },
            handleSizeChange: function (pSize) {
                console.log("当前每页条数：", pSize);
            },
            handleCurrentChange: function (curPage) {
                console.log("当前页码：", curPage);
            },
            staffIdChange: function (value) {
                setCookie('staffId', value, 30);
            },
            formatSupplier: function (row, column, cellValue, index) {
                if (cellValue === "1") {
                    return "华微";
                }
                return cellValue;
            },
            tableRowClassName: function ({ row, rowIndex }) {
                if (row.type === "1") {
                    return "warning-row";
                }
                return "";
            }
        }

    });

    function getParams() {
        openLoading();
        init();
        var params = {
            type: app.type && app.type !== '' ? app.type : null,
            staffId: app.staffId,
            startTime: app.date && app.date.length > 0 ? app.date[0] : null,
            endTime: app.date && app.date.length > 1 ? app.date[1] : null
        }
        return params;
    }

    //格式化日期
    Date.prototype.Format = function (fmt) {
        var o = {
            "y+": this.getFullYear(),
            "M+": this.getMonth() + 1,                 //月份
            "d+": this.getDate(),                    //日
            "h+": this.getHours(),                   //小时
            "m+": this.getMinutes(),                 //分
            "s+": this.getSeconds(),                 //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S+": this.getMilliseconds()             //毫秒
        };
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                if (k == "y+") {
                    fmt = fmt.replace(RegExp.$1, ("" + o[k]).substr(4 - RegExp.$1.length));
                }
                else if (k == "S+") {
                    var lens = RegExp.$1.length;
                    lens = lens == 1 ? 3 : lens;
                    fmt = fmt.replace(RegExp.$1, ("00" + o[k]).substr(("" + o[k]).length - 1, lens));
                }
                else {
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                }
            }
        }
        return fmt;
    }

    function getCurMonthDateRange() {
        var dateRange = [];
        var date = new Date();
        var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
        var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
        dateRange.push(firstDay.Format("yyyy-MM-dd"));
        dateRange.push(lastDay.Format("yyyy-MM-dd"));
        return dateRange;
    }

    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toGMTString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i].trim();
            if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
        }
        return "";
    }

    function checkCookie(cname) {
        var cvalue = getCookie(cname);
        if (cvalue != "") {
            return true;
        }
        else {
            return false;
        }
    }

    function init() {
        var staffId = getCookie('staffId');
        app.staffId = staffId;
    }

    function openLoading() {
        loading = app.$loading({
            lock: true,
            text: '数据正在打滴滴过来，长时间无响应的话按ALT+F4',
            spinner: 'el-icon-loading',
            background: 'rgba(255, 255, 255, 0.8)',
            customClass: "mask"
        });
    }

    function closeLoading() {
        if (loading && loading != null) {
            loading.close();
        }
    }

    init();
}