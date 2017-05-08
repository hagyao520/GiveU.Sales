package CommonFunction;

import java.io.File;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import org.w3c.dom.*; 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory; 

public class DataProvide {      
    public Document doc;
    public void init(String filename) throws Exception
    {
       File inputXml = new File(new File(filename).getAbsolutePath());
       // documentBuilderΪ������ֱ��ʵ����(��XML�ļ�ת��ΪDOM�ļ�)
       DocumentBuilder db = null;
       DocumentBuilderFactory dbf = null;
       try {
           // ����documentBuilderFactory����
           dbf = DocumentBuilderFactory.newInstance();
           // ����db������documentBuilderFatory�����÷���documentBuildr����
           db = dbf.newDocumentBuilder();
           // �õ�һ��DOM�����ظ�document����
           doc = (Document)db.parse(inputXml);
         }
         catch (Exception e) {
              e.printStackTrace();
         }    
    }   

    @DataProvider(name="Test_xml_dataprovider")
    public Object[][] providerMethod(Method method){
       return new Object[][]{new Object[]{doc}};
    }
}