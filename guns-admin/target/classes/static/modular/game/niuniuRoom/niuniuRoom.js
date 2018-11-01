/**
 * 牛牛房间配置管理初始化
 */
var NiuniuRoom = {
    id: "NiuniuRoomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
NiuniuRoom.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            // {title: '序列号', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '房间id', field: 'roomId', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '入桌最小积分', field: 'minJoinTable', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '底注', field: 'ante', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '服务费比率', field: 'serviceCharge', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '抢庄倍数', field: 'robMultiple', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '房间开关', field: 'onOff', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
NiuniuRoom.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        NiuniuRoom.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加牛牛房间配置
 */
NiuniuRoom.openAddNiuniuRoom = function () {
    var index = layer.open({
        type: 2,
        title: '添加牛牛房间配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/niuniuRoom/niuniuRoom_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看牛牛房间配置详情
 */
NiuniuRoom.openNiuniuRoomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '牛牛房间配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/niuniuRoom/niuniuRoom_update/' + NiuniuRoom.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除牛牛房间配置
 */
NiuniuRoom.delete = function () {
    if (this.check()) {
        var operation = function() {
            var ajax = new $ax(Feng.ctxPath + "/niuniuRoom/delete", function (data) {
                Feng.success("删除成功!");
                NiuniuRoom.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("niuniuRoomId",NiuniuRoom.seItem.id);
            ajax.start();
        };
        Feng.confirm("是否删除ID " + NiuniuRoom.seItem.id + "?",operation);
    }
};

/**
 * 查询牛牛房间配置列表
 */
NiuniuRoom.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    NiuniuRoom.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = NiuniuRoom.initColumn();
    var table = new BSTable(NiuniuRoom.id, "/niuniuRoom/list", defaultColunms);
    table.setPaginationType("client");
    NiuniuRoom.table = table.init();
});
