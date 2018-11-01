/**
 * 牌九通用配置管理初始化
 */
var DominoCommon = {
    id: "DominoCommonTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DominoCommon.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        // {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '游戏开始倒计时', field: 'gameStartCd', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '下注倒计时', field: 'betCd', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '开牌倒计时', field: 'openCardsCd', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '结算CD', field: 'settleCd', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
DominoCommon.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DominoCommon.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加牌九通用配置
 */
DominoCommon.openAddDominoCommon = function () {
    var index = layer.open({
        type: 2,
        title: '添加牌九通用配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dominoCommon/dominoCommon_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看牌九通用配置详情
 */
DominoCommon.openDominoCommonDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '牌九通用配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dominoCommon/dominoCommon_update/' + DominoCommon.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除牌九通用配置
 */
DominoCommon.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/dominoCommon/delete", function (data) {
                Feng.success("删除成功!");
                DominoCommon.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("dominoCommonId",DominoCommon.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + DominoCommon.seItem.id + "?",operation);
    }
};

/**
 * 查询牌九通用配置列表
 */
DominoCommon.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DominoCommon.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DominoCommon.initColumn();
    var table = new BSTable(DominoCommon.id, "/dominoCommon/list", defaultColunms);
    table.setPaginationType("client");
    DominoCommon.table = table.init();
});
