public class ItemDePedido {

    // Atributos encapsulados
    private Produto produto;
    private int quantidade;
    private double precoVenda;

    public double getPrecoVenda(){ return precoVenda; }
    public int getQuantidade(){ return quantidade; }
    public Produto getProduto(){ return produto; }
    public void setQuantidade(int novaQuantidade){
        quantidade = novaQuantidade;
    }

    public void setPrecoVenda(double novoPrecoVenda){
        precoVenda = novoPrecoVenda;
    }
    /**
     * Construtor da classe ItemDePedido.
     * O precoVenda deve ser capturado do produto no momento da criação do item,
     * garantindo que alterações futuras no preço do produto não afetem este pedido.
     */
    public ItemDePedido(Produto produto, int quantidade, double precoVenda) {
        precoVenda = produto.valorDeVenda();
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        subtotal = quantidade*precoVenda;

        if(quantidade >= 10){
            return subtotal*(1-0.05);
        }

        return subtotal;
    }


    // --- Sobrescrita do método equals ---

    /**
     * Compara a igualdade entre dois itens de pedido.
     * A regra de negócio define que dois itens são iguais se possuírem o mesmo Produto.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        ItemDePedido outro = (ItemDePedido) obj;

        return outro.produto.equals(this.produto);
    }
}
