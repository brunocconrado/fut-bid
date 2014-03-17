package br.com.futbid.swing.ui.panel.auth;

import java.awt.Component;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.swing.ui.panel.tab.WorkTabPanel;


public interface AuthenticationPainel {

   Component getParent();
   
   void showAutoBuyerPanel();
   
   void clearFields();
   
   void setName(String name);
   
   void setWorkPanel(WorkTabPanel workTabPanel);
   
   Credentials getCredentials();
}
