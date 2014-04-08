package br.com.futbid.service.thread;

import org.springframework.stereotype.Component;

import br.com.futbid.domain.ActionResponse;
import br.com.futbid.service.SearchService;
import br.com.futbid.service.impl.SearchServiceImpl;

@Component
public class SearchThread extends Thread {

    private SearchService searchService = new SearchServiceImpl();

    @Override
    public void run() {
	ActionResponse response = searchService.search();
	
	run();
    }
    
}
