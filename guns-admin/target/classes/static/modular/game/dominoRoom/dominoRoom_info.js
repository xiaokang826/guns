/**
 * 初始化牌九房间配置详情对话框
 */
var DominoRoomInfoDlg = {
    dominoRoomInfoData : {}
};

/**
 * 清除数据
 */
DominoRoomInfoDlg.clearData = function() {
    this.dominoRoomInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DominoRoomInfoDlg.set = function(key, val) {
    this.dominoRoomInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DominoRoomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DominoRoomInfoDlg.close = function() {
    parent.layer.close(window.parent.DominoRoom.layerIndex);
}

/**
 * 收集数据
 */
DominoRoomInfoDlg.collectData = function() {
    this
    .set('id')
    .set('roomId')
    .set('minJoinTable')
    .set('ante')
    .set('serviceCharge')
    .set('robMultiple')
    .set('doubleRoles')
    .set('onOff')
    .set('changeFee')
    .set('changeFeeTips')
    .set('firstBetScore')
    .set('maxBetScore')
    .set('maxBlindRound')
    .set('maxPot')
    .set('tipValue');
}

/**
 * 提交操作
 */
DominoRoomInfoDlg.operationSubmit = function(operation) {
    this.clearData();
    this.collectData();
    var str = operation == "add" ? "添加" : "修改";
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dominoRoom/"+operation, function(data){
        Feng.success(str+"成功!");
        window.parent.DominoRoom.table.refresh();
        DominoRoomInfoDlg.close();
    },function(data){
        Feng.error(str+"失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dominoRoomInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DominoRoomInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dominoRoom/update", function(data){
        Feng.success("修改成功!");
        window.parent.DominoRoom.table.refresh();
        DominoRoomInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dominoRoomInfoData);
    ajax.start();
}

$(function() {
    //初始化房间开关
    if($("#onOffValue").val() == undefined || $("#onOffValue").val() == ""){
        $("#onOff").val(0);
    }else {
        $("#onOff").val($("#onOffValue").val());
    }
});
