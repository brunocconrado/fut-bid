package br.com.futbid.integration;

import java.util.List;

import org.json.JSONObject;

import br.com.futbid.domain.search.Search;

public interface SearchIntegration {

    public List<JSONObject> search(Search search);

    public JSONObject search(Search search, int currentPage);

}
