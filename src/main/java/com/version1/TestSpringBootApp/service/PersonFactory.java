package com.version1.TestSpringBootApp.service;

import com.version1.TestSpringBootApp.model.HandleCode;
import org.springframework.stereotype.Service;

@Service
public class PersonFactory {

    private final PrintDetailsPersonService printDetailsPersonService;
    private final SaveToDBPersonService saveToDBPersonService;

    private String SomeString;

    public PersonFactory(PrintDetailsPersonService printDetailsPersonService, SaveToDBPersonService saveToDBPersonService) {
        this.printDetailsPersonService = printDetailsPersonService;
        this.saveToDBPersonService = saveToDBPersonService;
    }

    public PersonService returnService(HandleCode handleCode) {
        switch (handleCode) {
            case database -> {
                return saveToDBPersonService;
            }
            case PRINT -> {
                return printDetailsPersonService;
            }
            case NO_ACTION -> {
                return printDetailsPersonService;
            }
        }
        return printDetailsPersonService;
    }
}
