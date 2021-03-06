var index = 1, size = 6, totalPage = 0, totalCount = 0;
var pageData = [];
var optId = '';
var number = '', server = '', control = '', select_function = '', ipAddr = '', status = '';


$(function () {
    if (auth.check(this)) {
        //自适应
        view.initHeight();
        $(window).resize(function () {
            view.initHeight();
        });
        sysOperationRecord.get();
    }
});

var sysOperationRecord = {
    get: function () {
        var data = {};
        data['number'] = number;
        data['server'] = server;
        data['control'] = control;
        data['ipAddr'] = ipAddr;
        data['status'] = status;
        data['function'] = select_function;

        var param = {url: baseModule.sysOperationRecordApi + '/' + index + '-' + size, data: data};
        var request = ajax.post(param);
        request.done(function (d) {
            pageData = d.result.data;
            render.page();
            totalPage = d.result.totalPage;
            totalCount = d.result.totalCount;
            if (d.result.totalPage > 1) {
                page.init(d.result.totalPage, d.result.totalCount);
            } else {
                $('.list-page').empty();
            }
            auth.show();

        })
    }, //查询
    select: function (event) {

        server = $.trim($('#select-server').val()).replace('-', '');
        control = $.trim($('#select-control').val()).replace('-', '');
        select_function = $.trim($('#select-function').val()).replace('-', '');
        ipAddr = $.trim($('#select-ipAddr').val()).replace('-', '');
        status = $.trim($('#select-status').val()).replace('-', '');
        number = $.trim($('#select-number').val()).replace('-', '');
        index = 1;
        sysOperationRecord.get();
    },
};

var render = {
    page: function () {
        var template = doT.template($("#sysOperationRecord-template").text());//获取的模板
        $('#item-list').html(template(pageData));//模板装入数据
    },
};

var opt = {

    close: function () {   //关闭按钮
        closeLay();
    }
};

var page = {
    init: function (_pageSize, _total) {
        $('.list-page').pagination({
            pageCount: _pageSize,
            current: index,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            pageSize: size,
            pageArray: [size,6, 12, 24, 48],
            totalCount: _total,
            id: 'sysOperationRecord-page',
            callback: function (api) {
                index = api.getCurrent();
                sysOperationRecord.get();
            }
        });
        if (_pageSize > 0)
            $('.pages').show();
    }
};

var view = {
    initHeight: function () {
        $('.data-view').css('height', (parent.adaptable().h) - 80);
        $('.date-table').css('height', (parent.adaptable().h) - 180);
        size = Math.floor(((parent.adaptable().h) - 180) / 40);
    }
};


function pageChange(event) {
    size = $(event).val();
    index = 1;
    sysOperationRecord.get();
};


var tool = {
    translate: function (model) {
        var data = [];
        for (var variable in model) {
            data[variable] = model[variable];
            //判断helper里是否存在该函数，存在则执行转换
            if (typeof eval('helper.' + variable) == 'function')
                model[variable] = eval('helper.' + variable + '(' + model[variable] + ')');
        }
        form.set(model);
        //恢复回转换前数据
        for (var variable in data) {
            model[variable] = data[variable];
        }
    }
};

var helper = {
    status: function (_status) {
        switch (parseInt(_status)) {
            case 0:
                return "成功";
            case 1:
                return "失败";
        }
    },
    server: function (_server) {
        switch (parseInt(_server)) {
            case 0:
                return "后台";
            case 1:
                return "微信端";
        }
    },
}