package testejava.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import testejava.conexaosql.Conexao;
import testejava.modelo.Cliente;

public class ClienteDAO {
	Conexao conexao = new Conexao();

	public void inserir(Cliente cliente) {
		String sqlInsert = "insert into tb_customer_account(id_customer, cpf_cnpj, nm_customer, is_active, vl_total) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexao.conecta().prepareStatement(
					sqlInsert);
			stmt.setInt(1, cliente.getId_customer());
			stmt.setString(2, cliente.getCpf_cnpj());
			stmt.setString(3, cliente.getNm_customer());
			stmt.setBoolean(4, cliente.isIs_active());
			stmt.setFloat(5, cliente.getVl_total());
			stmt.execute();
			stmt.close();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	public String mediaFinal() {
		String mediaFinal = null;
		String sqlMedia = "SELECT AVG(vl_total) AS'MÉDIA' FROM tb_customer_account where vl_total>560 and id_customer >= 1500 and id_customer <= 2700";
		try {
			PreparedStatement stmt = conexao.conecta().prepareStatement(
					sqlMedia);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				mediaFinal = rs.getString(1).toString();
			}
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return mediaFinal;

	}

	public List<Cliente> imprimirClientes() {
		String sql = "SELECT id_customer, nm_customer, vl_total FROM tb_customer_account where vl_total>560 and id_customer >= 1500 and id_customer <= 2700  order by vl_total desc";
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement stmt = conexao.conecta().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_customer(rs.getInt("Id_customer"));
				cliente.setNm_customer(rs.getString("nm_customer"));
				cliente.setVl_total(rs.getFloat("vl_total"));

				lista.add(cliente);
			}
			stmt.close();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return lista;

	}
}
