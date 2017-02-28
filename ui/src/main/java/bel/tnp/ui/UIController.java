package bel.tnp.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dmitry on 2/28/2017.
 */
@RestController
public class UIController {

    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World UI");
        return model;
    }

    @RequestMapping("/samplestring")
    public String sampleString() {
        return "Return sample string";
    }

    @RequestMapping("/samplestringAdmin")
    public String sampleStringAdmin() {
        return "Return sample string Admin";
    }


}
