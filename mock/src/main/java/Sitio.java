public class Sitio {

    String id;
    String name;
    String country_id;
    String sale_fees_mode;
    int mercadopago_version;
    String default_currency_id;
    String immediate_payment;
    String[] payment_method_ids;

    public Sitio (String id){
        this.id=id;
        name="Peru";
        country_id="PE";
        sale_fees_mode="not_free";
        mercadopago_version=3;
        default_currency_id="PEN";
        immediate_payment="optional";
        payment_method_ids= new String[]{"MPEWC", "MPEMO", "MPECH", "MPEPO", "MPECC", "MPEOT"};
    }
}
