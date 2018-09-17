/**
 * 初始化道具赠送详情对话框
 */
var ItemInitInfoDlg = {
    itemInitInfoData : {}
};

/**
 * 清除数据
 */
ItemInitInfoDlg.clearData = function() {
    this.itemInitInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ItemInitInfoDlg.set = function(key, val) {
    this.itemInitInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ItemInitInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ItemInitInfoDlg.close = function() {
    parent.layer.close(window.parent.ItemInit.layerIndex);
}

/**
 * 收集数据
 */
ItemInitInfoDlg.collectData = function() {
    this
    .set('id')
    .set('itemId')
    .set('gameId')
    .set('num');
}

/**
 * 提交添加
 */
ItemInitInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/itemInit/add", function(data){
        Feng.success("添加成功!");
        window.parent.ItemInit.table.refresh();
        ItemInitInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.itemInitInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ItemInitInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/itemInit/update", function(data){
        Feng.success("修改成功!");
        window.parent.ItemInit.table.refresh();
        ItemInitInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.itemInitInfoData);
    ajax.start();
}

$(function() {

});
