public class TransformerDemo {

    public static void main(String[] args) throws Exception {
        XSLTransform.main(new String[] {"xml/metro.xsl", "xml/metro.xml", "xml/metro.html"});
        XSLTransform.main(new String[] {"xml/metro_upd.xsl", "xml/metro_upd.xml", "xml/metro_upd.html"});
    }
}