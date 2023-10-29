package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import util.Conexao;


public class FuncionarioDAO {

    public void cadastrar(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into Funcionario (id, nome, email, cargo, telefone, endereco, salario, cpf, cnpj, dt_admissao, dt_nascimento) values (?,?,?,?,?,?,?,?,?,?,?)");
        comando.setDouble(1, f.getId());
        comando.setString(2, f.getNome());
        comando.setString(3, f.getEmail());
        comando.setString(4, f.getCargo());
        comando.setString(5, f.getTelefone());
        comando.setString(6, f.getEndereco());
        comando.setDouble(7, f.getSalario());
        comando.setString(8, f.getCpf());
        comando.setString(9, f.getCnpj());
        comando.setString(10, f.getDt_admissao());
        comando.setString(11, f.getDt_nascimento());
        comando.execute();
        con.close();
    }
    
    public void deletar(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from Funcionario where id = ?");
        comando.setInt(1, f.getId());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update Funcionario set email = ?, cargo = ?, telefone = ?, endereco = ?, salario = ?, dt_nascimento = ? where id = ?");
        comando.setString(1, f.getEmail());
        comando.setString(2, f.getCargo());
        comando.setString(3, f.getTelefone());
        comando.setString(4, f.getEndereco());
        comando.setDouble(5, f.getSalario());
        comando.setString(6, f.getDt_nascimento());
        comando.setInt(7, f.getId());
        comando.execute();
        con.close();
    }

    public Funcionario consultarById(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from Funcionario where id = ?");
        comando.setInt(1, f.getId());
        ResultSet rs = comando.executeQuery();
        Funcionario func = new Funcionario();
        if (rs.next()){
            func.setId(rs.getInt("id"));
            func.setNome(rs.getString("nome"));
            func.setCargo(rs.getString("cargo"));
            func.setDt_nascimento(rs.getString("dt_nascimento"));
            func.setEmail(rs.getString("email"));
            func.setSalario(rs.getDouble("salario"));
        }        
        return func;
    }
    
    
    public List<Funcionario> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from Funcionario");
        ResultSet rs = comando.executeQuery();
        
        List<Funcionario> list_func = new ArrayList<Funcionario>();
        while(rs.next()){
            Funcionario func = new Funcionario();
            func.setId(rs.getInt("id"));
            func.setNome(rs.getString("nome"));
            func.setCargo(rs.getString("cargo"));
            func.setSalario(rs.getDouble("salario"));
            func.setEndereco(rs.getString("endereco"));
            func.setDt_admissao(rs.getString("dt_admissao"));
            func.setDt_nascimento(rs.getString("dt_nascimento"));
            
            list_func.add(func);
        }        
        return list_func;
    }
}