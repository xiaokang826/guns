/**
 * 初始化牛牛房间配置详情对话框
 */
var NiuniuRoomInfoDlg = {
    niuniuRoomInfoData : {}
};

/**
 * 清除数据
 */
NiuniuRoomInfoDlg.clearData = function() {
    this.niuniuRoomInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NiuniuRoomInfoDlg.set = function(key, val) {
    this.niuniuRoomInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NiuniuRoomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
NiuniuRoomInfoDlg.close = function() {
    parent.layer.close(window.parent.NiuniuRoom.layerIndex);
}

/**
 * 收集数据
 */
NiuniuRoomInfoDlg.collectData = function() {
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
 * 提交添加
 */
NiuniuRoomInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/niuniuRoom/add", function(data){
        Feng.success("添加成功!");
        window.parent.NiuniuRoom.table.refresh();
        NiuniuRoomInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.niuniuRoomInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
NiuniuRoomInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/niuniuRoom/update", function(data){
        Feng.success("修改成功!");
        window.parent.NiuniuRoom.table.refresh();
        NiuniuRoomInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.niuniuRoomInfoData);
    ajax.start();
}

$(function() {

});
