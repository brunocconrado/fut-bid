package br.com.futbid.domain;

import br.com.futbid.domain.enumeration.search.ActionDuration;

public class Settings {

    private Long minInWallet;
    private Long sleepTime;

    private Integer tradePileSize;
    private Integer maxBoughtCountPerMin;
    private Integer watchListSize;
    private Integer maxBidCountPerCycle;

    private ActionDuration actionDuration;

    private boolean dontBuy;
    private boolean stopBidIfTradePileIsFull;
    private boolean logToFile;

    public Long getSleepTime() {
	return sleepTime;
    }

    public void setSleepTime(Long sleepTime) {
	this.sleepTime = sleepTime;
    }

    public Integer getTradePileSize() {
	return tradePileSize;
    }

    public void setTradePileSize(Integer tradePileSize) {
	this.tradePileSize = tradePileSize;
    }

    public ActionDuration getActionDuration() {
	return actionDuration;
    }

    public void setActionDuration(ActionDuration actionDuration) {
	this.actionDuration = actionDuration;
    }

    public Integer getMaxBoughtCountPerMin() {
	return maxBoughtCountPerMin;
    }

    public void setMaxBoughtCountPerMin(Integer maxBoughtCountPerMin) {
	this.maxBoughtCountPerMin = maxBoughtCountPerMin;
    }

    public Long getMinInWallet() {
	return minInWallet;
    }

    public void setMinInWallet(Long minInWallet) {
	this.minInWallet = minInWallet;
    }

    public Integer getWatchListSize() {
	return watchListSize;
    }

    public void setWatchListSize(Integer watchListSize) {
	this.watchListSize = watchListSize;
    }

    public Integer getMaxBidCountPerCycle() {
	return maxBidCountPerCycle;
    }

    public void setMaxBidCountPerCycle(Integer maxBidCountPerCycle) {
	this.maxBidCountPerCycle = maxBidCountPerCycle;
    }

    public boolean isDontBuy() {
	return dontBuy;
    }

    public void setDontBuy(boolean dontBuy) {
	this.dontBuy = dontBuy;
    }

    public boolean isStopBidIfTradePileIsFull() {
	return stopBidIfTradePileIsFull;
    }

    public void setStopBidIfTradePileIsFull(boolean stopBidIfTradePileIsFull) {
	this.stopBidIfTradePileIsFull = stopBidIfTradePileIsFull;
    }

    public boolean isLogToFile() {
	return logToFile;
    }

    public void setLogToFile(boolean logToFile) {
	this.logToFile = logToFile;
    }

    @Override
    public String toString() {
	return "Settings [" + (minInWallet != null ? "minInWallet: " + minInWallet + ", " : "")
		+ (sleepTime != null ? "sleepTime: " + sleepTime + ", " : "")
		+ (tradePileSize != null ? "tradePileSize: " + tradePileSize + ", " : "")
		+ (maxBoughtCountPerMin != null ? "maxBoughtCountPerMin: " + maxBoughtCountPerMin + ", " : "")
		+ (watchListSize != null ? "watchListSize: " + watchListSize + ", " : "")
		+ (maxBidCountPerCycle != null ? "maxBidCountPerCycle: " + maxBidCountPerCycle + ", " : "")
		+ (actionDuration != null ? "actionDuration: " + actionDuration + ", " : "") + "dontBuy: " + dontBuy
		+ ", stopBidIfTradePileIsFull: " + stopBidIfTradePileIsFull + ", logToFile: " + logToFile + " ]";
    }

}
