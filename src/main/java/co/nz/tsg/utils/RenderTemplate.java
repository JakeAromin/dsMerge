package co.nz.tsg.utils;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenderTemplate {

    public static void main (String args[]) {
        try {
            PebbleEngine engine = new PebbleEngine.Builder().build();
//            PebbleTemplate compiledTemplate = engine.getTemplate("/TSGApps/Unlayer/templates/Layaway Holidays Gone To Bay.htm");
//            PebbleTemplate compiledTemplate = engine.getTemplate("/TSGApps/Unlayer/templates/LayawayHolidaysGoneToBay_Unlayer.htm");
//            PebbleTemplate compiledTemplate = engine.getTemplate("/TSGApps/grapejs-templates/grape_with_loop.html");
            PebbleTemplate compiledTemplate = engine.getTemplate("/TSGApps/GragesJs - Output/Layaway - Standard Welcome - GrapesJs_output.html");

            Map<String, Object> context = new HashMap<>();
            context.put("FIRSTNAME", "Jake");
            context.put("LASTNAME", "Aromin");
            context.put("ADDRESSLINE1", "9 My Home");
            context.put("SUBURB", "Glenfield");
            context.put("CITY", "Northshore City");
            context.put("POSTCODE", "0626");
            context.put("COUNTRY", "New Zealand");
            context.put("STATE", "Auckland");
            context.put("LETTERDATE", "05-Dec-2017");
            context.put("OURNAME", "Tenzing");
            context.put("FACILITYNAME", "TSG - Debit Success");
            context.put("AUTHCODE", "REF12345");
            context.put("ELECTRONICSTATEMENT", "ELEC1234567");
            context.put("FIRSTPAYMENTDATE", "01-JAN-2018");
            context.put("LENGTHOFCONTRACT", "03 Years");
            context.put("PAYMENTMETHOD", "Credit Card");
            context.put("CALLCENTRENUMBER", "+64 210 784 7682");
            context.put("CUSTOMERREF", "REF12345");
            context.put("ADMINFEESTATEMENT", "Test Admin Fee Statement. ");
            context.put("MINTERMSTATEMENT", "Test Min Term Statement");
            context.put("WELCOMELETTERFOOTER", "Welcome footer");
            context.put("OURWEBSITE", "http://www.tenzing.co.nz/");

            List<Payment> paymentList = new ArrayList<>();
            Payment p1 = new Payment("001", "07-12-2017", "Equipments fee");
            Payment p2 = new Payment("002", "07-12-2017", "Admin fee");
            Payment p3 = new Payment("003", "07-12-2017", "Tutorial fee");
            paymentList.add(p1);
            paymentList.add(p2);
            paymentList.add(p3);

            context.put("paymentDetails", paymentList);



            Writer writer = new StringWriter();
            compiledTemplate.evaluate(writer, context);

            String output = writer.toString();
            System.out.println("Output: \n" + output);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
