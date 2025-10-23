package org.example;

import com.mongodb.client.model.Filters;
import io.github.cdimascio.dotenv.Dotenv;
import com.mongodb.client.*;
import org.bson.Document;


public class PedidoDeLogin {
    private String uid;
    private String operacao;

    public PedidoDeLogin() {}

    public PedidoDeLogin(String uid, String operacao) {
        this.uid = uid;
        this.operacao = operacao;
    }

    public Usuario getUserData(){
        if(this.uid == null){
            return null;
        }

        Dotenv dotenv = Dotenv.load();
        String uri = dotenv.get("MONGO_URI");
        try(MongoClient client = MongoClients.create(uri)){
            MongoDatabase db = client.getDatabase("sample_horacerta");
            MongoCollection<Document> colecao = db.getCollection("usuario");

            Document doc = colecao.find(Filters.eq("uid", this.uid)).first();
            if(doc == null){return null;}

            Usuario usuario = new Usuario(
                    doc.getObjectId("_id").toHexString(),
                    doc.getString("uid"),
                    doc.getString("nome"),
                    doc.getString("email"),
                    doc.getString("funcao")
            );


            return usuario;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return this.operacao + " " + this.uid;
    }
}