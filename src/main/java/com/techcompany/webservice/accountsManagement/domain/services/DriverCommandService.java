package com.techcompany.webservice.accountsManagement.domain.services;

import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.CreateDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DeleteDriverResource;
import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.UpdateDriverResource;

public interface DriverCommandService {
    Long handle(CreateDriverResource command);

    Long handle(UpdateDriverResource command);

    Long handle(Long deleteDriverCommand);
}
