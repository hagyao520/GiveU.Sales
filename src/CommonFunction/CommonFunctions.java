package CommonFunction;

import java.util.HashSet;

import java.util.Set; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement; 
import static org.junit.Assert.*; 

public class CommonFunctions {  
       static public WebDriver driver;  
       
       public CommonFunctions()
       {
              //do nothing
       }

       public CommonFunctions(String url)
       {
              // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置 
              //System.setProperty("webdriver.firefox.bin", "E:\\software\\firefox\\firefox.exe"); 
              // 创建一个 FireFox 的浏览器实例 
              driver = new FirefoxDriver();
//              driver.manage().window().maximize();
              driver.get(url);           
       }       

       public void geturl(String url) throws Exception
       {
              driver.get(url);
              Thread.sleep(5000);
       }   

       public void teardown()
       {          
              try {
                     driver.quit();                
              } catch (Exception e) {       
                     e.printStackTrace();
              }
       }

       public String gettext(String type,String location)
       {
              WebElement elem=null;
              if(type.equals("xpath"))
              {
                     elem=driver.findElement(By.xpath(location));                  
              }

              if(type.equals("name"))
              {
                 elem=driver.findElement(By.name(location));                    
              }
              
              if(type.equals("id"))
              {
                     elem=driver.findElement(By.id(location));                
              }
              
              if(type.equals("classname"))
              {
                     elem=driver.findElement(By.className(location));                  
              }

              if(type.equals("css"))
              {
                     elem=driver.findElement(By.cssSelector(location));                 
              }
              
              return elem.getText();
       }

       public void clickitem(String type,String location)
       {
              WebElement elem=null;
              if(type.equals("xpath"))
              {
                     elem=driver.findElement(By.xpath(location));                  
              }

              if(type.equals("classname"))
              {
                     elem=driver.findElement(By.className(location));                  
              }

              if(type.equals("text"))
              {
                     elem=driver.findElement(By.linkText(location));              
              }
              
              if(type.equals("name"))
              {

                     elem=driver.findElement(By.name(location));                  
              }
              elem.click();
       }

       public void clearvalue(String type,String location)
       {
              WebElement elem=null;
              if(type.equals("xpath"))
              {
                     elem=driver.findElement(By.xpath(location));
              }

              if(type.equals("name"))
              {
                 elem=driver.findElement(By.name(location));
              }
              elem.clear();
       }

       public void inputvalue(String type,String location,String text)
       {
              WebElement elem=null;
              if(type.equals("xpath"))
              {
                     elem=driver.findElement(By.xpath(location));           
              }

              if(type.equals("name"))
              {
                     elem=driver.findElement(By.name(location));                  
              }

              if(type.equals("id"))
              {
                     elem=driver.findElement(By.id(location));         
              }
              elem.sendKeys(text);           
       }

       public void checkequal(String str1,String str2)
       {
              assertEquals(str1,str2);
       }

       public void login(String name,String psd) throws Exception
       {
           clickitem("xpath", ".//*[@id='ng-app']/body/div[2]/div/div[2]/a[1]");
           Thread.sleep(3000);
           this.clearvalue("name", "username");
           this.inputvalue("name", "username", name);
           this.clearvalue("name", "user_pwd");
           this.inputvalue("name", "user_pwd", psd);
              Thread.sleep(1000);
              this.clickitem("classname", "zc");
              Thread.sleep(5000);
       }  

       public void logout() throws Exception
       {
              this.geturl("http://www.zhongchou.com/sso-logout");
       }  
}