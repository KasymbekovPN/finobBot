package org.kasymbekovPN.finobBot_common.rights.group;

import org.kasymbekovPN.finobBot_common.rights.user.User;

import java.util.Set;

public interface Group {
    Group bind(User user);
    Group unbind(User user);
    Set<User> getUsers();
    boolean check(User user);
}
