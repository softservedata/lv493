package data;

public final class GiftCertificateRepository {

    private GiftCertificateRepository() {
    }

    public static String[][] getDefault() {
        return new String[][]{getValidCertificate(),
                getInvalidCertificate(),
                getEmptyCertificate()};
    }

    public static String[] getValidCertificate() {
        return new String[]{"Success: Your gift certificate discount has been applied!",
                new GiftCertificateData().getValidCertificateCode()};
    }

    public static String[] getInvalidCertificate() {
        return new String[]{"Warning: Gift Certificate is either invalid or the balance has been used up!",
                new GiftCertificateData().getInvalidCertificateCode()};
    }

    public static String[] getEmptyCertificate() {
        return new String[]{"Warning: Please enter a gift certificate code!", ""};
    }
}
