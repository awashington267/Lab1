import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    private final String PATH = "/WEB-INF/lib/spongebob";
    private final String USER = "tony";
    private final String PW = "tony";
    private final String DRIVER = "jdbc:derby:";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //The list is the 4 buttons in the Index.html
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;

        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String path = getServletContext().getRealPath(PATH);
            conn = DriverManager.getConnection(DRIVER + path, USER, PW);
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT char_ID, char_nm FROM Characters");

            StringBuilder html = new StringBuilder("<html><body>");
            while (rset.next()){
                int id = rset.getInt("char_ID");
                String nm = rset.getString(2);
                html.append("<li>").append(id).append(",").append(nm).append("</li>");
            }
            html.append("</body></html>");
            response.getWriter().print(html.toString());
        }catch(ClassNotFoundException | SQLException ex){
            response.getWriter().print(ex.getMessage());
            ex.printStackTrace();

        }finally {
            try{
                if(rset !=null){
                    rset.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if(conn !=null){
                    conn.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if(stmt !=null){
                    stmt.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}
