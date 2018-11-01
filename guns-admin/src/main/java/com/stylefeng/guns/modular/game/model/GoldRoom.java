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
public class GoldRoom extends Model<GoldRoom> {

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
     * 第一次下注的基础注
     */
    @TableField("first_bet_score")
    private Long firstBetScore;
    /**
     * 最大下注额度，任何轮次的下注额不能大于此值
     */
    @TableField("max_bet_score")
    private Long maxBetScore;
    /**
     * 服务费比率
     */
    @TableField("service_charge")
    private Double serviceCharge;
    /**
     * 盲牌最多可以进行的轮次数
     */
    @TableField("max_blind_round")
    private Integer maxBlindRound;
    /**
     * 总封：底池最大的累积积分数，达到此值，全部玩家自动开牌，进行牌局结算
     */
    @TableField("max_pot")
    private Long maxPot;
    /**
     * 荷官打赏数量
     */
    @TableField("tip_value")
    private Integer tipValue;
    /**
     * 换牌所需费用
     */
    @TableField("change_fee")
    private Long changeFee;
    /**
     * 换牌服务费
     */
    @TableField("change_fee_tips")
    private Integer changeFeeTips;
    /**
     * 加倍规则
     */
    private String doubleRoles;
    /**
     * 喜钱
     */
    private Integer xiQian;


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

    public Long getFirstBetScore() {
        return firstBetScore;
    }

    public void setFirstBetScore(Long firstBetScore) {
        this.firstBetScore = firstBetScore;
    }

    public Long getMaxBetScore() {
        return maxBetScore;
    }

    public void setMaxBetScore(Long maxBetScore) {
        this.maxBetScore = maxBetScore;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Integer getMaxBlindRound() {
        return maxBlindRound;
    }

    public void setMaxBlindRound(Integer maxBlindRound) {
        this.maxBlindRound = maxBlindRound;
    }

    public Long getMaxPot() {
        return maxPot;
    }

    public void setMaxPot(Long maxPot) {
        this.maxPot = maxPot;
    }

    public Integer getTipValue() {
        return tipValue;
    }

    public void setTipValue(Integer tipValue) {
        this.tipValue = tipValue;
    }

    public Long getChangeFee() {
        return changeFee;
    }

    public void setChangeFee(Long changeFee) {
        this.changeFee = changeFee;
    }

    public Integer getChangeFeeTips() {
        return changeFeeTips;
    }

    public void setChangeFeeTips(Integer changeFeeTips) {
        this.changeFeeTips = changeFeeTips;
    }

    public String getDoubleRoles() {
        return doubleRoles;
    }

    public void setDoubleRoles(String doubleRoles) {
        this.doubleRoles = doubleRoles;
    }

    public Integer getXiQian() {
        return xiQian;
    }

    public void setXiQian(Integer xiQian) {
        this.xiQian = xiQian;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "GoldRoom{" +
        "id=" + id +
        ", roomId=" + roomId +
        ", minJoinTable=" + minJoinTable +
        ", ante=" + ante +
        ", firstBetScore=" + firstBetScore +
        ", maxBetScore=" + maxBetScore +
        ", serviceCharge=" + serviceCharge +
        ", maxBlindRound=" + maxBlindRound +
        ", maxPot=" + maxPot +
        ", tipValue=" + tipValue +
        ", changeFee=" + changeFee +
        ", changeFeeTips=" + changeFeeTips +
        ", doubleRoles=" + doubleRoles +
        ", xiQian=" + xiQian +
        "}";
    }
}
