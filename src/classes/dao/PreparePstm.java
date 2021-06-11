package classes.dao;

import java.sql.PreparedStatement;

import classes.factory.Conection;

public class PreparePstm {
    private PreparedStatement pstm;
    private String sql;

    public PreparePstm(String sql){
        super();
        this.sql = sql;
    }

    public PreparedStatement getPstm() {
        try {
            return (PreparedStatement) new Conection().createConnectionToMySQL().prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return pstm = null;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
