
package bd;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;

public class Cliente {
    OkHttpClient cliente = new OkHttpClient();
    
    public JSONArray get(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        
        try(Response respuesta = cliente.newCall(request).execute()){
            ResponseBody responseBody = respuesta.body();  
            
            if (responseBody != null) {
                    String responseData = responseBody.string();
                    JSONArray jsonArray = new JSONArray(responseData);
                    return jsonArray;
            }else {
                System.out.println("Error al obtener datos. Código de estado: " + respuesta.code());
            }
            return null;
        }catch(Exception e){
            System.out.println("Error: "+e);
            return null;
        }
    }
    
    public boolean post(String url, RequestBody datos){
        Request request = new Request.Builder()
                .url(url)
                .post(datos)
                .build();
        
        try(Response respuesta =  cliente.newCall(request).execute()){
            if (respuesta.isSuccessful()) {
                String responseData = respuesta.body().string();
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
            return false;
        }
    }
    
    public boolean put(String url, RequestBody datos){
        Request request = new Request.Builder()
                .url(url)
                .put(datos)
                .build();
        
        try(Response respuesta =  cliente.newCall(request).execute()){
            if (respuesta.isSuccessful()) {
                String responseData = respuesta.body().string();
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
            return false;
        }
    }
    
    public boolean delete(String url){
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        
        try(Response respuesta =  cliente.newCall(request).execute()){
            if (respuesta.isSuccessful()) {
                String responseData = respuesta.body().string();
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
            return false;
        }
    }
}
