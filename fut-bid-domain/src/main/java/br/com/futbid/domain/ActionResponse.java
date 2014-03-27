/*  1:   */package br.com.futbid.domain;

/*  2:   */
/*  3:   */import java.util.ArrayList;
import java.util.List;

import br.com.futbid.domain.legacy.BidTokens;
import br.com.futbid.domain.legacy.Currency;

public class ActionResponse {
    
    private Integer credits;
    private BidTokens bidTokens;
    private List<Currency> currencies;
    private List<ActionInfo> actionsInfo;

    public ActionResponse() {
	actionsInfo = new ArrayList<>();
	currencies = new ArrayList<>();
    }

    public List<ActionInfo> getActionsInfo() {
	return actionsInfo;
    }

    public void setActionsInfo(List<ActionInfo> actionsInfo) {
	this.actionsInfo = actionsInfo;
    }

    public Integer getCredits() {
	return this.credits;
    }

    public void setCredits(Integer credits) {
	this.credits = credits;
    }

    public BidTokens getBidTokens() {
	return this.bidTokens;
    }

    public void setBidTokens(BidTokens bidTokens) {
	this.bidTokens = bidTokens;
    }

    public List<Currency> getCurrencies() {
	return this.currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
	this.currencies = currencies;
    }
}