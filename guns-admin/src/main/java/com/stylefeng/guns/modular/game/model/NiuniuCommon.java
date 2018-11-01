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
public class NiuniuCommon extends Model<NiuniuCommon> {

    private static final long serialVersionUID = 1L;

    /**
     * 配置表序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 抢庄几率
     */
    @TableField("rob_dealer_pct")
    private Integer robDealerPct;
    /**
     * 出现机器人的百分比(30,30,40)
     */
    @TableField("robot_join_pct")
    private String robotJoinPct;
    /**
     * 资金池初始值
     */
    @TableField("pool_money")
    private Long poolMoney;
    /**
     * 每局牌流水的百分比[0-100]
     */
    @TableField("total_lose_pct")
    private Integer totalLosePct;
    /**
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
     * 抢庄倒计时
     */
    @TableField("rob_zhuang_cd")
    private Integer robZhuangCd;
    /**
     * 定庄倒计时
     */
    @TableField("fix_dealer_cd")
    private Integer fixDealerCd;
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
    /**
     * 策略比值(大值)
     */
    @TableField("strategy_max_pct")
    private Double strategyMaxPct;
    /**
     * 策略比值(小值)
     */
    @TableField("strategy_min_pct")
    private Double strategyMinPct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRobDealerPct() {
        return robDealerPct;
    }

    public void setRobDealerPct(Integer robDealerPct) {
        this.robDealerPct = robDealerPct;
    }

    public String getRobotJoinPct() {
        return robotJoinPct;
    }

    public void setRobotJoinPct(String robotJoinPct) {
        this.robotJoinPct = robotJoinPct;
    }

    public Long getPoolMoney() {
        return poolMoney;
    }

    public void setPoolMoney(Long poolMoney) {
        this.poolMoney = poolMoney;
    }

    public Integer getTotalLosePct() {
        return totalLosePct;
    }

    public void setTotalLosePct(Integer totalLosePct) {
        this.totalLosePct = totalLosePct;
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

    public Integer getRobZhuangCd() {
        return robZhuangCd;
    }

    public void setRobZhuangCd(Integer robZhuangCd) {
        this.robZhuangCd = robZhuangCd;
    }

    public Integer getFixDealerCd() {
        return fixDealerCd;
    }

    public void setFixDealerCd(Integer fixDealerCd) {
        this.fixDealerCd = fixDealerCd;
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

    public Double getStrategyMaxPct() {
        return strategyMaxPct;
    }

    public void setStrategyMaxPct(Double strategyMaxPct) {
        this.strategyMaxPct = strategyMaxPct;
    }

    public Double getStrategyMinPct() {
        return strategyMinPct;
    }

    public void setStrategyMinPct(Double strategyMinPct) {
        this.strategyMinPct = strategyMinPct;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "NiuniuCommon{" +
        "id=" + id +
        ", robDealerPct=" + robDealerPct +
        ", robotJoinPct=" + robotJoinPct +
        ", poolMoney=" + poolMoney +
        ", totalLosePct=" + totalLosePct +
        ", gameStartCd=" + gameStartCd +
        ", betCd=" + betCd +
        ", robZhuangCd=" + robZhuangCd +
        ", fixDealerCd=" + fixDealerCd +
        ", openCardsCd=" + openCardsCd +
        ", settleCd=" + settleCd +
        ", strategyMaxPct=" + strategyMaxPct +
        ", strategyMinPct=" + strategyMinPct +
        "}";
    }
}
