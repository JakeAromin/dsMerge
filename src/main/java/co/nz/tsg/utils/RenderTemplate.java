package co.nz.tsg.utils;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class RenderTemplate {

    public static void main (String args[]) {
        try {
            PebbleEngine engine = new PebbleEngine.Builder().build();
//            PebbleTemplate compiledTemplate = engine.getTemplate("/TSGApps/Unlayer/templates/Layaway Holidays Gone To Bay.htm");
            PebbleTemplate compiledTemplate = engine.getTemplate("/TSGApps/Unlayer/templates/LayawayHolidaysGoneToBay_Unlayer.htm");

            Map<String, Object> context = new HashMap<>();
            context.put("first_name", "Jake");
            context.put("last_name", "Aromin");
            context.put("address_line_1", "9 My Home");
            context.put("suburb", "Glenfield");
            context.put("city", "Northshore City");
            context.put("post_code", "0626");
            context.put("state", "Auckland");
            context.put("letter_date", "05-Dec-2017");
            context.put("facility_name", "Tenzing");
            context.put("customer_ref", "REF12345");
            context.put("letter_footer", "Sample Footer");

            Writer writer = new StringWriter();
            compiledTemplate.evaluate(writer, context);

            String output = writer.toString();
            System.out.println("Output: \n" + output);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
