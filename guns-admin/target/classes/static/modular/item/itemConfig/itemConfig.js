/**
 * 道具配置管理初始化
 */
var ItemConfig = {
    id: "ItemConfigTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ItemConfig.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'details', visible: true, align: 'center', valign: 'middle'},
            {title: '额外价值', field: 'extraPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '游戏', field: 'gameId', visible: true, align: 'center', valign: 'middle'},
            {title: '物品icon', field: 'itemIcon', visible: true, align: 'center', valign: 'middle'},
            {title: '物品名称', field: 'itemName', visible: true, align: 'center', valign: 'middle'},
            {title: '物品类型', field: 'itemType', visible: true, align: 'center', valign: 'middle'},
            {title: '价值', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '标签', field: 'tag', visible: true, align: 'center', valign: 'middle'},
            {title: '过期时间', field: 'timeOut', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ItemConfig.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ItemConfig.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加道具配置
 */
ItemConfig.openAddItemConfig = function () {
    var index = layer.open({
        type: 2,
        title: '添加道具配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/itemConfig/itemConfig_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看道具配置详情
 */
ItemConfig.openItemConfigDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '道具配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/itemConfig/itemConfig_update/' + ItemConfig.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除道具配置
 */
ItemConfig.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/itemConfig/delete", function (data) {
            Feng.success("删除成功!");
            ItemConfig.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("itemConfigId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询道具配置列表
 */
ItemConfig.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ItemConfig.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ItemConfig.initColumn();
    var table = new BSTable(ItemConfig.id, "/itemConfig/list", defaultColunms);
    table.setPaginationType("client");
    ItemConfig.table = table.init();
});
