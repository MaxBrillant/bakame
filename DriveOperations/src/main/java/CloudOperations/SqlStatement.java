package CloudOperations;

import java.sql.Statement;

public interface SqlStatement extends Statement {

	public static void execute(String query) {
		executeQuery(query);
	}
}
