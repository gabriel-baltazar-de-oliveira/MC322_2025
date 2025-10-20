import jakarta.xml.bind.JAXBContext;

public class TestJakarta {
    public static void main(String[] args) throws Exception {
        JAXBContext ctx = JAXBContext.newInstance(String.class);
        System.out.println("Jakarta JAXB funcionando!");
    }
}
