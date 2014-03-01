package br.com.futbid.swing.ui.settings;

public interface SettingsPanel {
    
    public String getName();
    
    public void setName(String name);
    
    public void save();
    
    public void updateFields();

}
