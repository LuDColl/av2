package classes.dao;

import java.sql.PreparedStatement;

import classes.factory.Factory;

public class RunDao {
    private PreparedStatement pstm;
    private RunSql runSql;

    public RunDao(String sql){
        super();
    }

    public void runSql(String option) {
        try {
            pstm = (PreparedStatement) new Factory().createConnectionToMySQL().prepareStatement(sql);
            switch (option) {
                case "setAluno":
                    runSql = new RunSql(pstm).inAluno(aluno);
                    
                    break;
                case "setTelefone":
                    runSetTelefone();
                    break;
                case "upAluno":
                    runUpAluno();
                    break;
                case "upTelefone":
                    runUpTelefone();
                    break;
                case "delAluno":
                    runDelAluno();
                    break;
                case "delTelefone":
                    runDelAluno();
                    break;
                case "getAlunos":
                    runGetAlunos();
                    break;
                case "getTelefones":
                    runGetTelefone();
                    break;
                case "getLastId":
                    runGetLastId();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
