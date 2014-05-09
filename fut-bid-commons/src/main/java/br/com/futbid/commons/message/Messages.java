package br.com.futbid.commons.message;

public interface Messages {

    /**
     * @return O valor da chave de i18n. Se não houver valor, devolve a chave sem i18n.
     */
    String getMessage(String key, Object... params);

}
