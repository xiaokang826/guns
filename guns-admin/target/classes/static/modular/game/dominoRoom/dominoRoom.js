/**
 * 牌九房间配置管理初始化
 */
var DominoRoom = {
    id: "DominoRoomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DominoRoom.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        // {title: '序列号', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '房间id', field: 'roomId', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '入桌最小积分', field: 'minJoinTable', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '底注', field: 'ante', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '服务费比率', field: 'serviceCharge', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '加倍倍数', field: 'doubleRoles', visible: true, align: 'center', valign: 'middle',sortable: true},
        {title: '房间开关', field: 'onOff', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
DominoRoom.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DominoRoom.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加牌九房间配置
 */
DominoRoom.openAddDominoRoom = function () {
    var index = layer.open({
        type: 2,
        title: '添加牌九房间配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dominoRoom/dominoRoom_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看牌九房间配置详情
 */
DominoRoom.openDominoRoomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '牌九房间配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dominoRoom/dominoRoom_update/' + DominoRoom.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除牌九房间配置
 */
DominoRoom.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/dominoRoom/delete", function (data) {
                Feng.success("删除成功!");
                DominoRoom.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("dominoRoomId",DominoRoom.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + DominoRoom.seItem.id + "?",operation);
    }
};

/**
 * 查询牌九房间配置列表
 */
DominoRoom.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DominoRoom.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DominoRoom.initColumn();
    var table = new BSTable(DominoRoom.id, "/dominoRoom/list", defaultColunms);
    table.setPaginationType("client");
    DominoRoom.table = table.init();
});
