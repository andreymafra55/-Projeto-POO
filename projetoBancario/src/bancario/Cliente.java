package bancario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cpf;
	String nome;
	
	private ArrayList<Conta> contas = new ArrayList<>();
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public void adicionarConta(Conta c) {
		if(contas.contains(c))
			System.out.println("Conta já cadastrada");
		else
			contas.add(c);
	}
	
	public void removerConta(Conta c) {
		if(contas.contains(c)) {
			contas.remove(c);
		}
		else
			System.out.println("Conta não cadastrada para este cliente");
	}
	
	public void atualizarConta(Conta c) {
		if(contas.contains(c)) {
			int index = contas.indexOf(c);
			contas.set(index,c);
		}
		else {
			System.out.println("Conta nao cadastrada");
		}
	}
	

	public void verSaldo(Conta c) {
		if (contas.contains(c)) {
			System.out.println(c.saldo()); 
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas + "]";
	}
	

	public ArrayList<Conta> getContas() {
		return contas;
	}
	
	public Conta buscarConta(Conta c) {
		if(contas.contains(c)) {
			int index = contas.indexOf(c);
			return contas.get(index);
		}
		else
			return null;
	}
}