package org.kasymbekovPN.finobBot_common.rights.user;

import org.kasymbekovPN.finobBot_common.rights.group.Group;

import java.util.HashSet;
import java.util.Set;

public class UserImpl implements User{

    private final int id;
    private final String name;
    private final String surname;
    private final Set<Group> groups = new HashSet<>();

    private UserImpl(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public User bind(Group group) {
        group.bind(this);
        groups.add(group);
        return this;
    }

    @Override
    public User unbind(Group group) {
        group.unbind(this);
        groups.remove(group);
        return this;
    }

    @Override
    public Set<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean check(Group group) {
        return groups.contains(group);
    }
}
