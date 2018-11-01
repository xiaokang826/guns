/**
 * 炸金花房间配置管理初始化
 */
var GoldRoom = {
    id: "GoldRoomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
GoldRoom.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            // {title: '序列号', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '房间id', field: 'roomId', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '入桌最小积分', field: 'minJoinTable', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '底注', field: 'ante', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '首次下注基础注', field: 'firstBetScore', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '最大下注额度', field: 'maxBetScore', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '服务费比率', field: 'serviceCharge', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '盲牌最大轮次', field: 'maxBlindRound', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '底池总封', field: 'maxPot', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '荷官打赏数量', field: 'tipValue', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '换牌所需费用', field: 'changeFee', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '换牌服务费', field: 'changeFeeTips', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '加倍规则', field: 'doubleRoles', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '喜钱', field: 'xiQian', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
GoldRoom.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        GoldRoom.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加炸金花房间配置
 */
GoldRoom.openAddGoldRoom = function () {
    var index = layer.open({
        type: 2,
        title: '添加炸金花房间配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/goldRoom/goldRoom_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看炸金花房间配置详情
 */
GoldRoom.openGoldRoomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '炸金花房间配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/goldRoom/goldRoom_update/' + GoldRoom.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除炸金花房间配置
 */
GoldRoom.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/goldRoom/delete", function (data) {
                Feng.success("删除成功!");
                GoldRoom.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("goldRoomId",GoldRoom.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + GoldRoom.seItem.id + "?",operation);
    }
};

/**
 * 查询炸金花房间配置列表
 */
GoldRoom.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    GoldRoom.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = GoldRoom.initColumn();
    var table = new BSTable(GoldRoom.id, "/goldRoom/list", defaultColunms);
    table.setPaginationType("client");
    GoldRoom.table = table.init();
});
