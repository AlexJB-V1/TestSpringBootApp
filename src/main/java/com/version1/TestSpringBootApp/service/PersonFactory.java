package com.version1.TestSpringBootApp.service;

import org.springframework.stereotype.Service;

@Service
public class PersonFactory {

    private final PrintDetailsPersonService printDetailsPersonService;
    private final SaveToDBPersonService saveToDBPersonService;
    private final ImplementationService implementationService;

    public PersonFactory(
            PrintDetailsPersonService printDetailsPersonService,
            SaveToDBPersonService saveToDBPersonService,
            ImplementationService implementationService) {
        this.printDetailsPersonService = printDetailsPersonService;
        this.saveToDBPersonService = saveToDBPersonService;
        this.implementationService = implementationService;
    }

    public PersonService returnService(String handleCode) {
        if ("db".equals(handleCode)) {
            return saveToDBPersonService;
        } else if ("print".equals(handleCode)) {
            return printDetailsPersonService;
        } else if ("implement service".equals(handleCode)) {
            return implementationService;
        }
        return printDetailsPersonService;
    }

}
