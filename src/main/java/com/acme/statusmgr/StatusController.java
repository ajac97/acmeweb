package com.acme.statusmgr;

import com.acme.statusmgr.beans.ServerStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();
    Logger logger = LoggerFactory.getLogger("StuffImInterestedIn");

    /**
     * Process a request for server status information
     *
     * @param name optional param identifying the requestor
     * @return a ServerStatus object containing the info to be returned to the requestor
     */
    @RequestMapping("/status")
    public ServerStatus handleStatusRequests(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                             @RequestParam(value = "details", defaultValue ="") List<String> details) {
        if (!details.isEmpty()) {
            logger.info("Details were provided: " + details);
        }
        return new ServerStatus(counter.incrementAndGet(),
                String.format(template, name), details);
    }
}
