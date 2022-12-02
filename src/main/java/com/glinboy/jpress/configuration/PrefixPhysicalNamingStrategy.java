package com.glinboy.jpress.configuration;

import java.util.function.Function;
import java.util.regex.Pattern;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PrefixPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

	private static final long serialVersionUID = -951206089374933110L;
	private final String TABLE_NAME_PREFIX = "jp_%s";
	private final String COLUMN_NAME_PREFIX = "jp_clm_%s";

	private final String camelRegex = "(?<=[a-zA-Z])[A-Z]";

	@Override
	public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
		Identifier newIdentifier = new Identifier(
				TABLE_NAME_PREFIX.formatted(camelToSnakeCase.apply(logicalName.getText())), logicalName.isQuoted());
		return super.toPhysicalTableName(newIdentifier, context);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment context) {
		Identifier newIdentifier = new Identifier(
				COLUMN_NAME_PREFIX.formatted(camelToSnakeCase.apply(logicalName.getText())), logicalName.isQuoted());
		return super.toPhysicalColumnName(newIdentifier, context);
	}

	Function<String, String> camelToSnakeCase = string -> Pattern.compile(camelRegex).matcher(string)
			.replaceAll(match -> "_" + match.group().toLowerCase());
}
