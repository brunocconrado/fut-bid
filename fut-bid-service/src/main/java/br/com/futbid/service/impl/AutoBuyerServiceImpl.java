package br.com.futbid.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.futbid.service.AutoBuyerService;
import br.com.futbid.service.listener.AutoBuyerListener;
import br.com.futbid.service.thread.SearchThread;

@Service
public class AutoBuyerServiceImpl implements AutoBuyerService {
    
    private static final Logger LOG = LoggerFactory.getLogger(AutoBuyerServiceImpl.class);

    private boolean isRunninng;

    private List<Thread> threads = new CopyOnWriteArrayList<Thread>();

    public AutoBuyerServiceImpl() {
	threads.add(new SearchThread());
    }
    
    public void addListener(AutoBuyerListener listener) {
	//TODO add listeners para informar status na tela
    }

    public boolean isWork() {
	return isRunninng;
    }

    public void stop() {
	for (Thread thread : threads) {
	    try {
		LOG.info("stopping thread {}", thread);
		thread.interrupt();
	    } catch (Exception e) {
		LOG.error("An unexpected error has ocurred trying stopping thread {}", e);
	    }
	}

	isRunninng = false;
    }

    public void start() {
	for (Thread thread : threads) {
	    LOG.info("Start thread {}", thread);
	    thread.start();
	}
	isRunninng = true;
    }

}
