package math;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author yh128
 * @version 1.0.0
 * @ClassName Jdbcs.java
 * @Description ���ݿ�������
 * @Param
 * @createTime 2019��06��11�� 11:28:00
 */
 
import javax.swing.JOptionPane;
 
public class Jdbcs_1 {
	
    private int id;//ѧ��
    private String EN;//����
    private String ZH;//�༶
    Connection con = null;
    Statement statement = null;
    ResultSet res = null;
    ResultSet en = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://118.25.47.230:3306/english?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    String name = "root";
    String passwd = "123456";
    public String getEN() {
        return EN;
    }
 
    public void setStuName(String EN) {
        this.EN = EN;
    }
 
    public Jdbcs_1() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, name, passwd);
            statement = con.createStatement();
 
        } catch (ClassNotFoundException e) {
            System.out.println("�Բ����Ҳ������Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Jdbcs_1 chou(int id) {
    	Jdbcs_1 timu = new Jdbcs_1();
        String sql = "select EN from english where id=\"" + id + "\"";
        try {
        	res = statement.executeQuery(sql);
        	ResultSet res = statement.executeQuery(sql);
            while(res.next()) {
            	timu.EN = res.getString("EN");
            	
            }
            return timu;
    }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
 
        }
 
 
}
    public boolean compare(String answer,String en) {
        boolean m = false;
        String sql = "select ZH from english where EN=\"" + en + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + answer);
                if (pa.equals(answer)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "�𰸴���");
                }
            } else {
                JOptionPane.showMessageDialog(null, "�û��������ڣ�");
            }
            res.close();
            con.close();
            statement.close();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
}
