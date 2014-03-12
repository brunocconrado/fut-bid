package br.com.futbid.service;

import br.com.futbid.service.listener.AutoBuyerListener;

public interface AutoBuyerService {

    void addListener(AutoBuyerListener listener);
    
    boolean isWork();
    
    void stop();

    void start();
}
