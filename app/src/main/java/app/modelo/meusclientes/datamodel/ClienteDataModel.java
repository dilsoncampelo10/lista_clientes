package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {

    public static final String TABLE = "clientes";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";
    public static final String CEP = "cep";
    public static final String LOGRADOURO = "logradouro";
    public static final String NUMERO = "numero";
    public static final String BAIRRO = "bairro";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String TERMOS_DE_USO = "termosDeUso";

    public static String query = "";

    public static String createTable() {
        query+= "CREATE TABLE "+TABLE+" (";
        query+=ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query+=NOME+" TEXT, ";
        query+=EMAIL+" TEXT, ";
        query+=TELEFONE+" TEXT, ";
        query+=CEP+" TEXT, ";
        query+=LOGRADOURO+" TEXT, ";
        query+=NUMERO+" TEXT, ";
        query+=BAIRRO+" TEXT, ";
        query+=CIDADE+" TEXT, ";
        query+=ESTADO+" TEXT, ";
        query+=TERMOS_DE_USO+" TEXT ";
        query+= ")";

        return query;
    }
}
