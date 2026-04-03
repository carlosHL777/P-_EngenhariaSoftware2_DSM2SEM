package engsoftdsm;

public class Sabor {
    private final String nome;
    private int doses;
    private final double preco;

    public Sabor(String nome, int doses, double preco) {
        this.nome = nome;
        this.doses = doses;
        this.preco = preco;
    }
    
    public String getStatusLuz() {
        if (doses == 0) return "Luz Vermelha - Sabor fora de estoque, por favor escolha outro.";
        if (doses <= 2) return "Luz Amarela - Estoque próximo do fim";
        return "Luz Verde - Sabor disponível";
    }
    
    public void usarDose() {
        if (this.doses > 0) {
            this.doses--;
        }
    }
    
    public double getPreco() { return preco; }
    
    public String getNome() {
        return nome;
    }

    public int getDoses() {
        return doses;
    }
}
