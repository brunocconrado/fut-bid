package br.com.futbid.swing.ui.panel.auth;

import java.awt.Component;

import br.com.futbid.swing.ui.panel.tab.WorkTabPanel;


public interface AuthenticationPainel {

   boolean login();
   
   Component getParent();
   
   void showAutoBuyerPanel();
   
   void clearFields();
   
   void setName(String name);
   
   void setWorkPanel(WorkTabPanel workTabPanel);
}
