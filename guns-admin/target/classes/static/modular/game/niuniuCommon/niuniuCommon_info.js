/**
 * 初始化牛牛通用配置详情对话框
 */
var NiuniuCommonInfoDlg = {
    niuniuCommonInfoData : {}
};

/**
 * 清除数据
 */
NiuniuCommonInfoDlg.clearData = function() {
    this.niuniuCommonInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NiuniuCommonInfoDlg.set = function(key, val) {
    this.niuniuCommonInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NiuniuCommonInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
NiuniuCommonInfoDlg.close = function() {
    parent.layer.close(window.parent.NiuniuCommon.layerIndex);
}

/**
 * 收集数据
 */
NiuniuCommonInfoDlg.collectData = function() {
    this
    .set('id')
    .set('playType')
    .set('robDealerPct')
    .set('robotJoinPct')
    .set('settleType')
    .set('poolMoney')
    .set('totalLosePct')
    .set('gameStartCd')
    .set('betCd')
    .set('robZhuangCd')
    .set('fixDealerCd')
    .set('openCardsCd')
    .set('settleCd')
    .set('strategyMaxPct')
    .set('strategyMinPct')
    .set('changeFee')
    .set('isAllowSideshow')
    .set('isSideshowUser');
}

/**
 * 提交操作
 */
NiuniuCommonInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/niuniuCommon/add", function(data){
        Feng.success("添加成功!");
        window.parent.NiuniuCommon.table.refresh();
        NiuniuCommonInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.niuniuCommonInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
NiuniuCommonInfoDlg.operationSubmit = function(operation) {
    this.clearData();
    this.collectData();
    var str = operation == "add" ? "添加" : "修改";
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/niuniuCommon/"+operation,function(data){
        Feng.success(str+"成功!");
        window.parent.NiuniuCommon.table.refresh();
        NiuniuCommonInfoDlg.close();
    },function(data){
        Feng.error(str+"失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.niuniuCommonInfoData);
    ajax.start();
}

$(function() {

});
