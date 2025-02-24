
class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature. Please use newFeature() instead.");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// Main class
public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // This should show a warning
        api.newFeature();
    }
}
