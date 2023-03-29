package org.report.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    private String titulo;
    private int ano;
    private String editora;
    private Double valor;
    private Double totalizadorValor;
}
