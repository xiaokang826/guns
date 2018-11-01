/**
 * 初始化炸金花通用配置详情对话框
 */
var GoldCommonInfoDlg = {
    goldCommonInfoData : {}
};

/**
 * 清除数据
 */
GoldCommonInfoDlg.clearData = function() {
    this.goldCommonInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoldCommonInfoDlg.set = function(key, val) {
    this.goldCommonInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoldCommonInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GoldCommonInfoDlg.close = function() {
    parent.layer.close(window.parent.GoldCommon.layerIndex);
}

/**
 * 收集数据
 */
GoldCommonInfoDlg.collectData = function() {
    this
    .set('id')
    .set('playType')
    .set('isChangeCard')
    .set('changeFee')
    .set('settleType')
    .set('isAllowSideshow')
    .set('isSideshowUser')
    .set('allowSideshowCd')
    .set('betCd')
    .set('gameStartCd');
}

/**
 * 提交添加
 */
GoldCommonInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/goldCommon/add", function(data){
        Feng.success("添加成功!");
        window.parent.GoldCommon.table.refresh();
        GoldCommonInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.goldCommonInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
GoldCommonInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/goldCommon/update", function(data){
        Feng.success("修改成功!");
        window.parent.GoldCommon.table.refresh();
        GoldCommonInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.goldCommonInfoData);
    ajax.start();
}

$(function() {

});
