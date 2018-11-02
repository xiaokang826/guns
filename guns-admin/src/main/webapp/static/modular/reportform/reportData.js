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
 * 查询输赢报表列表
 */
ReportData.search = function () {
    var queryData = {};
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();
    queryData['gameType'] = $("#gameType").val();
    queryData['roomType'] = $("#roomType").val();
    queryData['userName'] = $("#userName").val();
    ReportData.table.refresh({query: queryData});
    var ajax = new $ax(Feng.ctxPath + "/reportData/refresh", function (data) {
        $("#total").html(data);
    },function(data) {
        Feng.error("Ajax数据更新出错！！！");
    });
    ajax.set("gameType",queryData.gameType);//测试数据 可删除
    setTimeout(function () { //此处ajax延时启动
        ajax.start()
    },500);
};

$(function () {
    var defaultColunms = ReportData.initColumn();
    var table = new BSTable(ReportData.id, "/reportData/list", defaultColunms);
    table.setPaginationType("client");
    ReportData.table = table.init();
});
