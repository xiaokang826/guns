/**
 * 初始化炸金花房间配置详情对话框
 */
var GoldRoomInfoDlg = {
    goldRoomInfoData : {}
};

/**
 * 清除数据
 */
GoldRoomInfoDlg.clearData = function() {
    this.goldRoomInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoldRoomInfoDlg.set = function(key, val) {
    this.goldRoomInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GoldRoomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GoldRoomInfoDlg.close = function() {
    parent.layer.close(window.parent.GoldRoom.layerIndex);
}

/**
 * 收集数据
 */
GoldRoomInfoDlg.collectData = function() {
    this
    .set('id')
    .set('roomId')
    .set('minJoinTable')
    .set('ante')
    .set('firstBetScore')
    .set('maxBetScore')
    .set('serviceCharge')
    .set('maxBlindRound')
    .set('maxPot')
    .set('tipValue')
    .set('changeFee')
    .set('changeFeeTips')
    .set('changeCardFee')
    .set('changeCardFeeTips')
    .set('firstBaseBetScore')
    .set('minScore4joinTable')
    .set('serviceChargeRate')
    .set('doubleRoles')
    .set('xiQian');
}


/**
 * 提交操作
 */
GoldRoomInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/goldRoom/add", function(data){
        Feng.success("添加成功!");
        window.parent.GoldRoom.table.refresh();
        GoldRoomInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.goldRoomInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
GoldRoomInfoDlg.operationSubmit = function(operation) {
    this.clearData();
    this.collectData();
    var str = operation == "add" ? "添加" : "修改";
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/goldRoom/"+operation, function(data){
        Feng.success(str+"成功!");
        window.parent.GoldRoom.table.refresh();
        GoldRoomInfoDlg.close();
    },function(data){
        Feng.error(str+"失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.goldRoomInfoData);
    ajax.start();
}

$(function() {

});
