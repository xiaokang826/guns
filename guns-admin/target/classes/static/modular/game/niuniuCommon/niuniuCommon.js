/**
 * 牛牛通用配置管理初始化
 */
var NiuniuCommon = {
    id: "NiuniuCommonTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
NiuniuCommon.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            // {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '抢庄几率', field: 'robDealerPct', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '出现机器人的百分比(30,30,40)', field: 'robotJoinPct', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '资金池初始值', field: 'poolMoney', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '每局牌流水的百分比[0-100]', field: 'totalLosePct', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '游戏开始倒计时', field: 'gameStartCd', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '下注倒计时', field: 'betCd', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '抢庄倒计时', field: 'robZhuangCd', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '定庄倒计时', field: 'fixDealerCd', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '开牌倒计时', field: 'openCardsCd', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '策略比值(大值)', field: 'strategyMaxPct', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '策略比值(小值)', field: 'strategyMinPct', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
NiuniuCommon.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        NiuniuCommon.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加牛牛通用配置
 */
NiuniuCommon.openAddNiuniuCommon = function () {
    var index = layer.open({
        type: 2,
        title: '添加牛牛通用配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/niuniuCommon/niuniuCommon_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看牛牛通用配置详情
 */
NiuniuCommon.openNiuniuCommonDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '牛牛通用配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/niuniuCommon/niuniuCommon_update/' + NiuniuCommon.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除牛牛通用配置
 */
NiuniuCommon.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/niuniuCommon/delete", function (data) {
                Feng.success("删除成功!");
                NiuniuCommon.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("niuniuCommonId",NiuniuCommon.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + NiuniuCommon.seItem.id + "?",operation);
    }
};

/**
 * 查询牛牛通用配置列表
 */
NiuniuCommon.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    NiuniuCommon.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = NiuniuCommon.initColumn();
    var table = new BSTable(NiuniuCommon.id, "/niuniuCommon/list", defaultColunms);
    table.setPaginationType("client");
    NiuniuCommon.table = table.init();
});
