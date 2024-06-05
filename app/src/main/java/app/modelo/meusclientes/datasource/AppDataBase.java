package app.modelo.meusclientes.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {
    public static final String DB_NAME = "meus_clientes";
    public static final int DB_VERSION = 1;
    SQLiteDatabase db;
    public AppDataBase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        Log.d(AppUtil.TAG,"CRIANDO BANCO");
        db = getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.createTable());
        Log.d(AppUtil.TAG,"CRIANDO TABELA: "+ClienteDataModel.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean create(String table, ContentValues contentValues){
        db = getWritableDatabase();
        boolean response = false;
        try{
            response = db.insert(table,null,contentValues) > 0;
        } catch (Exception e){
            Log.d(AppUtil.TAG, "insert: "+e.getMessage());

        }

        return  response;
    }

    public boolean delete(String table, int id){
        db = getWritableDatabase();
        boolean response = false;
        try {
            response = db.delete(table,"id=?",new String[]{String.valueOf(id)}) > 0;

        } catch (Exception e){
            Log.d(AppUtil.TAG, "delete: "+e.getMessage());
        }

        return response;
    }

    public boolean update(String table, ContentValues contentValues){
        db = getWritableDatabase();
        boolean response = false;
        try{
            response = db.update(table,contentValues,"id=?",new String[]{String.valueOf(contentValues.get("id"))}) > 0;

        } catch (Exception e){
            Log.d(AppUtil.TAG, "update: "+e.getMessage());
        }

        return response;
    }

    @SuppressLint("Range")
    public List<Cliente> getAll(String table){
        db = getWritableDatabase();
        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;
        String sql = "SELECT * FROM "+table;
        Cursor cursor;
        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do {
                obj = new Cliente();
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));

                clientes.add(obj);

                Log.i("Listar", "getAllClientes: "+obj.getNome());

            } while (cursor.moveToNext());
        }

        return clientes;
    }
}
