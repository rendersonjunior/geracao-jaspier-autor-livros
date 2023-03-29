package org.report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.report.domain.Autor;
import org.report.domain.Livro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Para geração de .pdf
        String outputFile = "src/main/resources/saida_relatorio" + File.separatorChar + "JasperTableExample.pdf";

        // Dados para o teste de report
        // Autor 1
        Autor autor1 = new Autor();
        autor1.setDataNasc(new Date());
        autor1.setNacionalidade("Brasileiro");
        autor1.setNome("Judas Arlindo");

        List livros = new ArrayList();

        Livro livro1 = new Livro();
        livro1.setAno(2009);
        livro1.setTitulo("Idade da Pedra");
        livro1.setEditora("Cultura");
        livro1.setValor(100.00);

        Livro livro2 = new Livro();
        livro2.setAno(2009);
        livro2.setTitulo("A Selva");
        livro2.setEditora("Cultura");
        livro2.setValor(150.00);

        livros.add(livro1);
        livros.add(livro2);

        autor1.setLivros(livros);

        // Autor 2
        Autor autor2 = new Autor();
        autor2.setDataNasc(new Date());
        autor2.setNacionalidade("Brasileiro");
        autor2.setNome("João Matias");

        List livros2 = new ArrayList();

        Livro livro3 = new Livro();
        livro3.setAno(2007);
        livro3.setTitulo("Idade da Pedra");
        livro3.setEditora("Cultura");
        livro3.setValor(50.00);

        Livro livro4 = new Livro();
        livro4.setAno(2008);
        livro4.setTitulo("Corredeira");
        livro4.setEditora("Cultura");
        livro4.setValor(80.00);

        livros2.add(livro1);
        livros2.add(livro2);
        livros2.add(livro3);
        livros2.add(livro4);

        autor2.setLivros(livros2);

        List listaAutores = new ArrayList();

        listaAutores.add(autor2);
        listaAutores.add(autor1);

        JasperPrint print = null;
        try {
            // Exemplo para passar parametros para o .jasper
            HashMap param = new HashMap();
            param.put("pTotalAutores", listaAutores.size());

            print = JasperFillManager.fillReport("src/main/resources/relatorio/exemplo_tabela.jasper", param, new JRBeanCollectionDataSource(listaAutores));

            // Criação de PDF
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            JasperExportManager.exportReportToPdfStream(print, outputStream);
            System.out.println("Arquivo .pdf gerado.");

        } catch (JRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        JasperViewer.viewReport(print);

    }
}