package com.version1.TestSpringBootApp.service;

import org.springframework.stereotype.Service;

@Service
public class PersonFactory {

    private final PrintDetailsPersonService printDetailsPersonService;
    private final SaveToDBPersonService saveToDBPersonService;

    private final ReverseService reverseService;

    public PersonFactory(PrintDetailsPersonService printDetailsPersonService, SaveToDBPersonService saveToDBPersonService, ReverseService reverseService) {
        this.printDetailsPersonService = printDetailsPersonService;
        this.saveToDBPersonService = saveToDBPersonService;
        this.reverseService = reverseService;
    }

    public PersonService returnService(String handleCode) {
        if ("db".equals(handleCode)) {
            return saveToDBPersonService;
        } else if ("print".equals(handleCode)) {
            return printDetailsPersonService;
        } else if ("reverse".equals(handleCode)){
            return reverseService;
        }
        return printDetailsPersonService;
    }

}
