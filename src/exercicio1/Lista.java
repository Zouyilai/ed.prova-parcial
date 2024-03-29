package exercicio1;

public class Lista {
	No inicio, fim;
	
	// insere um n� no final da lista. Esse m�todo ser� chamado pelo m�todo inserir
	private void inserirFim(No aux) {
		if(inicio == null) {
			inicio = aux;
		} else {
			fim.prox = aux;
		}
		fim = aux;
	}
	
	//esse m�todo dever� ser implementado de acordo com o enunciado do exerc�cio
	private void inserirPrioridade(No aux) {
		No posicao = inicio;
		
		if(inicio == null) { //sem elemento
			inicio = aux;
			fim = aux;
		} else if(inicio.cor.equalsIgnoreCase("verde")) { //com verde
			aux.prox = inicio;
			inicio = aux;
		} else if(fim.cor.equalsIgnoreCase("verde") && inicio.cor.equalsIgnoreCase("amarelo")) { //com verde e amarelo
			while(posicao != null){
				if(posicao.cor.equalsIgnoreCase("amarelo")&&posicao.prox.cor.equalsIgnoreCase("verde")){
					break;
				} else {
					posicao = posicao.prox;
				}
			}
			aux.prox = posicao.prox;
			posicao.prox = aux;
		} else {
			inserirFim(aux);
		}
	}
	
	// m�todo inserir. Esse m�todo ser� chamado a partir da classe Main
	public void inserir(int numero, String cor) {
		No aux = new No(numero, cor);
		if(cor.equalsIgnoreCase("verde")) {
			inserirFim(aux);
		} else {
			inserirPrioridade(aux);
		}
	}
	
	// m�todo utilizado para imprimir os dados da lista
	public void imprimir() {
		No aux = inicio;
		while(aux != null) {
			System.out.println(aux.numero);
			aux = aux.prox;
		}
	}
}
