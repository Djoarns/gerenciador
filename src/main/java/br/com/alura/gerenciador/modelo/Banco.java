package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

    private static final List<Empresa> empresas = new ArrayList<>();
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(Banco.chaveSequencial++);
        empresa.setNome("Alura");
        empresas.add(empresa);
        Empresa empresa2 = new Empresa();
        empresa2.setId(Banco.chaveSequencial++);
        empresa2.setNome("Caelum");
        empresas.add(empresa2);

        Usuario user1 = new Usuario();
        user1.setLogin("Djonatan");
        user1.setSenha("12345");
        usuarios.add(user1);
        Usuario user2 = new Usuario();
        user2.setLogin("Aline");
        user2.setSenha("12345");
        usuarios.add(user2);

    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.empresas.add(empresa);
    }

    public void altera(Integer id, String nome, Date dataAbertura) {
        Empresa empresa = buscaEmpresaById(id);
        empresa.setNome(nome);
        empresa.setDataAbertura(dataAbertura);
    }

    public void removeEmpresa(Integer id) {
        empresas.removeIf(empresa -> empresa.getId() == id);
    }

    public List<Empresa> getEmpresas() {
        return Banco.empresas;
    }

    public Empresa buscaEmpresaById(Integer id) {

        for (Empresa empresa : empresas) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }

    public Usuario getUserIfExists(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.isEqual(login, senha)) {
                return usuario;
            }
        }
        return null;
    }
}
