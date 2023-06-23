package com.example.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Salvar a anotação
                // Validar se foi digitado algo
                String textoRecuperado = editAnotacao.getText().toString();
                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();

                }else{
                    preferencias.salvarAnotacao(textoRecuperado);

                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        // Recuperar a anotação
       String anotacao =  preferencias.recuperarAnotacao();

       // Testar se a anotação está preenchida
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);

        }
    }
}

/**
 * 1. Herança e método `onCreate()`:
 *    - `public class MainActivity extends AppCompatActivity`: A classe MainActivity estende a classe AppCompatActivity,
 *       que é uma classe base para atividades no Android.
 *    - `protected void onCreate(Bundle savedInstanceState)`: É o método chamado quando a atividade é criada. Aqui, é
 *       onde a inicialização e configuração da atividade são feitas.
 *
 * 2. Declaração de variáveis:
 *    - `private AnotacaoPreferencias preferencias`: É uma instância da classe AnotacaoPreferencias, que é usada para
 *       salvar a anotação.
 *    - `private EditText editAnotacao`: É um campo de texto onde o usuário pode digitar a anotação.
 *
 * 3. Método `onCreate()`:
 *    - `super.onCreate(savedInstanceState)`: Chama a implementação da classe base para realizar as inicializações
 *       padrão.
 *    - `setContentView(R.layout.activity_main)`: Define o layout da atividade para ser exibido na tela. Neste caso,
 *       o layout está definido em um arquivo XML chamado "activity_main".
 *
 * 4. Inicialização de variáveis:
 *    - `editAnotacao = findViewById(R.id.editAnotacao)`: Obtém a referência ao campo de texto de anotação no layout
 *       da atividade.
 *    - `preferencias = new AnotacaoPreferencias(getApplicationContext())`: Cria uma nova instância da classe
 *       AnotacaoPreferencias, passando o contexto do aplicativo como parâmetro. Isso permite que a atividade
 *       interaja com o objeto AnotacaoPreferencias para salvar a anotação.
 *
 * 5. Configuração do botão de ação:
 *    - `FloatingActionButton fab = findViewById(R.id.fab)`: Obtém a referência ao botão de ação no layout da atividade.
 *    - `fab.setOnClickListener(new View.OnClickListener() {...})`: Define um ouvinte de clique para o botão de ação.
 *       Quando o botão é clicado, o código dentro do bloco de código do método `onClick()` será executado.
 *
 * 6. Método `onClick()`:
 *    - `String textoRecuperado = editAnotacao.getText().toString()`: Obtém o texto digitado pelo usuário no campo de
 *       texto de anotação e converte-o para uma string.
 *    - Verifica se o texto recuperado é vazio. Se for vazio, exibe uma Snackbar informando que a anotação precisa ser
 *      preenchida.
 *    - Caso contrário, chama o método `salvarAnotacao()` do objeto `preferencias` para salvar a anotação no SharedPreferences.
 *    - Exibe uma Snackbar informando que a anotação foi salva com sucesso.
 *
 * 7 - Por fim foi implementado a recuperação da anotação armazenada nas preferências compartilhadas e em seguida é
 *     feita uma verificação para determinar se a anotação está preenchida. Aqui está a explicação passo a passo:
 *
 *    - String anotacao = preferencias.recuperarAnotacao(): O código chama o método recuperarAnotacao() do objeto
 *    preferencias, que é uma instância da classe AnotacaoPreferencias. Esse método retorna a anotação armazenada nas
 *    preferências compartilhadas (ou uma string vazia se não houver uma anotação). O valor retornado é atribuído à
 *    variável anotacao, que é uma string.
 *
 *    - if (!anotacao.equals("")): Nessa linha, é feita uma verificação para determinar se a anotacao está preenchida,
 *      ou seja, se contém algum texto. O operador ! é usado para negar a condição seguinte. O método equals() é usado
 *      para comparar se a string anotacao é diferente de uma string vazia "".
 *
 *    - editAnotacao.setText(anotacao): Se a condição no if for verdadeira, ou seja, se a anotação estiver preenchida,
 *      o código dentro do bloco do if será executado. Nesse caso, o método setText() é chamado no objeto editAnotacao,
 *      que é um campo de texto da interface do usuário. O valor da anotacao é definido como o texto exibido no campo
 *      de texto.
 *
 *    - Em resumo, esse trecho de código recupera a anotação armazenada nas preferências compartilhadas e, se estiver
 *      preenchida, exibe o valor da anotação em um campo de texto chamado editAnotacao. Isso permite que o usuário
 *      visualize a anotação anteriormente salva ao abrir a atividade.
 *
 * Em resumo, essa classe representa a atividade principal de um aplicativo Android, onde o usuário pode digitar uma
 * anotação em um campo de texto e salvá-la clicando em um botão de ação. A anotação é salva usando a classe
 * AnotacaoPreferencias, que lida com o armazenamento das preferências compartilhadas no dispositivo Android.
 * */