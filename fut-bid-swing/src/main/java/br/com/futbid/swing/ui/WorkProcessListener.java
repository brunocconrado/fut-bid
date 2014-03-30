package br.com.futbid.swing.ui;

import br.com.futbid.service.listener.AutoBuyerListener;
/*import br.com.futbid.swing.ui.panel.work.impl.AuctionInfo;
import br.com.futbid.swing.ui.panel.work.impl.AutobuyerPanel;
import br.com.futbid.swing.ui.panel.work.impl.BiddedModelView;
import br.com.futbid.swing.ui.panel.work.impl.IAutobuyerProcessorListener;
import br.com.futbid.swing.ui.panel.work.impl.ItemData;
import br.com.futbid.swing.ui.panel.work.impl.SearchParameters;
*/
public class WorkProcessListener implements AutoBuyerListener {
    
    //private WorkPanel
    
   /* public void autobuyerStopped() {
	DialogMessageUtil.showWarningMessage("Your coins value <= allowed limit!");
    }

    public void itemSold(ItemData id, int soldItemCounter) {
	AutobuyerPanel.this.currentSoldItemLabel.setText(soldItemCounter + "");
    }

    public void itemBought(ItemData id, int currentBoughtCount) {
	AutobuyerPanel.this.currentBoughtItemLabel.setText(currentBoughtCount + "");
    }

    public void updateBalance(double balance) {
	AutobuyerPanel.this.currentBalanceLebel.setText((int) balance + "");
    }

    public void addLogMessage(String logMsg) {
	StringBuilder log = new StringBuilder(
		AutobuyerPanel.this.logField.getText().split("\n").length > 1000 ? AutobuyerPanel.this.logField
			.getText().substring(0, 1000) : AutobuyerPanel.this.logField.getText());

	log.insert(0, logMsg + "\n");
	AutobuyerPanel.this.logField.setText(log.toString());
    }

    public void currentOperation(IAutobuyerProcessorListener.Operation operation) {
	if (operation.equals(IAutobuyerProcessorListener.Operation.start)) {
	    AutobuyerPanel.this.applciationStatusLabel.setText("Application work");
	    AutobuyerPanel.this.applciationStatusLabel.setForeground(Color.BLACK);
	    AutobuyerPanel.this.workControllButton.setText("Stop");
	    AutobuyerPanel.this.workControllButton.setEnabled(true);
	} else if (operation.equals(IAutobuyerProcessorListener.Operation.stopped)) {
	    AutobuyerPanel.this.applciationStatusLabel.setText("Application stopped");
	    AutobuyerPanel.this.applciationStatusLabel.setForeground(Color.RED);
	} else if (operation.equals(IAutobuyerProcessorListener.Operation.reconnect)) {
	    AutobuyerPanel.this.currentActionLabel.setForeground(Color.RED);
	    AutobuyerPanel.this.workControllButton.setEnabled(false);
	} else if (operation.equals(IAutobuyerProcessorListener.Operation.reconected)) {
	    AutobuyerPanel.this.currentActionLabel.setForeground(Color.BLACK);
	    AutobuyerPanel.this.workControllButton.setEnabled(true);
	}
	AutobuyerPanel.this.currentActionLabel.setText(operation.getValue());
    }

    public void autobuyerStopComplete() {
	if (AutobuyerPanel.this.makeLogoutWhenStopped) {
	    AutobuyerPanel.this.logoutAction();
	    AutobuyerPanel.this.makeLogoutWhenStopped = false;
	}
	AutobuyerPanel.this.biddedModels.clear();
	AutobuyerPanel.this.refreshWatchList();
	AutobuyerPanel.this.watchListLable.setText("Watch list:");

	AutobuyerPanel.this.workControllButton.setText("Start");
	AutobuyerPanel.this.workControllButton.setEnabled(true);
	AutobuyerPanel.this.autobidderMode.setEnabled(true);
	AutobuyerPanel.this.autobuyerMode.setEnabled(true);
    }

    public void refreshAuctionCount(int size) {
	AutobuyerPanel.this.currentAuctionSizeLabel.setText(size + "");
    }

    public void itemBidded(AuctionInfo ai, int price, SearchParameters sp, int count) {
	AutobuyerPanel.this.watchListLable.setText("Watch list: (" + count + ")");

	BiddedModelView model = new BiddedModelView(ai.getItemData().getId(), sp.getCardName(),
		sp.getCardIdentifier(), price + "",
		VerificationUtil.convertSecondsToTimeString(ai.getExpires()));

	AutobuyerPanel.this.biddedModels.add(model);

	AutobuyerPanel.this.refreshWatchList();
    }

    public void updateBiddedItem(AuctionInfo ai, int size, boolean exist) {
	AutobuyerPanel.this.watchListLable.setText("Watch list: (" + size + ")");
	if (exist) {
	    boolean updated = false;
	    for (BiddedModelView model : AutobuyerPanel.this.biddedModels) {
		if (((updated = (model.getId() == ai.getItemData().getId())) ? 1 : 0) != 0) {
		    model.setTimeLeft(VerificationUtil.convertSecondsToTimeString(ai.getExpires()));
		    model.setPrice(ai.getCurrentBid() + "");
		    break;
		}
	    }
	    if (!updated) {
		BiddedModelView model = new BiddedModelView(ai.getItemData().getId(), "unknown", "unknown",
			ai.getCurrentBid() + "", VerificationUtil.convertSecondsToTimeString(ai.getExpires()));

		AutobuyerPanel.this.biddedModels.add(model);
	    }
	} else {
	    BiddedModelView model = new BiddedModelView(ai.getItemData().getId(), null, null, null, null);

	    AutobuyerPanel.this.biddedModels.remove(model);
	}
    }

    public void addItemToWatchList(AuctionInfo ai, SearchParameters sp, int size) {
	BiddedModelView model = new BiddedModelView(ai.getItemData().getId(), sp.getCardName(),
		sp.getCardIdentifier(), ai.getCurrentBid() + "", VerificationUtil.convertSecondsToTimeString(ai
			.getExpires()));
	if (!AutobuyerPanel.this.biddedModels.contains(model)) {
	    AutobuyerPanel.this.watchListLable.setText("Watch list: (" + size + ")");
	    AutobuyerPanel.this.biddedModels.add(model);

	    AutobuyerPanel.this.refreshWatchList();
	}
    }

    public void refreshUIWatchList() {
	AutobuyerPanel.this.refreshWatchList();
    }*/

}
