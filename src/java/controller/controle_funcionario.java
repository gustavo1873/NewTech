/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.FuncionarioDAO;
import model.Funcionario;

/**
 *
 * @author Gustavo-PC
 */
@WebServlet(name = "controle_funcionario", urlPatterns = {"/controle_funcionario"})
public class controle_funcionario extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            

            String op = request.getParameter("op");
            FuncionarioDAO funcdao = new FuncionarioDAO();
            Funcionario f = new Funcionario();

            if (op.equals("CADASTRAR")) {
                String nome = request.getParameter("txtnome");
                String email = request.getParameter("txtemail");
                String telefone = request.getParameter("txttelefone");
                String cargo = request.getParameter("txtcargo");
                String endereco = request.getParameter("txtendereco");
                String cpf = request.getParameter("txtcpf");
                String cnpj = request.getParameter("txtcnpj");
                String dt_admissao = request.getParameter("txtdt_admissao");
                String dt_nascimento = request.getParameter("txtdt_nascimento");
                double salario = Double.parseDouble(request.getParameter("txtsalario"));
                f.setNome(nome);
                f.setEmail(email);
                f.setTelefone(telefone);
                f.setCargo(cargo);
                f.setEndereco(endereco);
                f.setCpf(cpf);
                f.setCnpj(cnpj);
                f.setDt_admissao(dt_admissao);
                f.setDt_nascimento(dt_nascimento);
                f.setSalario(salario);
                String msg = "Cadastrar";
                //Atentar-se ao nome das jsp como resultado.jsp e erro.jsp. Alterar o nome se preciso
                try {
                    funcdao.cadastrar(f);
                    System.out.println("Cadastrado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);

                }
            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                f.setId(id);
                String msg = "Deletar";
                try {
                    funcdao.deletar(f);
                    List<Funcionario> listfunc = funcdao.consultarTodos();
                    request.setAttribute("lprod", listfunc);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else if (op.equals("CONSULTAR POR ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                f.setId(id);
                try {
                    f = funcdao.consultarById(f);
                    request.setAttribute("f", f);
                    request.getRequestDispatcher("resultadocosultarporid.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
               int id = Integer.parseInt(request.getParameter("txtid"));
               f.setId(id);
                try {
                    List<Funcionario> listfunc = funcdao.consultarTodos();
                    request.setAttribute("listfunc", listfunc);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

            } else if (op.equals("ATUALIZAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                f.setId(id);
                try {
                    f = funcdao.consultarById(f);
                    request.setAttribute("f", f);
                    request.getRequestDispatcher("resultadoatualizar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (op.equals("EFETIVAR ATUALIZAÇÃO")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                String email = request.getParameter("txtemail");
                String cargo = request.getParameter("txtcargo");
                String telefone = request.getParameter("txttelefone");
                String endereco = request.getParameter("txtendereco");
                String dt_nascimento = request.getParameter("txtdt_nascimento");
                double salario = Double.parseDouble(request.getParameter("txtsalario"));
                f.setId(id);
                f.setEmail(email);
                f.setCargo(cargo);
                f.setTelefone(telefone);
                f.setEndereco(endereco);
                f.setTelefone(dt_nascimento);
                f.setSalario(salario);
                String msg = "Atualizar";
                try {
                    funcdao.atualizar(f);
                    System.out.println("Atualizado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            }

        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
