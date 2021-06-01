package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import classes.Aluno;
import classes.Telefone;
import factory.AlunoFactory;


public class AlunoDAO {

    public void save(Aluno aluno){
        
        String sql ="INSERT INTO aluno(nome,cidade,estado) VALUES(?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn= AlunoFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());


        pstm.execute();
        System.out.println("Executado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void savetelefone(Telefone telefone){
        
        String sql ="INSERT INTO telefone(idaluno,numero) VALUES(?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn= AlunoFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, telefone.getIdaluno());
            pstm.setString(2, telefone.getNumero());
            


        pstm.execute();
        System.out.println("Executado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
  
  
    public List<Aluno> getaluno() throws Exception{

        String sql ="SELECT * FROM aluno";

        List<Aluno> alunos = new ArrayList<Aluno>();

        Connection conn =null;
        PreparedStatement pstm = null;

        ResultSet rset = null;
        
        try{
            conn = AlunoFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Aluno aluno = new Aluno();
                

                aluno.setIdaluno(rset.getInt("idaluno"));

                aluno.setNome(rset.getString("nome"));

                aluno.setCidade(rset.getString("cidade"));

                aluno.setEstado(rset.getString("estado"));

                alunos.add(aluno);

            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return alunos;

    }



    public void update_aluno(Aluno aluno) throws Exception{

        String sql = "UPDATE aplicativo_java.aluno SET nome=? ,cidade =?, estado= ?"+" WHERE (idaluno = ?)";

        Connection conn=null;

        PreparedStatement pstm = null;

        try{
            conn = AlunoFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.setInt(4, aluno.getIdaluno());

            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
