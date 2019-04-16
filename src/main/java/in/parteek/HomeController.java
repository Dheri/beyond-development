/**
 * 
 */
package in.parteek;

import java.io.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created on : 2019-04-04, 10:29:58 a.m.
 *
 * @author Parteek Dheri
 */
@RestController
public class HomeController {
	private static final Logger log = LogManager.getLogger(HomeController.class);

	// Auto wiring the properties from application.yml
	@Value("${spring.application.name}")
	private String appName;

	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private String redisPort;

	@RequestMapping(value = { "/", "/home" })
	public Map<String, String> goHome() {
		log.info("The root path was called for {}", appName);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("author", "Parteek");
		map.put("time", new Date().toString());
		return map;
	}

	@RequestMapping("/testAutoWiring")
	public Map<String, String> testAutoWiring() {
		String redisConnection = redisHost + ":" + redisPort;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("redis-connection", redisConnection);
		log.debug("redis connection string is {}", redisConnection);

		return map;
	}

	@RequestMapping(value = "/testLoging")
	public String breakCode() {
		// log warn example
		log.warn("buggy code running");

		// log error example
		try {
			Integer.parseInt("Five");
		} catch (Exception e) {
//			 simple
//			log.error("error occurred: {} \n {}", e.toString(), e.getStackTrace());

			// fancy
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));

			log.error("error occurred: {} \n {}", e.toString(), sw.toString());
		}
		return "meh";

	}

}
