package br.com.futbid.domain.exception;

import static br.com.futbid.commons.util.StringUtils.isEmpty;
import static br.com.futbid.commons.util.StringUtils.parseArgsToArray;
import static br.com.futbid.commons.util.StringUtils.parseArgsToString;

/**
 * A mensagem deste tipo de exceção é exibida ao usuário, portanto não deve conter informações técnicas.
 */
public class LocalizedException extends RuntimeException {

    private static final long serialVersionUID = 2013080906L;

    public static final String GENERIC_ERROR = "service.unexpected.error";

    private final String args;

    /**
     * @param e
     *            Opcional, a causa da exceção
     * @param message
     *            A chave i18n da mensagem a ser exibida ao usuário em decorrência desta exceção
     * @param args
     *            Opcional, parâmetros da chave de internacionalização
     */
    public LocalizedException(Throwable e, String message, Object... args) {
        super(isEmpty(message) ? GENERIC_ERROR : message, e);
        this.args = parseArgsToString(args);
    }

    @Override
    public String getLocalizedMessage() {
        // TODO apesar do nome, esse metodo devolve somente a chave do cod. de erro
        return super.getMessage();
    }

    public Object[] getLocalizedArgs() {
        return parseArgsToArray(args);
    }

    @Override
    public String toString() {
        return super.toString() + "[" + args + "]";
    }

}
