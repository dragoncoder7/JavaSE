public class a {
    
    private static final String mun = null;
    public static void main(String[] args) {
        String requestId = "1";
        String body = "{\"requestId\": " + requestId + "}";
        System.out.println(body);
    }

    public final String getMun() {
        return mun;
    }
}
