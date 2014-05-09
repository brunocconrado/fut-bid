package br.com.futbid.commons.util;

public interface SpringConfig<T> {
    
    /**
     * @PostContruct
     */
    void init();
    
    /**
     * @PreDestroy
     */
    void destroy();    

}
