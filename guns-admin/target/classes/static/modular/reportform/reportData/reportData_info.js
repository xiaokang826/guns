/**
 * 初始化输赢报表详情对话框
 */
var ReportDataInfoDlg = {
    reportDataInfoData : {}
};

/**
 * 清除数据
 */
ReportDataInfoDlg.clearData = function() {
    this.reportDataInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReportDataInfoDlg.set = function(key, val) {
    this.reportDataInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReportDataInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ReportDataInfoDlg.close = function() {
    parent.layer.close(window.parent.ReportData.layerIndex);
}

/**
 * 收集数据
 */
ReportDataInfoDlg.collectData = function() {
    this
    .set('id')
    .set('accountChangeTime')
    .set('userName')
    .set('gameName')
    .set('roomType')
    .set('tableNumber')
    .set('seatNumber')
    .set('leisure')
    .set('initialAmount')
    .set('totalBet')
    .set('validBet')
    .set('winLoseAmount')
    .set('boardNumber')
    .set('gameResult')
    .set('gameStartTime')
    .set('gameEndTime')
    .set('logDetails')
    .set('orderNumber')
    .set('orderDetails')
    .set('accountType')
    .set('amountBeforeChange')
    .set('accountChangeAmount')
    .set('amountAfterChange')
    .set('operator');
}

/**
 * 提交添加
 */
ReportDataInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reportData/add", function(data){
        Feng.success("添加成功!");
        window.parent.ReportData.table.refresh();
        ReportDataInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.reportDataInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ReportDataInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reportData/update", function(data){
        Feng.success("修改成功!");
        window.parent.ReportData.table.refresh();
        ReportDataInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.reportDataInfoData);
    ajax.start();
}

$(function() {

});
