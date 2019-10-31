package com.yzsunlei.xmall.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class PmsProductExpand extends PmsProduct{
    private String barCode;
    private Long categoryId;//
    private String characteristic;//
    private Integer commission;//
    private Integer commissionType;//
    private Date dateAdd;
    private Date dateStart;
    private Date dateUpdate;
    private Integer gotScore;
    private Integer gotScoreType;
    private Boolean kanjia;
    private BigDecimal kanjiaPrice;
    private Boolean limitation;
    private Long logisticsId;
    private Boolean miaosha;
    private BigDecimal minPrice;
    private Integer minScore;
    private Integer numberFav;//收藏量
    private Integer numberGoodReputation;//好评
    private Integer numberOrders;//订单数
    private Integer numberSells;//销售数
    private Integer paixu;
    private Boolean pingtuan;
    private BigDecimal pingtuanPrice;
    private String propertyIds;
    private Integer recommendStatus;
    private String recommendStatusStr;
    private Long shopId;
    private String statusStr;
    private Integer stores;
    private Long userId;
    private Integer vetStatus;
    private String videoId;
    private Integer views;


    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Integer commissionType) {
        this.commissionType = commissionType;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Integer getGotScore() {
        return gotScore;
    }

    public void setGotScore(Integer gotScore) {
        this.gotScore = gotScore;
    }

    public Integer getGotScoreType() {
        return gotScoreType;
    }

    public void setGotScoreType(Integer gotScoreType) {
        this.gotScoreType = gotScoreType;
    }

    public Boolean getKanjia() {
        return kanjia;
    }

    public void setKanjia(Boolean kanjia) {
        this.kanjia = kanjia;
    }

    public BigDecimal getKanjiaPrice() {
        return kanjiaPrice;
    }

    public void setKanjiaPrice(BigDecimal kanjiaPrice) {
        this.kanjiaPrice = kanjiaPrice;
    }

    public Boolean getLimitation() {
        return limitation;
    }

    public void setLimitation(Boolean limitation) {
        this.limitation = limitation;
    }

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Boolean getMiaosha() {
        return miaosha;
    }

    public void setMiaosha(Boolean miaosha) {
        this.miaosha = miaosha;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getNumberFav() {
        return numberFav;
    }

    public void setNumberFav(Integer numberFav) {
        this.numberFav = numberFav;
    }

    public Integer getNumberGoodReputation() {
        return numberGoodReputation;
    }

    public void setNumberGoodReputation(Integer numberGoodReputation) {
        this.numberGoodReputation = numberGoodReputation;
    }

    public Integer getNumberOrders() {
        return numberOrders;
    }

    public void setNumberOrders(Integer numberOrders) {
        this.numberOrders = numberOrders;
    }

    public Integer getNumberSells() {
        return numberSells;
    }

    public void setNumberSells(Integer numberSells) {
        this.numberSells = numberSells;
    }

    public Integer getPaixu() {
        return paixu;
    }

    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public Boolean getPingtuan() {
        return pingtuan;
    }

    public void setPingtuan(Boolean pingtuan) {
        this.pingtuan = pingtuan;
    }

    public BigDecimal getPingtuanPrice() {
        return pingtuanPrice;
    }

    public void setPingtuanPrice(BigDecimal pingtuanPrice) {
        this.pingtuanPrice = pingtuanPrice;
    }

    public String getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(String propertyIds) {
        this.propertyIds = propertyIds;
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public String getRecommendStatusStr() {
        return recommendStatusStr;
    }

    public void setRecommendStatusStr(String recommendStatusStr) {
        this.recommendStatusStr = recommendStatusStr;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getStores() {
        return stores;
    }

    public void setStores(Integer stores) {
        this.stores = stores;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getVetStatus() {
        return vetStatus;
    }

    public void setVetStatus(Integer vetStatus) {
        this.vetStatus = vetStatus;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
