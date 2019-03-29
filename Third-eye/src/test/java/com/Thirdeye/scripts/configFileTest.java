package com.Thirdeye.scripts;

import com.Thirdeye.endpoints.platform.Endpoints;
import com.Thirdeye.utils.JSONUtilities;
import com.Thirdeye.utils.SetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class configFileTest extends SetUp {


        Logger logger = LogManager.getLogger();

        @SuppressWarnings("unchecked")
        @Test(priority = 1)
        public void testConfigFile() {
            logger.info("started");

            Map configResponse = Endpoints.getconfiguration( 200);
            Assert.assertEquals(configResponse.get("sketches-host"),"https://www.thequint.com");
            logger.info("done ");


        }
        @Test()
        public void testPostCall(){
            logger.info("started");
            JSONObject jbody = JSONUtilities.getJSONFileObject("./src/test/resources/postBody.json");

            Map response = Endpoints.postRequest(201,jbody.toString());
            System.out.println(response);
            Assert.assertEquals(response.get("name"),"Third Eye");
            Assert.assertEquals(response.get("job"),"QA");




        }

    }
