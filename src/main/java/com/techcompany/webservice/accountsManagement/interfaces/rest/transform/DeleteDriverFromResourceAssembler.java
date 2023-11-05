package com.techcompany.webservice.accountsManagement.interfaces.rest.transform;

import com.techcompany.webservice.accountsManagement.interfaces.rest.resources.DeleteDriverResource;

public class DeleteDriverFromResourceAssembler {
    public static Long toCommandFromResource(DeleteDriverResource resource) {
        return resource.driverId();
    }
}
