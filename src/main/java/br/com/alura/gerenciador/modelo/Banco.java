package br.com.alura.gerenciador.modelo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

    private static final List<Empresa> lista = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(Banco.chaveSequencial++);
        empresa.setNome("Alura");
        lista.add(empresa);
        Empresa empresa2 = new Empresa();
        empresa2.setId(Banco.chaveSequencial++);
        empresa2.setNome("Caelum");
        lista.add(empresa2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.lista.add(empresa);
    }

    public void altera(Integer id, String nome, Date dataAbertura) {
        Empresa empresa = buscaEmpresaById(id);
        empresa.setNome(nome);
        empresa.setDataAbertura(dataAbertura);
    }

    public void removeEmpresa(Integer id) {
        lista.removeIf(empresa -> empresa.getId() == id);
    }

    public List<Empresa> getEmpresas() {
        return Banco.lista;
    }

    public Empresa buscaEmpresaById(Integer id) {

        for (Empresa empresa : lista) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }
}
