package engsoftdsm;

public class Cartao implements MetodoPagamento{
    
    @Override
    public boolean processar(double valor) {
        System.out.println("---Processando Pagamento---");
        return true; 
    }
}
