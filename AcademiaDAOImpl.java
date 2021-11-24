package academia.consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcademiaDAOImpl implements AcademiaDAO {
    private static final String URL = "jdbc:mariadb://localhost:3306/academiadb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSW = "123456";

    public AcademiaDAOImpl() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSW);
    }


    @Override
    public void adicionar(Academia a) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO consulta (cod, nome) VALUES (?, ?)";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, a.getCod());
            stmt.setString(2, a.getNome());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Academia> pesquisarPorNome(String nome) {
        List<Academia> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            String sql = "SELECT * FROM consulta WHERE nome like ?";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Academia c = new Academia();
                c.setNome(rs.getString("nome"));
                c.setCod(rs.getInt("cod"));
                list.add(c);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void remover(int cod) {
        try {
            Connection con = getConnection();
            String sql = "DELETE FROM consulta WHERE cod = ?";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(int cod, Academia a) {
        try {
            Connection c = getConnection();
            String sql = "UPDATE consulta SET nome = ? WHERE cod = ?";

            System.out.println(sql);

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(2, a.getCod());
            ps.setString(1, a.getNome());
            ps.executeUpdate();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
