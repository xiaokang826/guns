/**
 * 炸金花通用配置管理初始化
 */
var GoldCommon = {
    id: "GoldCommonTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
GoldCommon.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            // {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '玩法', field: 'playType', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '换牌开关', field: 'isChangeCard', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '自动结算类型', field: 'settleType', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '是否需要被比牌方同意比牌申请', field: 'isAllowSideshow', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '是否可以选择指定用户进行比牌', field: 'isSideshowUser', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '被比方同意比牌弹窗的倒计时', field: 'allowSideshowCd', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '下注倒计时', field: 'betCd', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '游戏开始倒计时', field: 'gameStartCd', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
GoldCommon.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        GoldCommon.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加炸金花通用配置
 */
GoldCommon.openAddGoldCommon = function () {
    var index = layer.open({
        type: 2,
        title: '添加炸金花通用配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/goldCommon/goldCommon_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看炸金花通用配置详情
 */
GoldCommon.openGoldCommonDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '炸金花通用配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/goldCommon/goldCommon_update/' + GoldCommon.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除炸金花通用配置
 */
GoldCommon.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/goldCommon/delete", function (data) {
                Feng.success("删除成功!");
                GoldCommon.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("goldCommonId",GoldCommon.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + GoldCommon.seItem.id + "?",operation);
    }
};

/**
 * 查询炸金花通用配置列表
 */
GoldCommon.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    GoldCommon.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = GoldCommon.initColumn();
    var table = new BSTable(GoldCommon.id, "/goldCommon/list", defaultColunms);
    table.setPaginationType("client");
    GoldCommon.table = table.init();
});
