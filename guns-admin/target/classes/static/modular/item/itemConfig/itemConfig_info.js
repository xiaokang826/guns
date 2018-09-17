/**
 * 初始化道具配置详情对话框
 */
var ItemConfigInfoDlg = {
    itemConfigInfoData : {}
};

/**
 * 清除数据
 */
ItemConfigInfoDlg.clearData = function() {
    this.itemConfigInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ItemConfigInfoDlg.set = function(key, val) {
    this.itemConfigInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ItemConfigInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ItemConfigInfoDlg.close = function() {
    parent.layer.close(window.parent.ItemConfig.layerIndex);
}

/**
 * 收集数据
 */
ItemConfigInfoDlg.collectData = function() {
    this
    .set('id')
    .set('details')
    .set('extraPrice')
    .set('gameId')
    .set('itemIcon')
    .set('itemName')
    .set('itemType')
    .set('price')
    .set('tag')
    .set('timeOut');
}

/**
 * 提交添加
 */
ItemConfigInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/itemConfig/add", function(data){
        Feng.success("添加成功!");
        window.parent.ItemConfig.table.refresh();
        ItemConfigInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.itemConfigInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ItemConfigInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/itemConfig/update", function(data){
        Feng.success("修改成功!");
        window.parent.ItemConfig.table.refresh();
        ItemConfigInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.itemConfigInfoData);
    ajax.start();
}

$(function() {

});
