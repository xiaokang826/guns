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
 * @since 2018-10-31
 */
@TableName("common_config")
public class DominoCommon extends Model<DominoCommon> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /*
     * 游戏开始倒计时（发牌前倒计时）
     */
    @TableField("game_start_cd")
    private Integer gameStartCd;
    /**
     * 下注倒计时
     */
    @TableField("bet_cd")
    private Integer betCd;
    /**
     * 开牌倒计时
     */
    @TableField("open_cards_cd")
    private Integer openCardsCd;
    /**
     * 结算倒计时
     */
    @TableField("settle_cd")
    private Integer settleCd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameStartCd() {
        return gameStartCd;
    }

    public void setGameStartCd(Integer gameStartCd) {
        this.gameStartCd = gameStartCd;
    }

    public Integer getBetCd() {
        return betCd;
    }

    public void setBetCd(Integer betCd) {
        this.betCd = betCd;
    }

    public Integer getOpenCardsCd() {
        return openCardsCd;
    }

    public void setOpenCardsCd(Integer openCardsCd) {
        this.openCardsCd = openCardsCd;
    }

    public Integer getSettleCd() {
        return settleCd;
    }

    public void setSettleCd(Integer settleCd) {
        this.settleCd = settleCd;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
