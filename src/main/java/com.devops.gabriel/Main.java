/**
 * Created by zaafranigabriel on 23/11/2016.
 */
public class Main {





    public static void main(String[] args) {

        try {
            String nom = System.getProperty("nom","cohen");
            String prenom = System.getProperty("prenom","david");


            Webservices webservices = new Webservices();
            System.out.println(webservices.getCountUser(nom,prenom));
        }catch(NumberFormatException e){
            System.out.println("rien");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
