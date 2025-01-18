package com.jpa.ecomm_ops.configuration;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class DbNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        if (name == null) {
            return null;
        }
        String newName = name.getText().toUpperCase();
        return Identifier.toIdentifier(newName, name.isQuoted());
    }

}