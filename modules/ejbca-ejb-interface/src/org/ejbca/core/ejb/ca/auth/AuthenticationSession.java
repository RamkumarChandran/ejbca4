/*************************************************************************
 *                                                                       *
 *  EJBCA: The OpenSource Certificate Authority                          *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.ejbca.core.ejb.ca.auth;

import javax.ejb.ObjectNotFoundException;

import org.ejbca.core.model.ca.AuthLoginException;
import org.ejbca.core.model.ca.AuthStatusException;
import org.ejbca.core.model.log.Admin;
import org.ejbca.core.model.ra.UserDataVO;

/**
 * Provides access to authentication system.
 * @version $Id: AuthenticationSession.java 11337 2011-02-10 22:37:15Z jeklund $
 */
public interface AuthenticationSession {

    /**
     * Authenticates a user to the user database and returns the user DN.
     *
     * @param username unique username within the instance
     * @param password password for the user
     *
     * @return UserDataVO, never returns null
     *
     * @throws ObjectNotFoundException if the user does not exist.
     * @throws AuthStatusException If the users status is incorrect.
     * @throws AuthLoginException If the password is incorrect.
     */
    public UserDataVO authenticateUser(Admin admin, String username, String password)
            throws ObjectNotFoundException, AuthStatusException, AuthLoginException;

    /**
     * Set the status of a user to finished, called when a user has been
     * successfully processed. If possible sets users status to
     * UserData.STATUS_GENERATED, which means that the user cannot be
     * authenticated anymore. NOTE: May not have any effect of user database is
     * remote. User data may contain a counter with nr of requests before used
     * should be set to generated. In this case this counter will be decreased,
     * and if it reaches 0 status will be generated.
     * 
     * @throws ObjectNotFoundException if the user does not exist.
     */
    public void finishUser(UserDataVO data) throws ObjectNotFoundException;

}
