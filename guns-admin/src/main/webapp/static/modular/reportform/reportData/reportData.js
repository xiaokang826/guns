/**
 * 输赢报表管理初始化
 */
var ReportData = {
    id: "ReportDataTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ReportData.initColumn = function () {
    return [
        {title: 'selectItem', radio: true},
        {title: '账变时间', field: 'accountChangeTime', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '用户名', field: 'userName', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '游戏类型', field: 'gameName', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '房间类型', field: 'roomType', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '桌子号', field: 'tableNumber', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '座位号', field: 'seatNumber', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '庄闲', field: 'leisure', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '初始金额', field: 'initialAmount', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '总投注', field: 'totalBet', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '有效投注额', field: 'validBet', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '输赢金额', field: 'winLoseAmount', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '局号', field: 'boardNumber', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '游戏结果', field: 'gameResult', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
ReportData.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ReportData.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加输赢报表
 */
ReportData.openAddReportData = function () {
    var index = layer.open({
        type: 2,
        title: '添加输赢报表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/reportData/reportData_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看输赢报表详情
 */
ReportData.openReportDataDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '输赢报表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/reportData/reportData_update/' + ReportData.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除输赢报表
 */
ReportData.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/reportData/delete", function (data) {
                Feng.success("删除成功!");
                ReportData.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("reportDataId",ReportData.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + ReportData.seItem.id + "?",operation);
    }
};

/**
 * 查询输赢报表列表
 */
ReportData.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ReportData.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ReportData.initColumn();
    var table = new BSTable(ReportData.id, "/reportData/list", defaultColunms);
    table.setPaginationType("client");table.set
    ReportData.table = table.init();
});
