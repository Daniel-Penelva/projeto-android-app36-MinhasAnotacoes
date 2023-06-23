package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotação.preferencias";
    private final String CHAVE_NOME = "nome";

    public AnotacaoPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao(){

        return preferences.getString(CHAVE_NOME, "");
    }
}

/**
 * Esse script é uma classe chamada "AnotacaoPreferencias" que lida com o armazenamento e recuperação de uma anotação
 * usando o SharedPreferences no Android. Vou explicar as principais partes do código:
 *
 * 1. Declaração das variáveis:
 *    - `Context context`: É uma referência ao contexto da aplicação Android.
 *    - `SharedPreferences preferences`: É usado para acessar as preferências compartilhadas.
 *    - `SharedPreferences.Editor editor`: É usado para editar as preferências compartilhadas.
 *
 * 2. Constantes:
 *    - `NOME_ARQUIVO`: É o nome do arquivo que será usado para armazenar as preferências compartilhadas.
 *    - `CHAVE_NOME`: É a chave que será usada para armazenar e recuperar a anotação no arquivo de preferências.
 *
 * 3. Construtor:
 *    - `AnotacaoPreferencias(Context c)`: O construtor da classe recebe um objeto `Context` como parâmetro e
 *       inicializa as variáveis `context`, `preferences` e `editor`. Ele obtém as preferências compartilhadas
 *       associadas ao arquivo "anotação.preferencias" usando o método `getSharedPreferences()`. Em seguida, obtém
 *       um editor para editar as preferências compartilhadas usando o método `edit()`.
 *
 * 4. Método `salvarAnotacao(String anotacao)`:
 *    - Esse método recebe uma string `anotacao` como parâmetro.
 *    - Ele utiliza o editor para armazenar a anotação no arquivo de preferências compartilhadas. O método `putString()`
 *      é usado para inserir a anotação no editor, usando a chave `CHAVE_NOME`.
 *    - Por fim, o método `commit()` é chamado para confirmar as alterações e salvar a anotação no arquivo de
 *      preferências compartilhadas.
 *
 * 5. Método `recuperarAnotacao()`:
 *    - Esse método retorna uma string.
 *    - O objetivo desse método é recuperar a anotação armazenada nas preferências compartilhadas.
 *
 *    Aqui está a explicação detalhada do método:
 *
 *    - preferences.getString(CHAVE_NOME, ""): Esse código utiliza o objeto preferences, que é uma instância da classe
 *      SharedPreferences, para acessar as preferências compartilhadas. O método getString() é chamado para obter o
 *      valor associado à chave CHAVE_NOME no arquivo de preferências.
 *
 *    - CHAVE_NOME é uma constante declarada anteriormente na classe, que representa a chave usada para armazenar e
 *      recuperar a anotação.
 *
 *    - O segundo parâmetro "" é um valor padrão a ser retornado caso não haja um valor associado à chave CHAVE_NOME.
 *      Nesse caso, se não houver uma anotação armazenada, será retornado uma string vazia.
 *
 *    - return: O valor retornado pelo método é o resultado da chamada de preferences.getString(), que pode ser a
 *      anotação recuperada ou uma string vazia.
 *
 *    - Em resumo, o método recuperarAnotacao() retorna a anotação armazenada nas preferências compartilhadas, ou uma
 *      string vazia se não houver uma anotação previamente armazenada.
 *
 * Em resumo, essa classe fornece os métodos para salvar e recuperar uma anotação usando o SharedPreferences no
 * Android.
 * */