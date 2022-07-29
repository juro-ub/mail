open module test.de.jro.moduls.mail {
    requires mail;
    requires de.jro.moduls.mail;
    requires transitive org.junit.jupiter.engine;
    requires transitive org.junit.jupiter.api;
    
    exports test.de.jro.moduls.mail;
}
