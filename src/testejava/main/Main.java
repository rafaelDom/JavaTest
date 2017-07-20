package testejava.main;



import testejava.dao.ClienteDAO;


public class Main {

	public static void main(String[] args) {
		ClienteDAO clientaDAO = new ClienteDAO();

		// imprimir média
		System.out.println("A média final é:" + clientaDAO.mediaFinal());

		// imprimir clientes
		System.out.println("ID     " + "Nome:       " + "Saldo:");
		for (int i = 0; i < clientaDAO.imprimirClientes().size(); i++) {
			System.out.println(clientaDAO.imprimirClientes().get(i)
					.getId_customer()
					+ " | "
					+ clientaDAO.imprimirClientes().get(i).getNm_customer()
					+ " | "
					+ clientaDAO.imprimirClientes().get(i).getVl_total());
		}

		// o restante dos dados foram inseridos direto no banco de dados
		// exemplo do script
		// insert into tb_customer_account (id_customer, cpf_cnpj, nm_customer,
		// is_active, vl_total) values (1410, '113.234.345/0001-00', 'Cliente
		// 2', 0, 510);
	}

}
