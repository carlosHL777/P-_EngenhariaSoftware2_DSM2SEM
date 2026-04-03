package engsoftdsm;
import java.util.ArrayList;
import java.util.List;

public class MaquinaCafe {
    private final List<Sabor> sabores = new ArrayList<>();

    public MaquinaCafe() {
        sabores.add(new Sabor("Expresso", 10, 3.50));
        sabores.add(new Sabor("Capuccino", 5, 5.00));
        sabores.add(new Sabor("Macchiato", 2, 6.50)); 
        sabores.add(new Sabor("Mocha", 1, 7.00));      
        sabores.add(new Sabor("Latte", 0, 6.00));      
        sabores.add(new Sabor("Chocolate", 8, 4.50));
    }

    public void realizarVenda(int indiceSabor, MetodoPagamento pagamento, double saldoUsuario) {
    Sabor selecionado = sabores.get(indiceSabor);

        if (selecionado.getDoses() == 0) {
            System.out.println("[LUZ VERMELHA] Operação cancelada: O sabor " + selecionado.getNome() + " esgotou.");
            return; 
        }

        if (saldoUsuario < selecionado.getPreco()) {
            System.out.println("AVISO: Saldo insuficiente. O " + selecionado.getNome() + " custa R$ " + selecionado.getPreco());
            return; 
        }

        if (selecionado.getDoses() <= 2) {
            System.out.println("[LUZ AMARELA] Atenção: Poucas doses restantes de " + selecionado.getNome());
        }

        System.out.println("Iniciando transação para: " + selecionado.getNome());
        if (pagamento.processar(selecionado.getPreco())) {
            System.out.println("Pagamento aprovado! Preparando café...");
            selecionado.usarDose();
            System.out.println("Café entregue com sucesso.");
        } else {
            System.out.println("ERRO: Falha na comunicação com o banco.");
        }
        
    }
    public List<Sabor> getListaSabores() {
            return this.sabores;
        }
}

