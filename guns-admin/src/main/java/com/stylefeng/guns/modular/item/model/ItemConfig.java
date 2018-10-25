package com.stylefeng.guns.modular.item.model;

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
 * @since 2018-10-22
 */
@TableName("item_config")
public class ItemConfig extends Model<ItemConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 描述
     */
    private String details;
    /**
     * 额外价值
     */
    @TableField("extra_price")
    private Integer extraPrice;
    /**
     * 游戏
     */
    @TableField("game_id")
    private Integer gameId;
    /**
     * 物品icon
     */
    @TableField("item_icon")
    private String itemIcon;
    /**
     * 物品名称
     */
    @TableField("item_name")
    private String itemName;
    /**
     * 物品类型(1:货币类型2：体力类型3：阳光类型4：普通物品5：限时物品6：皮肤7：限时头像8：限时NPC9：限时礼物10：头像11：NPC12：礼物)
     */
    @TableField("item_type")
    private Integer itemType;
    /**
     * 价值
     */
    private Integer price;
    /**
     * 标签
     */
    private Integer tag;
    /**
     * 过期时间
     */
    @TableField("time_out")
    private Integer timeOut;

    /**
     * 是否赠送
     */
    private Integer isGive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(Integer extraPrice) {
        this.extraPrice = extraPrice;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getIsGive() {
        return isGive;
    }

    public void setIsGive(Integer isGive) {
        this.isGive = isGive;
    }

    @Override
    public String toString() {
        return "ItemConfig{" +
        "id=" + id +
        ", details=" + details +
        ", extraPrice=" + extraPrice +
        ", gameId=" + gameId +
        ", itemIcon=" + itemIcon +
        ", itemName=" + itemName +
        ", itemType=" + itemType +
        ", price=" + price +
        ", tag=" + tag +
        ", timeOut=" + timeOut +
        "}";
    }
}
