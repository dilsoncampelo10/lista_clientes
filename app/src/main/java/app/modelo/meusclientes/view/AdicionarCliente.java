package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarCliente extends Fragment {

    View view;
    TextView txtTitulo;
    EditText editNome, editEmail, editTelefone, editCep, editLogradouro;
    EditText editNumero, editBairro, editCidade, editEstado;
    CheckBox chkTermos;
    Button btnCancelar, btnSalvar;
    Cliente cliente;
    ClienteController clienteController;

    public AdicionarCliente() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.adicionar_cliente, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.WHITE));

        iniciarLayout();

        getEventoBotoes();

        return view;
    }



    private void iniciarLayout() {
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.add_cliente);
        editNome = view.findViewById(R.id.editNome);
        editEmail = view.findViewById(R.id.editEmail);
        editTelefone = view.findViewById(R.id.editTelefone);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);
        chkTermos = view.findViewById(R.id.chkTermos);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        cliente = new Cliente();
        clienteController = new ClienteController(getContext());

    }

    private void getEventoBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editNome.getText())){
                    isDadosOk = false;
                    editNome.setError("Digite o nome");
                    editNome.requestFocus();
                }
                if(TextUtils.isEmpty(editEmail.getText())){
                    isDadosOk = false;
                    editEmail.setError("Digite o E-mail");
                    editEmail.requestFocus();
                }

                if(TextUtils.isEmpty(editTelefone.getText())){
                    isDadosOk = false;
                    editTelefone.setError("Digite o Telefone");
                    editTelefone.requestFocus();
                }

                if(TextUtils.isEmpty(editCep.getText())){
                    isDadosOk = false;
                    editCep.setError("Digite o CEP");
                    editCep.requestFocus();
                }
                if(TextUtils.isEmpty(editLogradouro.getText())){
                    isDadosOk = false;
                    editLogradouro.setError("Digite o Logradouro");
                    editLogradouro.requestFocus();
                }
                if(TextUtils.isEmpty(editCidade.getText())){
                    isDadosOk = false;
                    editCidade.setError("Digite a Cidade");
                    editCidade.requestFocus();
                }
                if(TextUtils.isEmpty(editBairro.getText())){
                    isDadosOk = false;
                    editBairro.setError("Digite o Bairro");
                    editBairro.requestFocus();
                }
                if(TextUtils.isEmpty(editEstado.getText())){
                    isDadosOk = false;
                    editEstado.setError("Digite o Estado");
                    editEstado.requestFocus();
                }

                if(isDadosOk){
                    cliente.setNome(editNome.getText().toString());
                    cliente.setEmail(editEmail.getText().toString());
                    cliente.setTelefone(editTelefone.getText().toString());
                    cliente.setCep(editCep.getText().toString());
                    cliente.setLogradouro(editLogradouro.getText().toString());
                    cliente.setNumero(editNumero.getText().toString());
                    cliente.setCidade(editCidade.getText().toString());
                    cliente.setBairro(editBairro.getText().toString());
                    cliente.setEstado(editEstado.getText().toString());
                    cliente.setTermosDeUso(chkTermos.isChecked());
                    clienteController.create(cliente);
                    Log.d("SALVANDO", "onClick: Salvo no banco de dados");
                }

            }
        });
    }


}
