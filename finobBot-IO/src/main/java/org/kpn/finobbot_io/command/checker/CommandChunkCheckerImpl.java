package org.kpn.finobbot_io.command.checker;

public class CommandChunkCheckerImpl implements CommandChunkChecker {

    private final String type;
    private final String value;
    private final boolean optional;

    public CommandChunkCheckerImpl(String type, String value, boolean optional) {
        this.type = type;
        this.value = value;
        this.optional = optional;
    }
}
