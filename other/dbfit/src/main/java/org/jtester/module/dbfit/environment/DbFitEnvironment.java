package org.jtester.module.dbfit.environment;

import java.sql.SQLException;
import java.util.Map;

import org.jtester.module.database.environment.DBEnvironment;
import org.jtester.module.database.environment.normalise.NameNormaliser;
import org.jtester.module.dbfit.model.DbParameterAccessor;

public interface DbFitEnvironment extends DBEnvironment {
	/**
	 * A flag to signal whether the database supports output parameters on
	 * insert commands.
	 * 
	 * If this method returns true, then output parameters will be used to
	 * retrieve possible outputs after an insert. if not, then we can only try
	 * to fetch new IDs using the JDBC support for autogenerated ID retrieval.
	 */
	boolean supportsOuputOnInsert();

	/**
	 * Meta-data retrieval method that provides a list of parameters for a given
	 * stored procedure or function name. The name may contain a schema
	 * qualifier.
	 * 
	 * While implementing, use {@link NameNormaliser} to make sure parameters
	 * are mapped properly.
	 * 
	 * Parameters that map to return values should have an empty string for the
	 * name.
	 */
	Map<String, DbParameterAccessor> getAllProcedureParameters(String procName) throws SQLException;

	/**
	 * Meta-data retrieval method that provides a list of columns a given stored
	 * table or view. The name may contain a schema qualifier.
	 */
	Map<String, DbParameterAccessor> getAllColumns(String tableOrViewName) throws SQLException;

	/**
	 * This method creates an insert command that will be used to populate new
	 * rows in a table.
	 */
	String buildInsertCommand(String tableName, DbParameterAccessor[] accessors) throws SQLException;

	/**
	 * 构造delete语句
	 * 
	 * @param tableName
	 * @param accessors
	 * @return
	 */
	String buildDeleteCommand(String tableName, DbParameterAccessor[] accessors) throws SQLException;

	void teardown() throws SQLException;

	/**
	 * Get the Java class that should be used to store objects of a DB specific
	 * data type.
	 * 
	 * @param dataType
	 *            DB data type name
	 */
	@SuppressWarnings("rawtypes")
	Class getJavaClass(String dataType);
}
