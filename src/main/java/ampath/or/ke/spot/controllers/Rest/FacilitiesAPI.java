package ampath.or.ke.spot.controllers.Rest;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ampath.or.ke.spot.services.FacilitiesService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/rest/v1/api/facilities")
@EnableSwagger2
public class FacilitiesAPI {

 @Autowired
    public FacilitiesService facilitiesService;
 ;
   @ResponseBody
    public String EMRlist() throws Exception {
        String output = "";
        Date nowDate = new Date();
        List<Object>  emrs  = facilitiesService.EMRDistribution();

        JSONArray jsonArray = new JSONArray(emrs);


        return jsonArray.toString();
    }
    
}
