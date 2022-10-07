package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe implementa uma estrat�gia de busca cega conhecida como "Busca em
 * Profundidade", que � caracter�stica por explorar o espa�o se aprofundando no
 * ramo atual antes de faz�-lo noutra ramifica��o.
 * 
 * @author Leandro C. Fernandes
 *
 */
public class BuscaEmProfundidadeIterativa extends BuscaEmProfundidade {
	
	private int limite;

	/**
	 * Construtor padr�o.
	 */
	public BuscaEmProfundidadeIterativa() {
		this(null,null,10);
	}
	
	/**
	 * Cria uma nova inst�ncia de Busca em Profundidade, definindo os estados
	 * inicial e objetivo para o processo, al�m do limite de aprofundamento.
	 * @param estadoInicial estado inicial de busca.
	 * @param estadoMeta estado que cont�m os objetivos da busca.
	 * @param nivelLimite n�vel m�ximo de aprofundamento da �rvore.
	 */
	public BuscaEmProfundidadeIterativa(Estado<?> estadoInicial, Estado<?> estadoMeta, int nivelLimite) {
		super(estadoInicial,estadoMeta);
		super.nomeDaEstrategia = "Busca em Profundidade Limitada (at� " + limite + " n�veis)";
		this.limite = nivelLimite;
	}
	
	/**
	 * Retorna o n�vel m�ximo de aprofundamento definido para o processo de busca.
	 * @param limite n�vel m�ximo de aprofundamento da �rvore.
	 */
	public int getLimite() {
		return limite;
	}

	/**
	 * Define o n�vel m�ximo de aprofundamento que um ramo ser� explorado.
	 * @param limite n�vel m�ximo de aprofundamento da �rvore.
	 */
	public void setLimite(int limite) {
		this.limite = limite;
	}

	/**
	 * Implementa efetivamente a estrat�gia de busca, iniciando a explora��o do
	 * espa�o a partir do estado inicial e seguindo n�vel a n�vel no ramo atual
	 * at� alcan�ar um estado que atenda os objetivos ou n�o tenha sucessor.
	 * Ao t�rmino, o caminho correspondente a solu��o ter� sido armazenado no
	 * atributo caminho.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {   
                    if(eCorrente != eObjetivo){
                        for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
                            //System.out.println(eAbertos.push(estado));
                            System.out.println(eObjetivo);
                            //System.out.println(eCorrente.getSucessores());
                            //System.out.println(eCorrente.getAncestral());
                            //Collections.reverse(caminho);
                            if(eCorrente == eObjetivo){
                                break;
                            }
                    if(eCorrente == eObjetivo){
                        System.out.println("Chegou ao fim");
                        //System.out.println(eCorrente.getNivel());
                    }
			eCorrente = eAbertos.pop();}
		}
		// Se o la�o foi encerrado por um estado v�lido ...
		if (eCorrente != null) {
			// ent�o constru�mos o caminho da solu��o (da folha at� a raiz)
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}
                
                
                
                
	}
	
}
