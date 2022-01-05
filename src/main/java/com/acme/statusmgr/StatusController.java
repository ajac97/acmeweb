package com.acme.statusmgr;

import com.acme.statusmgr.beans.ServerStatus;
import com.acme.decorators.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
                                             @RequestParam(value = "details", defaultValue = "") List<String> details) {
        if (!details.isEmpty()) {
            logger.info("Details were provided: " + details);
        }
        return new ServerStatus(counter.incrementAndGet(),
                String.format(template, name), details);
    }

    @RequestMapping("/status/detailed")
    public BaseServerStatus handleStatusRequests2(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                                  @RequestParam(value = "details", defaultValue = "") List<String> details) {
        if (!details.isEmpty()) {
            logger.info("Details were provided: " + details);
        }

        ServerStatus status = new ServerStatus(counter.incrementAndGet(),
                String.format(template, name), details);
        return decorate(status, details);

    }

    private BaseServerStatus decorate(ServerStatus status, List<String> details) {
        BaseServerStatus decorated = status;
        for (String detail : details) {
            switch (detail) {
                case "availableProcessors" -> decorated = new AvailableProcessorsDecorator(decorated);
                case "freeJVMMemory" -> decorated = new AvailableMemoryDecorator(decorated);
                case "totalJVMMemory" -> decorated = new TotalMemoryDecorator(decorated);
                case "jreVersion" -> decorated = new JREVersionDecorator(decorated);
                case "tempLocation" -> decorated = new TempLocationDecorator(decorated);
                default -> throw new BadRequestException();
            }
        }

        return decorated;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Invalid detail requested.")
    public static class BadRequestException extends RuntimeException {}

}


