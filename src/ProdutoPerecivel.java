public class ProdutoPerecivel extends Produto{

    private double DESCONTO = 0.25;
    private int PRAZO_DESCONTO = 7;
    private LocalDate dataDeValidade;

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataDeValidade){
        super(desc, precoCusto, margemLucro);
        this.dataDeValidade = dataDeValidade;
    }

    @Override
    public double valorDeVenda(){
        LocalDate hoje = LocalDate.now();
        LocalDate tempo_desconto = dataDeValidade.minusDays(PRAZO_DESCONTO);
        if(hoje.isBefore(dataDeValidade) && hoje.isAfter(tempo_desconto)){
            return ((precoCusto * (1.0 + margemLucro))*(1-DESCONTO));
        }else{
            return (precoCusto * (1.0 + margemLucro));
        }
    }

    @Override
	public String toString() {
    	
    	NumberFormat moeda = NumberFormat.getCurrencyInstance();
    	
		return String.format("NOME: " + descricao + ": " + moeda.format(valorDeVenda()));
	}
}