package com.stylefeng.guns.modular.game.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panghu
 * @since 2018-11-01
 */
@TableName("room_config")
public class NiuniuRoom extends Model<NiuniuRoom> {

    private static final long serialVersionUID = 1L;

    /**
     * 房间序列号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 房间id
     */
    @TableField("room_id")
    private String roomId;
    /**
     * 入桌的最小积分
     */
    @TableField("min_join_table")
    private Long minJoinTable;
    /**
     * 底注
     */
    private Long ante;
    /**
     * 服务费比率
     */
    @TableField("service_charge")
    private Double serviceCharge;
    /**
     * 抢庄倍数
     */
    @TableField("rob_multiple")
    private String robMultiple;
    /**
     * 加倍倍数
     */
    private String doubleRoles;
    /**
     * 房间开关
     */
    @TableField("on_off")
    private Integer onOff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Long getMinJoinTable() {
        return minJoinTable;
    }

    public void setMinJoinTable(Long minJoinTable) {
        this.minJoinTable = minJoinTable;
    }

    public Long getAnte() {
        return ante;
    }

    public void setAnte(Long ante) {
        this.ante = ante;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getRobMultiple() {
        return robMultiple;
    }

    public void setRobMultiple(String robMultiple) {
        this.robMultiple = robMultiple;
    }

    public String getDoubleRoles() {
        return doubleRoles;
    }

    public void setDoubleRoles(String doubleRoles) {
        this.doubleRoles = doubleRoles;
    }

    public Integer getOnOff() {
        return onOff;
    }

    public void setOnOff(Integer onOff) {
        this.onOff = onOff;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "NiuniuRoom{" +
        "id=" + id +
        ", roomId=" + roomId +
        ", minJoinTable=" + minJoinTable +
        ", ante=" + ante +
        ", serviceCharge=" + serviceCharge +
        ", robMultiple=" + robMultiple +
        ", doubleRoles=" + doubleRoles +
        ", onOff=" + onOff +
        "}";
    }
}
