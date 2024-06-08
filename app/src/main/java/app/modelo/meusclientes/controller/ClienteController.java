package app.modelo.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.datasource.AppDataBase;
import app.modelo.meusclientes.model.Cliente;


public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean create(Cliente obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE,obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.CEP,obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO,obj.getLogradouro());
        dadoDoObjeto.put(ClienteDataModel.NUMERO,obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO,obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE,obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO,obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS_DE_USO,obj.isTermosDeUso());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());


        return create(ClienteDataModel.TABLE, dadoDoObjeto);


    }

    @Override
    public boolean delete(int id) {
        return delete(ClienteDataModel.TABLE,id);

    }

    @Override
    public boolean update(Cliente obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());



        return update(ClienteDataModel.TABLE,dadoDoObjeto);

    }

    @Override
    public List<Cliente> getAll() {

        return getAll(ClienteDataModel.TABLE);

    }

    public List<String> gerarListViewString(){
        List<String> clientes = new ArrayList<>();
        for (Cliente obj: getAll()) {
            clientes.add(obj.getId()+", "+obj.getNome());
        }

        return clientes;
    }

}