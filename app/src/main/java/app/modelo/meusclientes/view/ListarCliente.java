package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class ListarCliente extends Fragment {

    View view;
    TextView txtTitulo;
    EditText editPesquisar;
    ListView lista_clientes;

    List<String> clientes;
    ArrayAdapter<String> clienteAdapter;

    ArrayList<HashMap<String,String>> filtroClientes;

    ClienteController controller;
    Cliente obj;

    public ListarCliente() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.listar_cliente, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.WHITE));
        txtTitulo.setText(R.string.lista_de_clientes);

        controller = new ClienteController(getContext());

        lista_clientes = view.findViewById(R.id.lista_clientes);
        editPesquisar = view.findViewById(R.id.editPesquisar);

        clientes = controller.gerarListViewString();


        clienteAdapter = new ArrayAdapter<>(getContext(),R.layout.listar_cliente_item,R.id.textItem,clientes);

        lista_clientes.setAdapter(clienteAdapter);

        editPesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                ListarCliente.this.clienteAdapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }








}
