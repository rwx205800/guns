/**
 * renfei管理初始化
 */
var Test = {
    id: "TestTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Test.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'aaa', field: 'aaa', visible: true, align: 'center', valign: 'middle'},
            {title: 'bbb', field: 'bbb', visible: true, align: 'center', valign: 'middle'},
            {title: 'bbb', field: 'bbb', visible: true, align: 'center', valign: 'middle',formatter: function (value, row, index) { return value + ":" + index }},
        {
            field: 'operate',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter: operateFormatter //自定义方法，添加操作按钮
        },
        {
            title: '操作', visible: true, align: 'center', valign: 'middle', formatter: function (value, row, index) {
                if (row.aaa == "12") {
                    return '<button type="button" class="btn btn-danger button-margin" onclick="Test.showMessage(' + row.aaa + ')" id=""><i class="fa fa-arrows-alt"></i>&nbsp;删除</button>';
                } else {
                    return '<button type="button" class="btn btn-primary button-margin" onclick="Test.showMessage(' + row.aaa + ')" id=""><i class="fa fa-edit"></i>&nbsp;查看</button>' ;
                }
            }
        },
    ];
};

var operateFormatter = function (value, row, index) {//赋予的参数
    return [
        '<button class="btn btn-info btn-sm rightSize detailBtn" type="button"><i class="fa fa-paste"></i> 详情</button>',
        '<button class="btn btn-danger btn-sm rightSize packageBtn" type="button"><i class="fa fa-envelope"></i> 通知</button>'
    ].join('');
}

/**
 * 检查是否选中
 */
Test.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Test.seItem = selected[0];
        return true;
    }
};


Test.showMessage = function (message) {
    Feng.alert(message);
}

/**
 * 点击添加renfei
 */
Test.openAddTest = function () {
    var index = layer.open({
        type: 2,
        title: '添加renfei',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/test/test_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看renfei详情
 */
Test.openTestDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'renfei详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/test/test_update/' + Test.seItem.aaa
        });
        this.layerIndex = index;
    }
};

/**
 * 删除renfei
 */
Test.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/test/delete", function (data) {
            Feng.success("删除成功!");
            Test.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("testId",this.seItem.aaa);
        ajax.start();
    }
};

/**
 * 查询renfei列表
 */
Test.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Test.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Test.initColumn();
    var table = new BSTable(Test.id, "/test/list", defaultColunms);
    table.setPaginationType("client");
    Test.table = table.init();
});
