package br.com.futbid.domain;

public class Settings {

    private long sleepTime;
    private long tradePileSize;
    private long auctionDuration;

    private int maxBoughtCountPerMin;
    private int minCoinsValue;
    private int watchListSize;
    private int maxBidCountPerCycle;

    private boolean dontBuy;
    private boolean stopBidIfTradePileIsFull;
    private boolean logToFile;

    public long getSleepTime() {
	return sleepTime;
    }

    public void setSleepTime(long sleepTime) {
	this.sleepTime = sleepTime;
    }

    public long getTradePileSize() {
	return tradePileSize;
    }

    public void setTradePileSize(long tradePileSize) {
	this.tradePileSize = tradePileSize;
    }

    public long getAuctionDuration() {
	return auctionDuration;
    }

    public void setAuctionDuration(long auctionDuration) {
	this.auctionDuration = auctionDuration;
    }

    public int getMaxBoughtCountPerMin() {
	return maxBoughtCountPerMin;
    }

    public void setMaxBoughtCountPerMin(int maxBoughtCountPerMin) {
	this.maxBoughtCountPerMin = maxBoughtCountPerMin;
    }

    public int getMinCoinsValue() {
	return minCoinsValue;
    }

    public void setMinCoinsValue(int minCoinsValue) {
	this.minCoinsValue = minCoinsValue;
    }

    public int getWatchListSize() {
	return watchListSize;
    }

    public void setWatchListSize(int watchListSize) {
	this.watchListSize = watchListSize;
    }

    public int getMaxBidCountPerCycle() {
	return maxBidCountPerCycle;
    }

    public void setMaxBidCountPerCycle(int maxBidCountPerCycle) {
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

}
