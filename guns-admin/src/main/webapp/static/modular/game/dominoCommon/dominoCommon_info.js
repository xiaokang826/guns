/**
 * 初始化牌九通用配置详情对话框
 */
var DominoCommonInfoDlg = {
    dominoCommonInfoData : {}
};

/**
 * 清除数据
 */
DominoCommonInfoDlg.clearData = function() {
    this.dominoCommonInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DominoCommonInfoDlg.set = function(key, val) {
    this.dominoCommonInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DominoCommonInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DominoCommonInfoDlg.close = function() {
    parent.layer.close(window.parent.DominoCommon.layerIndex);
}

/**
 * 收集数据
 */
DominoCommonInfoDlg.collectData = function() {
    this
    .set('id')
    .set('playType')
    .set('robDealerPct')
    .set('changeFee')
    .set('settleType')
    .set('isAllowSideshow')
    .set('isSideshowUser')
    .set('gameStartCd')
    .set('betCd')
    .set('robZhuangCd')
    .set('fixDealerCd')
    .set('openCardsCd')
    .set('settleCd');
}


/**
 * 提交操作
 */
DominoCommonInfoDlg.operationSubmit = function(operation) {
    this.clearData();
    this.collectData();
    var str = operation == "add" ? "添加" : "修改";
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dominoCommon/"+operation, function(data){
        Feng.success(str+"成功!");
        window.parent.DominoCommon.table.refresh();
        DominoCommonInfoDlg.close();
    },function(data){
        Feng.error(str+"失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dominoCommonInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DominoCommonInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dominoCommon/update", function(data){
        Feng.success("修改成功!");
        window.parent.DominoCommon.table.refresh();
        DominoCommonInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dominoCommonInfoData);
    ajax.start();
}

$(function() {

});
