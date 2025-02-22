import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DatabaseConnection {
    boolean isConnected = false;

    void connect() {
        isConnected = true;
        System.out.println("Database connected");
    }

    void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected");
    }

    boolean isConnected() {
        return isConnected;
    }
}

public class DatabaseConnectionTest {
    DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected(), "Connection should be established");
    }

    @Test
    void testConnectionClosed() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Connection should be closed");
    }
}
