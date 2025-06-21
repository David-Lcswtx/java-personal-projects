public class Conta {
    private Cliente titular;
    private double saldo;
    private String numeroConta;

    public Conta(Cliente titular, double saldoInicial, String numeroConta) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.numeroConta = numeroConta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Conta " + this.numeroConta + ": Valor inválido para depósito.");
            return false;
        } else {
            this.saldo += valor;
            System.out.printf("Conta %s: Depósito de R$%.2f realizado. Novo saldo: R$%.2f%n", this.numeroConta, valor, this.saldo);
            return true;
        }
    }

    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Conta " + this.numeroConta + ": Saldo insuficiente.");
            return false;
        } else if (valor <= 0) {
            System.out.println("Conta " + this.numeroConta + ": Valor inválido para saque.");
            return false;
        } else {
            this.saldo -= valor;
            System.out.printf("Conta %s: Saque de R$%.2f realizado. Novo saldo: R$%.2f%n", this.numeroConta, valor, this.saldo);
            return true;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor <= 0) {
            System.out.println("Transferência da Conta " + this.numeroConta + ": Valor inválido para transferência.");
            return false;
        }
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.printf("Transferência de R$%.2f da conta %s para %s (Conta %s) realizada com sucesso.%n",
                    valor, this.numeroConta, destino.getTitular().getNome(), destino.getNumeroConta());
            return true;
        } else {
            System.out.println("A transferência da conta " + this.numeroConta + " não pode ser concluída (saldo insuficiente ou erro no saque).");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Conta [Número: " + numeroConta + ", Saldo: R$" + String.format("%.2f", saldo) +
                ", Titular: " + (titular != null ? titular.getNome() : "N/A") + "]";
    }
}
