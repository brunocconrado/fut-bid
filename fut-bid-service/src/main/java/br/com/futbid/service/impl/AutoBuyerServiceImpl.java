package br.com.futbid.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import br.com.futbid.service.AutoBuyerService;
import br.com.futbid.service.listener.AutoBuyerListener;
import br.com.futbid.service.thread.SearchThread;

public class AutoBuyerServiceImpl implements AutoBuyerService {

    private boolean isRunninng;

    private List<Thread> threads = new CopyOnWriteArrayList<Thread>();

    public AutoBuyerServiceImpl() {
	threads.add(new SearchThread());
    }
    
    public void addListener(AutoBuyerListener listener) {
	//TODO
    }

    public boolean isWork() {
	return isRunninng;
    }

    public void stop() {
	for (Thread thread : threads) {
	    try {
		thread.interrupt();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	isRunninng = false;
    }

    public void start() {
	for (Thread thread : threads) {
	    thread.start();
	}
	isRunninng = true;
    }

}
