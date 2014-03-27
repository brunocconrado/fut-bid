package br.com.futbid.service.thread;

import br.com.futbid.domain.ActionResponse;
import br.com.futbid.service.SearchService;
import br.com.futbid.service.impl.SearchServiceImpl;


public class SearchThread extends Thread {

    private SearchService searchService = new SearchServiceImpl();

    @Override
    public void run() {
	ActionResponse response = searchService.search();
	
	run();
    }
    
}
