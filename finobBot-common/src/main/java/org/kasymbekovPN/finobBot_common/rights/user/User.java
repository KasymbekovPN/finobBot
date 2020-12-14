package org.kasymbekovPN.finobBot_common.rights.user;

import org.kasymbekovPN.finobBot_common.rights.group.Group;

import java.util.Set;

public interface User {
    int getId();
    String getName();
    String getSurname();
    User bind(Group group);
    User unbind(Group group);
    Set<Group> getGroups();
    boolean check(Group group);
}
