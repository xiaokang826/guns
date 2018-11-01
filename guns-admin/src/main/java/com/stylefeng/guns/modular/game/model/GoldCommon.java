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
@TableName("common_config")
public class GoldCommon extends Model<GoldCommon> {

    private static final long serialVersionUID = 1L;

    /**
     * 配置表序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 玩法
     */
    @TableField("play_type")
    private Integer playType;
    /**
     * 换牌开关
     */
    @TableField("is_change_card")
    private Integer isChangeCard;
    /**
     * 自动结算类型：1,底池上限 2,轮次上限
     */
    @TableField("settle_type")
    private Integer settleType;
    /**
     * 是否需要被比牌方同意比牌申请
     */
    @TableField("is_allow_sideshow")
    private Integer isAllowSideshow;
    /**
     * 是否可以选择指定用户进行比牌
     */
    @TableField("is_sideshow_user")
    private Integer isSideshowUser;
    /**
     * 被比方同意比牌弹窗的倒计时
     */
    @TableField("allow_sideshow_cd")
    private Integer allowSideshowCd;
    /**
     * 下注倒计时
     */
    @TableField("bet_cd")
    private Integer betCd;
    /**
     * 游戏开始倒计时（发牌前倒计时）
     */
    @TableField("game_start_cd")
    private Integer gameStartCd;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    public Integer getIsChangeCard() {
        return isChangeCard;
    }

    public void setIsChangeCard(Integer isChangeCard) {
        this.isChangeCard = isChangeCard;
    }

    public Integer getSettleType() {
        return settleType;
    }

    public void setSettleType(Integer settleType) {
        this.settleType = settleType;
    }

    public Integer getIsAllowSideshow() {
        return isAllowSideshow;
    }

    public void setIsAllowSideshow(Integer isAllowSideshow) {
        this.isAllowSideshow = isAllowSideshow;
    }

    public Integer getIsSideshowUser() {
        return isSideshowUser;
    }

    public void setIsSideshowUser(Integer isSideshowUser) {
        this.isSideshowUser = isSideshowUser;
    }

    public Integer getAllowSideshowCd() {
        return allowSideshowCd;
    }

    public void setAllowSideshowCd(Integer allowSideshowCd) {
        this.allowSideshowCd = allowSideshowCd;
    }

    public Integer getBetCd() {
        return betCd;
    }

    public void setBetCd(Integer betCd) {
        this.betCd = betCd;
    }

    public Integer getGameStartCd() {
        return gameStartCd;
    }

    public void setGameStartCd(Integer gameStartCd) {
        this.gameStartCd = gameStartCd;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "GoldCommon{" +
        "id=" + id +
        ", playType=" + playType +
        ", isChangeCard=" + isChangeCard +
        ", settleType=" + settleType +
        ", isAllowSideshow=" + isAllowSideshow +
        ", isSideshowUser=" + isSideshowUser +
        ", allowSideshowCd=" + allowSideshowCd +
        ", betCd=" + betCd +
        ", gameStartCd=" + gameStartCd +
        "}";
    }
}
