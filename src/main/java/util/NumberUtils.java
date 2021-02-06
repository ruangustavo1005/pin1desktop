package util;

/**
 * Classe de funções (in)úteis para trabalhar com números
 * @author Ruan
 */
public class NumberUtils {
    
    public static int parseInt(String s) {
        String replace = s.trim();
        return replace.equals("") ? 0 : Integer.parseInt(replace);
    }
    
    public static float parseFloat(String s) {
        String replace = s.replace(".", "").replace(",", ".").trim();
        return (float) (replace.equals("") ? 0.0 : Float.parseFloat(replace));
    }
    
    public static String formataValor(float valor) {
        return formataValor(valor, 2);
    }
    
    public static String formataValor(float valor, int decimais) {
        return formataValor(valor, decimais, false);
    }
    
    public static String formataValor(float valor, int decimais, boolean withPontos) {
        String retorno = String.valueOf(((int) (valor * (Math.pow(10, decimais)))) / (Math.pow(10, decimais))).replace(".", ",");
        if (withPontos) {
            String parteInteira = retorno.substring(0, retorno.indexOf(","));
            if (parteInteira.length() > 3) {
                parteInteira = parteInteira.substring(0, parteInteira.length() - 3) + "." + parteInteira.substring(parteInteira.length() - 3);
                int posicaoPonto = parteInteira.indexOf(".");
                while (posicaoPonto > 3) {
                    parteInteira = parteInteira.substring(0, posicaoPonto - 3) + "." + parteInteira.substring(posicaoPonto - 3);
                    posicaoPonto = parteInteira.indexOf(".");
                }
            }
            retorno = parteInteira + retorno.substring(retorno.indexOf(","));
        }
        return retorno;
    }
    
}