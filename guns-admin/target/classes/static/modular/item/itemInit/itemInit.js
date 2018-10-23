/**
 * 道具赠送管理初始化
 */
var ItemInit = {
    id: "ItemInitTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ItemInit.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '物品id', field: 'itemId', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '所属游戏', field: 'gameId', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '数量', field: 'num', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
ItemInit.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ItemInit.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加道具赠送
 */
ItemInit.openAddItemInit = function () {
    var index = layer.open({
        type: 2,
        title: '添加道具赠送',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/itemInit/itemInit_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看道具赠送详情
 */
ItemInit.openItemInitDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '道具赠送详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/itemInit/itemInit_update/' + ItemInit.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除道具赠送
 */
ItemInit.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/itemInit/delete", function (data) {
                Feng.success("删除成功!");
                ItemInit.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("itemInitId",ItemInit.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + ItemInit.seItem.id + "?",operation);
    }
};

/**
 * 查询道具赠送列表
 */
ItemInit.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ItemInit.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ItemInit.initColumn();
    var table = new BSTable(ItemInit.id, "/itemInit/list", defaultColunms);
    table.setPaginationType("client");
    ItemInit.table = table.init();
});
